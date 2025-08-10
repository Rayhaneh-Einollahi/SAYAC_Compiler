package main.codeGenerator;

public class InstructionEmitter {
    private CodeObject code;
    public InstructionEmitter(){
        code = new CodeObject();
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
    private void storeUsedReg(String... regs) {
        code = new CodeObject();
        for (String r : regs) {
            code.addUsedRegister(r);
        }
    }

    public String emitRaw(String line) {
        return line;
    }

    public String emitLabel(String label){
        return label + ":";
    }

    /**
     * Returns an MSI instruction that will print: MSI IMM dest
     * Models: Stores the value of immediate to the dest register :#dest = IMM
     *<p>
     * @param imm immediate that comes as an int value
     * @param destReg destination register
     */
    public CodeObject MSI(int imm, String destReg){
        storeUsedReg(destReg);
        code.addCode(this.emit("MSI", String.valueOf(imm), destReg));
        return code;
    }

    /**
     * SW is not a default instruction of SAYAC processor. To handle Reference to memory using offset
     * this method generates three line of code. editing adrReg (sp in our case) to add with offset and after storing
     * revert it to the original value.
     */
    public CodeObject SW(String valueReg, int offset, String adrReg){
        storeUsedReg(valueReg, adrReg);
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
        storeUsedReg(adrReg, destReg);
        code.addCode(ADI(offset, adrReg));
        code.addCode(LDR(destReg, adrReg));
        code.addCode(ADI(-offset, adrReg));
        return code;
    }


    public CodeObject STR(String valueReg, String adrReg){
        storeUsedReg(valueReg, adrReg);
        code.addCode(emit("STR", valueReg, adrReg));
        return code;
    }

    public CodeObject LDR(String adrReg, String destReg){
        storeUsedReg(adrReg, destReg);
        code.addCode(emit("LDR", adrReg, destReg));
        return code;
    }

    public CodeObject ADR(String valueReg2, String valueReg1, String destReg){
        storeUsedReg(valueReg2, valueReg1, destReg);
        code.addCode(emit("ADR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject ADI(int imm, String destReg){
        storeUsedReg(destReg);
        code.addCode(emit("ADR", String.valueOf(imm) , destReg));
        return code;
    }


    public CodeObject CMR(String reg1, String reg2){
        storeUsedReg(reg1, reg2);
        code.addCode(emit("CMR", reg1, reg2));
        return code;
    }


    public CodeObject CMI(int imm, String reg2){
        storeUsedReg(reg2);
        code.addCode(emit("CMI", String.valueOf(imm), reg2));
        return code;
    }

    public String BRR(String operator, String label) {
        return emit("BRR", operator, label);
    }
    /**
     * JMP jumps without storing the return line
     */
    public CodeObject JMR(String jmpReg){
        storeUsedReg(jmpReg);
        code.addCode(emit("JMR", "0", jmpReg, "r0"));
        return code;
    }

    /**
     * JMPS jump and store the return value
     */
    public CodeObject JMRS(String jmpReg, String storeReturnReg){
        storeUsedReg(jmpReg, storeReturnReg);
        code.addCode(emit("JMR", "1", jmpReg, storeReturnReg));
        return code;
    }

    /**
     * notice JMP and JMPS are macros and will be converted to JMI JMR and JMRS after interpreting the labels in assembler
     */
    public  String JMP(String label) {
        return this.emit("JMP", label);
    }

    public  CodeObject JMPS(String label, String returnReg) {
        storeUsedReg(returnReg);
        code.addCode(emit("JMP", label, returnReg));
        return code;
    }
    public CodeObject SUR(String valueReg2, String valueReg1, String destReg) {
        storeUsedReg(valueReg2, valueReg1, destReg);
        code.addCode(emit("SUR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject ANR(String valueReg2, String valueReg1, String destReg) {
        storeUsedReg(valueReg2, valueReg1, destReg);
        code.addCode(emit("ANR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject ANI(int imm, String destReg) {
        storeUsedReg(destReg);
        code.addCode(emit("ANI", String.valueOf(imm), destReg));
        return code;
    }

    public CodeObject MUL(String valueReg2, String valueReg1, String destReg) {
        storeUsedReg(valueReg2, valueReg1, destReg);
        code.addCode(emit("MUL", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject DIV(String valueReg2, String valueReg1, String destReg) {
        storeUsedReg(valueReg2, valueReg1, destReg);
        code.addCode(emit("DIV", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject SAR(String valueReg2, String valueReg1, String destReg) {
        storeUsedReg(valueReg2, valueReg1, destReg);
        code.addCode(emit("SAR", valueReg2, valueReg1, destReg));
        return code;
    }

    public CodeObject NTR(String valueReg, String destReg) {
        storeUsedReg(valueReg, destReg);
        code.addCode(emit("NTR", valueReg, destReg));
        return code;
    }


    public CodeObject NTR2(String valueReg, String destReg) {
        storeUsedReg(valueReg, destReg);
        code.addCode(emit("NTR2", valueReg, destReg));
        return code;
    }

    public CodeObject SUI(int imm, String destReg) {
        storeUsedReg(destReg);
        code.addCode(emit("SUI", String.valueOf(imm), destReg));
        return code;
    }


}

