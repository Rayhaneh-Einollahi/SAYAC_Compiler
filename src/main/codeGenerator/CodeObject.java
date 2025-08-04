package main.codeGenerator;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CodeObject {
    private List<String> code;
    private Set<String> usedReg;    // Todo: to keep the used registers in each code object to have the registers used in
                                    // in each scope.
    /**
     * if the result of this part of code is stored in a register the value of resultReg would be non-null.

     */
    private String resultVar = null;

    public CodeObject(){
        code = new ArrayList<String>();
    }
    public String getResultVar() {
        return resultVar;
    }

    public void setResultVar(String resultReg) {
        this.resultVar = resultReg;
    }

    public void addCode(CodeObject other){
        code.addAll(other.code);
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
