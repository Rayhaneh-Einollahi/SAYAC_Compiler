package main.codeGenerator;

import java.util.ArrayList;
import java.util.List;

public class InstructionEmitter {
    private final List<String> code = new ArrayList<>();

    public void emit(String opcode, String... operands) {
        StringBuilder line = new StringBuilder(opcode);
        for (String op : operands) {
            line.append(" ").append(op);
        }
        code.add(line.toString());
    }
    public void emitLoadAddress(String reg, String label) {
        emitRaw("ldr " + reg + " =" + label);
    }

    public void emitRaw(String line) {
        code.add(line);
    }

    /**
     * Returns an MSI instruction that will print: MSI IMM dest
     * Models: Stores the value of immediate to the dest register :#dest = IMM
     *<p>
     * @param imm immediate that comes as an int value
     * @param destReg destination register
     */
    public void MSI(String imm, String destReg){
        this.emit("MSI", String.valueOf(imm), destReg);
    }

    public void SW(String valueReg, String adrReg, String imm){
        this.emit(""); //Todo : generate instructions based on sayac limitation to handle immediate
    }

    public void LW(String valueReg, String adrReg, String imm){
        this.emit(""); //Todo : generate instructions based on sayac limitation to handle immediate
    }


    public void STR(String valueReg, String adrReg){
        this.emit("STR", valueReg, adrReg);
    }

    public void LDR(String adrReg, String destReg){
        this.emit("LDR", adrReg, destReg);
    }


    public void ADR(String valueReg2, String valueReg1, String destReg){
        this.emit("ADR", valueReg2, valueReg1);
    }

    public void ADI(String imm, String destReg){
        this.emit("ADR", destReg);
    }

    public void Ret(){
        this.JMR( false, "ra", "r0");
    }

    public void JMR(boolean storeReturn, String jmpReg, String storeReturnReg){
        this.emit("JMR", String.valueOf(storeReturn), "ra", "r0");
    }


    public List<String> getCode() {
        return code;
    }

    public void printCode() {
        code.forEach(System.out::println);
    }
}

