package main.codeGenerator;

import java.util.HashMap;
import java.util.Map;

public class MemoryManager {
    private static final int DATA_REGION_START = 0x7000;
    private static final int DATA_REGION_END = 0xDFFF;

    private int nextGlobalAddr = DATA_REGION_START;
    private int frameOffset = 0;

    private final Map<String, Integer> globalAddresses = new HashMap<>();
    private final Map<String, Integer> localOffsets = new HashMap<>();

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
            int size = 2; // int
            offset = allocateLocal(name, size);
        }
        return offset;
    }

    public int setFunctionArgOffset(String name, int offset) { //Todo: for function argument which are set before
        localOffsets.put(name, offset);
    }

    public void beginFunction() {
        frameOffset = 0;
        localOffsets.clear();
    }

    private int align(int size) {
        return (size + 1) & ~1;
    }
}
