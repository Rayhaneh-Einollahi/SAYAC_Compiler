package main.codeGenerator;

public class RegisterAction {
    public enum Type { LOAD_G, LOAD_L, SPILL_G,SPILL_L }
    public final Type type;
    public final String register;
    public final int offset;
    public final int address;

    public RegisterAction(Type type, String register, int offset, int address) {
        this.type = type;
        this.register = register;
        this.offset = offset;
        this.address = address;
    }
}
