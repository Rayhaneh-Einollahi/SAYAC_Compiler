package main.codeGenerator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MemoryManager {
    private static final int DATA_REGION_START = 0x7000;
    private static final int DATA_REGION_END = 0xDFFF;

    private int nextGlobalAddr = DATA_REGION_START;
    private int frameOffset = 0;

    private final Map<String, Integer> globalAddresses = new HashMap<>();
    private Map<String, Integer> localOffsets;
    private final Map<String, Map<String, Integer>> functionslocalOffsets = new HashMap<>();

    public boolean hasVariable(String varname){
        if (globalAddresses.containsKey(varname)) return true;
        return localOffsets.containsKey(varname);
    }
    public boolean isGlobal(String varname){
        return globalAddresses.containsKey(varname);
    }
    public boolean isLocal(String varname){
        return localOffsets.containsKey(varname);
    }

    public int allocateGlobal(String name, int size) {
        if (globalAddresses.containsKey(name)) {
            return globalAddresses.get(name);
        }
        int alignedSize = align(size);
        int addr = nextGlobalAddr;
        if (addr + alignedSize - 1 > DATA_REGION_END) {
            throw new RuntimeException("Out of data memory for global allocation.");
        }
        globalAddresses.put(name, addr);
        nextGlobalAddr += alignedSize;
        return addr;
    }

    public int getGlobalAddress(String name) {
        Integer addr = globalAddresses.get(name);
        if (addr == null) {
            throw new RuntimeException("Global variable not found: " + name);
        }
        return addr;
    }

    public int allocateLocal(String name, int size) {
        if (localOffsets.containsKey(name)) {
            return localOffsets.get(name);
        }
        int alignedSize = align(size);
        frameOffset -= alignedSize;
        localOffsets.put(name, frameOffset);
        return frameOffset;
    }

    public int getLocalOffset(String name) {
        Integer offset = localOffsets.get(name);
        if (offset == null) {
            int size = 2;
            offset = allocateLocal(name, size);
        }
        return offset;
    }

    public void setFunctionArgOffset(String name, int offset) {
        localOffsets.put(name, offset);
    }

    public void beginFunctionSetOffset(String name) {
        frameOffset = 0;
        localOffsets = new HashMap<>();
        functionslocalOffsets.put(name, localOffsets);

    }
    public void beginFunction(String name){
        localOffsets = functionslocalOffsets.get(name);
        frameOffset = Collections.min(localOffsets.values()) + 2;
    }

    private int align(int size) {
        return (size + 1) & ~1;
    }

    public int getCurrentOffset() {
        return  frameOffset;
    }

    public void setCurrentOffset(int scopesBase) {
        frameOffset = scopesBase;
    }
}
