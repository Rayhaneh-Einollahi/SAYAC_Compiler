package main.codeGenerator;

public class CodeGenContext {
    public final RegisterManager registerManager;
    public final MemoryManager memoryManager;
    public final InstructionEmitter emitter;

    public CodeGenContext(RegisterManager regMan, MemoryManager memMan, InstructionEmitter emitter) {
        this.registerManager = regMan;
        this.memoryManager = memMan;
        this.emitter = emitter;
    }
}
