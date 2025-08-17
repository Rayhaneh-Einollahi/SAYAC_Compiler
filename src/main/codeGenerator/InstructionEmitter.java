package main.codeGenerator;

public class InstructionEmitter {
    private final boolean debugMode = true;
    public static class Color {
        public static final String RESET  = "\u001B[0m";

        // Regular colors
        public static final String BLACK  = "\u001B[30m";
        public static final String RED    = "\u001B[31m";
        public static final String GREEN  = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE   = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN   = "\u001B[36m";
        public static final String WHITE  = "\u001B[37m";

        // Bright colors
        public static final String BRIGHT_BLACK  = "\u001B[90m";
        public static final String BRIGHT_RED    = "\u001B[91m";
        public static final String BRIGHT_GREEN  = "\u001B[92m";
        public static final String BRIGHT_YELLOW = "\u001B[93m";
        public static final String BRIGHT_BLUE   = "\u001B[94m";
        public static final String BRIGHT_PURPLE = "\u001B[95m";
        public static final String BRIGHT_CYAN   = "\u001B[96m";
        public static final String BRIGHT_WHITE  = "\u001B[97m";
    }
    private String colorIfDebug(String text, String color) {
        return debugMode ? color + text + Color.RESET : text;
    }

    private String emit(String opcode, String... operands) {
        StringBuilder line = new StringBuilder(opcode);
        for (String op : operands) {
            line.append(" ").append(op);
        }
        return line.toString();

    }
    public void emitLoadAddress(String reg, String label) {
        emitRaw("ldr " + reg + " =" + label);
    }

    /**
     * This method is for storing the registers used in a command so that
     * we keep track of all the registers used in a codeObject.
     * The purpose of storing the registers used in a CodeObject is
     * solely for FunctionDefinition, so when calling only the registers
     * of that function is stored on the stack and then reverted back.
     */
    private void storeUsedReg(CodeObject code, String... regs) {
        for (String r : regs) {
            code.addUsedRegister(r);
        }
    }

    public String emitRaw(String line) {
        return line;
    }

    public String emitLabel(String label){
        return colorIfDebug(label, Color.YELLOW) + ":";
    }

    public CodeObject emitComment(String comment, String color){
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
    public CodeObject MSI(int imm, String destReg){
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
    public CodeObject SW(String valueReg, int offset, String adrReg){
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
    public CodeObject LW(String adrReg, int offset, String destReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, adrReg, destReg);
        code.addCode(ADI(offset, adrReg));
        code.addCode(LDR(destReg, adrReg));
        code.addCode(ADI(-offset, adrReg));
        return code;
    }


    public CodeObject STR(String valueReg, String adrReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg, adrReg);
        code.addCode(emit("STR", valueReg, adrReg));
        return code;
    }

    public CodeObject LDR(String adrReg, String destReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, adrReg, destReg);
        code.addCode(emit("LDR", adrReg, destReg));
        return code;
    }

    public CodeObject ADR(String valueReg2, String valueReg1, String destReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("ADR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject ADI(int imm, String destReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, destReg);
        code.addCode(emit("ADI", String.valueOf(imm) , destReg));
        return code;
    }


    public CodeObject CMR(String reg1, String reg2){
        CodeObject code = new CodeObject();
        storeUsedReg(code, reg1, reg2);
        code.addCode(emit("CMR", reg1, reg2));
        return code;
    }


    public CodeObject CMI(int imm, String reg2){
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
    public CodeObject JMR(String jmpReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, jmpReg);
        code.addCode(emit("JMR", "0", jmpReg, "R0"));
        return code;
    }

    /**
     * JMPS jump and store the return value
     */
    public CodeObject JMRS(String jmpReg, String storeReturnReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, jmpReg, storeReturnReg);
        code.addCode(emit("JMR", "1", jmpReg, storeReturnReg));
        return code;
    }

    /**
     * notice JMP and JMPS are macros and will be converted to JMI JMR and JMRS after interpreting the labels in assembler
     */
    public  String JMP(String label) {
        return this.emit("JMP", colorIfDebug(label, Color.YELLOW));
    }

    public  CodeObject JMPS(String label, String returnReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, returnReg);
        code.addCode(emit("JMPS", colorIfDebug(label, Color.YELLOW), returnReg));
        return code;
    }
    public CodeObject SUR(String valueReg2, String valueReg1, String destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("SUR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject ANR(String valueReg2, String valueReg1, String destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("ANR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject ANI(int imm, String destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, destReg);
        code.addCode(emit("ANI", String.valueOf(imm), destReg));
        return code;
    }

    public CodeObject MUL(String valueReg2, String valueReg1, String destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("MUL", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject DIV(String valueReg2, String valueReg1, String destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("DIV", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject SAR(String valueReg2, String valueReg1, String destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg2, valueReg1, destReg);
        code.addCode(emit("SAR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject NTR(String valueReg, String destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg, destReg);
        code.addCode(emit("NTR", valueReg, destReg));
        return code;
    }


    public CodeObject NTR2(String valueReg, String destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, valueReg, destReg);
        code.addCode(emit("NTR2", valueReg, destReg));
        return code;
    }

    public CodeObject SUI(int imm, String destReg) {
        CodeObject code = new CodeObject();
        storeUsedReg(code, destReg);
        code.addCode(emit("SUI", String.valueOf(imm), destReg));
        return code;
    }

    public CodeObject LDB(String destReg, String offsetReg){
        CodeObject code = new CodeObject();
        storeUsedReg(code, destReg, offsetReg);
        code.addCode(emit("LDB", destReg, offsetReg));
        return code;
    }


}

