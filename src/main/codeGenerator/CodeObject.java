package main.codeGenerator;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CodeObject {
    private final List<String> code;
    private final Set<String> usedReg;

    /**
     * if the result of this part of code is stored in a register the value of resultReg would be non-null.

     */
    private String resultVar = null;

    public CodeObject(){
        code = new ArrayList<String>();
        usedReg = new HashSet<String>();
    }
    public String getResultVar() {
        return resultVar;
    }

    public void setResultVar(String resultReg) {
        this.resultVar = resultReg;
    }

    public List<String> getUsedRegisters(){
        return new ArrayList<>(usedReg);
    }
    public void addCode(CodeObject other){
        code.addAll(other.code);
        this.usedReg.addAll(other.usedReg);
    }

    public void addUsedRegister(String register){
        usedReg.add(register);
    }

    public void addCode(List<String> instructions) {
        code.addAll(instructions);
    }

    public void addCode(String other){
        code.add(other);
    }


    public String toString() {

        StringWriter sw = new StringWriter();

        for (String ir : code) {
            sw.write(ir);
            sw.write("\n");
        }
        return sw.toString();
    }
}
