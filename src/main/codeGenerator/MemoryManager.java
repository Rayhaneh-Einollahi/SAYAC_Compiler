package main.codeGenerator;

import java.util.HashMap;
import java.util.Map;

public class MemoryManager {

    private static final int MEMORY_SIZE = 256;
    private static final int STACK_START = MEMORY_SIZE;

    private final byte[] memory;

    private int globalPointer;
    private int stackPointer;
    private int framePointer;
    private int returnAddress;

    private final Map<String, Integer> globalVars;
    private final Map<String, Integer> localVars;

    public MemoryManager() {
        this.memory = new byte[MEMORY_SIZE];
        this.globalPointer = 0;
        this.stackPointer = STACK_START;
        this.framePointer = STACK_START;
        this.returnAddress = -1;
        this.globalVars = new HashMap<>();
        this.localVars = new HashMap<>();
    }

    public int allocateGlobal(String varName, int size) {
        int address = globalPointer;
        if (globalPointer + size > stackPointer) {
            throw new RuntimeException("Out of memory for globals!");
        }
        globalVars.put(varName, address);
        globalPointer += size;
        return address;
    }

    public int getGlobalAddress(String varName) {
        if (!globalVars.containsKey(varName)) {
            throw new RuntimeException("Global variable not found: " + varName);
        }
        return globalVars.get(varName);
    }

    public void enterFunction(int localVarSize) {
        push((byte) (framePointer & 0xFF));
        framePointer = stackPointer;
        stackPointer -= localVarSize;
        localVars.clear();
    }

    public void exitFunction() {
        stackPointer = framePointer;
        framePointer = pop(); // we can push and pop in int :)
    }

    public int allocateLocal(String varName, int size) {
        stackPointer -= size;
        if (stackPointer <= globalPointer) {
            throw new RuntimeException("Stack overflow during local allocation!");
        }
        localVars.put(varName, stackPointer);
        return stackPointer;
    }

    public int getLocalAddress(String varName) {
        if (!localVars.containsKey(varName)) {
            throw new RuntimeException("Local variable not found: " + varName);
        }
        return localVars.get(varName);
    }

    private void push(byte value) {
        stackPointer -= 1;
        if (stackPointer <= globalPointer) {
            throw new RuntimeException("Stack overflow!");
        }
        memory[stackPointer] = value;
    }

    private int pop() {
        if (stackPointer >= MEMORY_SIZE) {
            throw new RuntimeException("Stack underflow!");
        }
        byte value = memory[stackPointer];
        stackPointer += 1;
        return Byte.toUnsignedInt(value);
    }

    public void writeMemory(int address, byte value) {
        checkAddress(address);
        memory[address] = value;
    }

    public byte readMemory(int address) {
        checkAddress(address);
        return memory[address];
    }

    public int getSP() { return stackPointer; }
    public int getFP() { return framePointer; }

    private void checkAddress(int address) {
        if (address < 0 || address >= MEMORY_SIZE) {
            throw new IllegalArgumentException("Invalid memory address: " + address);
        }
    }
}
