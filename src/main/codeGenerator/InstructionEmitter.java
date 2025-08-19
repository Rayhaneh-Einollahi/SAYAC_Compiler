package main.codeGenerator;

public class InstructionEmitter {
    private final boolean debugMode = true;
    public enum Color {
        RESET,
        // Regular colors
        BLACK ,
        RED   ,
        GREEN ,
        YELLOW,
        BLUE  ,
        PURPLE,
        CYAN  ,
        WHITE ,

        // Bright colors
        BRIGHT_BLACK  ,
        BRIGHT_RED    ,
        BRIGHT_GREEN  ,
        BRIGHT_YELLOW ,
        BRIGHT_BLUE   ,
        BRIGHT_PURPLE ,
        BRIGHT_CYAN   ,
        BRIGHT_WHITE  ;

        @Override
        public String toString() {
            return switch (this) {
                case RESET   -> "\u001B[0m";
                case BLACK   -> "\u001B[30m";
                case RED     -> "\u001B[31m";
                case GREEN   -> "\u001B[32m";
                case YELLOW  -> "\u001B[33m";
                case BLUE    -> "\u001B[34m";
                case PURPLE  -> "\u001B[35m";
                case CYAN    -> "\u001B[36m";
                case WHITE   -> "\u001B[37m";

                case BRIGHT_BLACK  -> "\u001B[90m";
                case BRIGHT_RED    -> "\u001B[91m";
                case BRIGHT_GREEN  -> "\u001B[92m";
                case BRIGHT_YELLOW -> "\u001B[93m";
                case BRIGHT_BLUE   -> "\u001B[94m";
                case BRIGHT_PURPLE -> "\u001B[95m";
                case BRIGHT_CYAN   -> "\u001B[96m";
                case BRIGHT_WHITE  -> "\u001B[97m";
            };
        }
    }

    private String colorIfDebug(String text, Color color) {
        return debugMode ? color + text + Color.RESET : text;
    }

    private String emit(String opcode, Object... operands) {
        StringBuilder line = new StringBuilder(opcode);
        for (Object op : operands) {
            line.append(" ").append(op.toString());
        }
        return line.toString();

    }

    /**
     * This method is for storing the registers used in a command so that
     * we keep track of all the registers used in a codeObject.
     * The purpose of storing the registers used in a CodeObject is
     * solely for FunctionDefinition, so when calling only the registers
     * of that function is stored on the stack and then reverted back.
     */
    private void storeUsedReg(CodeObject code, Register... regs) {
        for (Register r : regs) {
            if(r.purpose == Register.Purpose.OP)
                code.addUsedRegister(r);
        }
    }

    public String emitLabel(String label){
        return colorIfDebug(label, Color.YELLOW) + ":";
    }

    public CodeObject emitComment(String comment, Color color){
        CodeObject code =  new CodeObject();
        if(debugMode)
            code.addCode(color + "    " + "//" + comment + "//" + Color.RESET);
        return code;
    }

    /**
     * Returns an MSI instruction that will print: MSI IMM dest
     * Models: Stores the value of immediate to the dest register :#dest = IMM
     *<p>
     * @param imm immediate that comes as an int value
     * @param destReg destination register
     */
    public CodeObject MSI(int imm, Register destReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, destReg);
        code.addCode(this.emit("MSI", String.valueOf(imm), destReg));
        return code;
    }

    /**
     * SW is not a default instruction of SAYAC processor. To handle Reference to memory using offset
     * this method generates three line of code. editing adrReg (sp in our case) to add with offset and after storing
     * revert it to the original value.
     */
    public CodeObject SW(Register valueReg, int offset, Register adrReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg, adrReg);
        code.addCode(ADI(offset, adrReg));
        code.addCode(STR(valueReg, adrReg));
        code.addCode(ADI(-offset, adrReg));
        return code;
    }
    /**
     * LW is not a default instruction of SAYAC processor. To handle Reference to memory using offset
     * this method generates three line of code. editing adrReg (sp in our case) to add with offset and after storing
     * revert it to the original value.
     */
    public CodeObject LW(Register adrReg, int offset, Register destReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, adrReg, destReg);
        code.addCode(ADI(offset, adrReg));
        code.addCode(LDR(destReg, adrReg));
        code.addCode(ADI(-offset, adrReg));
        return code;
    }
    /**
     * STI purpose is to store a Register Value in an immediate address,
     * STI is not an official instruction of SAYAC processor, so to avoid using
     * OP Registers (Operation Registers R1 - R9) R14 register will be used to store the value of
     * immediate and later stored to the valueReg stored in the location of R14. This convertion is handled by assembler
     * */
    public CodeObject STI(Register valueReg, int addressImm){
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg);
        code.addCode(emit("STI", valueReg, String.valueOf(addressImm)));
        return code;
    }

    public CodeObject STR(Register valueReg, Register adrReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg, adrReg);
        code.addCode(emit("STR", valueReg, adrReg));
        return code;
    }

    public CodeObject LDI(int addressImm, Register destReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, destReg);
        code.addCode(emit("LDI", String.valueOf(addressImm), destReg));
        return code;
    }

    public CodeObject LDR(Register adrReg, Register destReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, adrReg, destReg);
        code.addCode(emit("LDR", adrReg, destReg));
        return code;
    }

    public CodeObject ADR(Register valueReg2, Register valueReg1, Register destReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("ADR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject ADI(int imm, Register destReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, destReg);
        code.addCode(emit("ADI", String.valueOf(imm) , destReg));
        return code;
    }


    public CodeObject CMR(Register reg1, Register reg2){
        CodeObject code = new CodeObject();
        storeUsedReg(code, reg1, reg2);
        code.addCode(emit("CMR", reg1, reg2));
        return code;
    }


    public CodeObject CMI(int imm, Register reg2){
        CodeObject code = new CodeObject();
        storeUsedReg(code, reg2);
        code.addCode(emit("CMI", String.valueOf(imm), reg2));
        return code;
    }

    public String BRR(String operator, String label) {
        return emit("BRR", operator, colorIfDebug(label, Color.YELLOW));
    }
    /**
     * JMP jumps without storing the return line
     */
    public CodeObject JMR(Register jmpReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, jmpReg);
        code.addCode(emit("JMR", "0", jmpReg, "R0"));
        return code;
    }

    public  String JMP(String label, Register returnReg) {
        return this.emit("JMP", colorIfDebug(label, Color.YELLOW), returnReg);
    }

    public CodeObject SUR(Register valueReg2, Register valueReg1, Register destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("SUR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject ANR(Register valueReg2, Register valueReg1, Register destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("ANR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject ANI(int imm, Register destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, destReg);
        code.addCode(emit("ANI", String.valueOf(imm), destReg));
        return code;
    }

    public CodeObject MUL(Register valueReg2, Register valueReg1, Register destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("MUL", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject DIV(Register valueReg2, Register valueReg1, Register destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("DIV", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject SAR(Register valueReg2, Register valueReg1, Register destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("SAR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject NTR(Register valueReg, Register destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg, destReg);
        code.addCode(emit("NTR", valueReg, destReg));
        return code;
    }


    public CodeObject NTR2(Register valueReg, Register destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg, destReg);
        code.addCode(emit("NTR2", valueReg, destReg));
        return code;
    }

    public CodeObject SUI(int imm, Register destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, destReg);
        code.addCode(emit("SUI", String.valueOf(imm), destReg));
        return code;
    }

    public CodeObject LDB(Register destReg, Register offsetReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, destReg, offsetReg);
        code.addCode(emit("LDB", destReg, offsetReg));
        return code;
    }


}

