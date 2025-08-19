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
    private final Map<String, Map<String, Integer>> functionsLocalOffsets = new HashMap<>();
    private final Map<String, Integer> globalSizes = new HashMap<>();
    private Map<String, Integer> localSizes;
    private final Map<String, Map<String, Integer>> functionsLocalSizes = new HashMap<>();
    private final Map<String, Integer> globalStarts = new HashMap<>();
    private Map<String, Integer> localStarts = new HashMap<>();

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
        globalSizes.put(name, alignedSize);
        globalStarts.put(name, alignedSize + addr);
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
        localStarts.put(name, frameOffset);
        frameOffset -= alignedSize;
        localOffsets.put(name, frameOffset);
        localSizes.put(name, alignedSize);

        return frameOffset;
    }

    public int getLocalStart(String name) {
        if (localStarts != null) {
            Integer sz = localStarts.get(name);
            if (sz != null) return sz;
        }
        return 0;
    }

    public int getLocalSize(String name) {
        if (localSizes != null) {
            Integer sz = localSizes.get(name);
            if (sz != null) return sz;
        }
        return 2;
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
        localSizes = new HashMap<>();
        functionsLocalOffsets.put(name, localOffsets);
        functionsLocalSizes.put(name, localSizes);

    }
    public void beginFunction(String name){
        localOffsets = functionsLocalOffsets.get(name);
        localSizes = functionsLocalSizes.get(name);
        frameOffset = localOffsets.keySet().stream()
                .mapToInt(k -> localOffsets.get(k) - localSizes.get(k))
                .min()
                .orElse(0) - 2;
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

    public void printState() {
        System.out.println("\nMemory State:");
        System.out.println("-------------");

        // Globals
        System.out.println("Globals (absolute addresses):");
        if (globalAddresses.isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (var e : globalAddresses.entrySet()) {
                System.out.printf("  %-15s -> 0x%04X (%d)%n",
                        e.getKey(), e.getValue(), e.getValue());
            }
        }

        // Locals
        System.out.println("\nLocals (FP-relative offsets):");
        if (localOffsets == null || localOffsets.isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (var e : localOffsets.entrySet()) {
                System.out.printf("  %-15s -> %d%n", e.getKey(), e.getValue());
            }
        }

        System.out.println("\nCurrent frameOffset: " + frameOffset);
    }


}
