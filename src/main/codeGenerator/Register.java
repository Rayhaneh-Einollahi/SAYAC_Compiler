package main.codeGenerator;

public class Register {
    public String name;
    public final Purpose purpose;
    private boolean isLock = false;
    private boolean isFree = true;
    private String varName;
    public enum Purpose {
        ZR, FP, SP, RA, RT, OP
    }



    Register(String name, Purpose purpose){
        this.name = name;
        this.purpose = purpose;
    }

    public void setVarName(String name){
        this.varName = name;
    }

    public String getVarName(){
        return varName;
    }

    public void clearVarName(){
        this.varName = null;
    }

    @Override
    public String toString() {
        if(purpose != Purpose.OP)
            return purpose.toString();
        return name;
    }

    public void free(){
        isFree = true;
    }

    public void use(){
        isFree = false;
    }

    public void lock(){
        isLock = true;
    }
    public void unlock(){
        isLock = false;
    }
    public boolean isLock(){
        return isLock;
    }

    public boolean isFree() {
        return isFree;
    }
}
