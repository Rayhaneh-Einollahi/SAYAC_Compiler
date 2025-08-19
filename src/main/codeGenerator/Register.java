package main.codeGenerator;

public class Register {
    public int id;
    public final Purpose purpose;
    private boolean isLock = false;
    private boolean isFree = true;
    private String varName;
    public enum Purpose {
        ZR, FP, SP, RA, RT, OP
    }



    Register(int R, Purpose purpose){
        this.id = R;
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
        return "R" + id;
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
