package main.codeGenerator;

public class Register {
    public static boolean AliasMode = true;
    public int id;
    public final Purpose purpose;
    private boolean isLock = false;
    private boolean isFree = true;
    private String varName;

    public int getId() {
        return id;
    }

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
        if(AliasMode && purpose != Purpose.OP)
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

    public static class State {
        public final boolean isLock;
        public final boolean isFree;
        public final String varName;
        public final int id;

        private State(boolean isLock, boolean isFree, String varName, int id) {
            this.isLock = isLock;
            this.isFree = isFree;
            this.varName = varName;
            this.id = id;
        }
    }

    public State saveState() {
        return new State(isLock, isFree, varName, id);
    }

    public void restoreState(State state) {
        this.isLock = state.isLock;
        this.isFree = state.isFree;
        this.varName = state.varName;
        this.id = state.id;
    }
}
