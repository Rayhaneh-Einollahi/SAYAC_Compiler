package main.codeGenerator;

public class RegisterAction {
    public enum Type { LOAD, SPILL }
    public final Type type;
    public final String register;
    public final String variable;
    public final int offset; // For memory operations

    public RegisterAction(Type type, String register, String variable, int offset) {
        this.type = type;
        this.register = register;
        this.variable = variable;
        this.offset = offset;
    }
}
