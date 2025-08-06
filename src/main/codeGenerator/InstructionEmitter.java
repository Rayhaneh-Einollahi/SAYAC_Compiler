package main.codeGenerator;


public class InstructionEmitter {
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
    public String MSI(String imm, String destReg){
        return this.emit("MSI", String.valueOf(imm), destReg);
    }

    public String SW(String valueReg, String adrReg, int imm){
        return this.emit(""); //Todo : generate instructions based on sayac limitation to handle immediate
    }

    public String LW(String valueReg, String adrReg, int imm){
        return this.emit(""); //Todo : generate instructions based on sayac limitation to handle immediate
    }


    public String STR(String valueReg, String adrReg){
        return this.emit("STR", valueReg, adrReg);
    }

    public String LDR(String adrReg, String destReg){
        return this.emit("LDR", adrReg, destReg);
    }


    public String ADR(String valueReg2, String valueReg1, String destReg){
        return this.emit("ADR", valueReg2, valueReg1, destReg);
    }

    public String ADI(int imm, String destReg){
        return this.emit("ADR", String.valueOf(imm) , destReg);
    }

    public String CMR(String reg1, String reg2){
        return this.emit("CMR", reg1, reg2);
    }

    public String CMI(int imm, String reg2){
        return this.emit("CMI", String.valueOf(imm), reg2);
    }
    public String BRR(String operator, String label) {
        return this.emit("BRR", operator, label);
    }
    /**
     * JMP jumps without storing the return line
     */
    public String JMR(String jmpReg){
        return this.emit("JMR", "0", jmpReg, "r0");
    }

    /**
     * JMPS jump and store the return value
     */
    public String JMRS(String jmpReg, String storeReturnReg){
        return this.emit("JMR", "1", jmpReg, storeReturnReg);
    }

    /**
     * notice JMP and JMPS are macros and will be converted to JMI JMR and JMRS after interpreting the labels in assembler
     */
    public  String JMP(String label) {
        return this.emit("JMP", label);
    }

    public  String JMPS(String label, String returnReg) {
        return this.emit("JMP", label, returnReg);


    }
    public String SUR(String valueReg2, String valueReg1, String destReg){
        return this.emit("SUR", valueReg2, valueReg1, destReg);
    }



    public String ANR(String valueReg2, String valueReg1, String destReg){
        return this.emit("ANR",  destReg ,valueReg2, valueReg1);
    }
    public String ANI(int imm, String destReg){
        return this.emit("ANI", String.valueOf(imm) , destReg);
    }
    public String MUL(String destReg, String valueReg2, String valueReg1){return this.emit("MUL", valueReg2, valueReg1);}
    public String Ret(){
        return this.JMR("ra");}

    public String CMI(String Imm, String valueReg){return this.emit("CMI", Imm, valueReg);}
    public String DIV(String resReg, String dividandReg, String divisorReg){return this.emit("DIV", resReg ,dividandReg, divisorReg);}
    public String SAR(String resReg, String reg1 , String reg2){return this.emit("SAR", resReg, reg1 , reg2);}
    public String NTR(String resReg , String reg){return this.emit("NTR", resReg, reg);}
    public String SUI(int imm, String destReg){
        return this.emit("SUI", String.valueOf(imm) , destReg);
    }

}

