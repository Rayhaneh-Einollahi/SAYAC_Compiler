package main.codeGenerator;

import java.util.*;

public class MemoryManager {
    private static final int DATA_REGION_START = 0; //0x7000;
    private static final int DATA_REGION_END = 5000; //0xDFFF;
    private static final int STACK_POINTER_BEGIN = 5000; //0xDFFF;

    private int nextGlobalAddr = DATA_REGION_START;
    private int frameOffset = -2;

    private final Map<String, Integer> globalAddresses = new HashMap<>();
    private Map<String, Integer> localOffsets;
    private final Map<String, Map<String, Integer>> functionsLocalOffsets = new HashMap<>();
    private final Map<String, Integer> globalSizes = new HashMap<>();
    private Map<String, Integer> localSizes;
    private final Map<String, Map<String, Integer>> functionsLocalSizes = new HashMap<>();
    private final Map<String, Integer> globalStarts = new HashMap<>();
    private Map<String, ArrayList<Integer>> Array_steps = new HashMap<>();

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

    public void putArrayStep(String name, ArrayList<Integer> steps) {
        Array_steps.put(name, steps);
    }

    public ArrayList<Integer> getArrayStep(String name) {
        return Array_steps.get(name);
    }

    public int getSTACK_POINTER_BEGIN() {
        return STACK_POINTER_BEGIN;
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

        localOffsets.put(name, frameOffset);
        frameOffset -= alignedSize;
        localSizes.put(name, alignedSize);

        return frameOffset + alignedSize;
    }

    public int getNumberOfElements(String name) {
        if(localSizes != null) {
            Integer sz = localSizes.get(name) / 2;
            if(sz != null) return sz;
        }
        return 1;
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
        frameOffset = -2;
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
                .orElse(-2);
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

    public List<String> getState() {
        List<String> lines = new ArrayList<>();
        lines.add("Memory State:");
        lines.add("-------------");

        // Globals
        lines.add("Globals (absolute addresses):");
        if (globalAddresses.isEmpty()) {
            lines.add("  (none)");
        } else {
            for (var e : globalAddresses.entrySet()) {
                String line = String.format("  %-15s -> 0x%04X (%d)",
                        e.getKey(), e.getValue(), e.getValue());
                lines.add(line);
            }
        }

        lines.add("Locals (FP-relative offsets):");
        if (localOffsets == null || localOffsets.isEmpty()) {
            lines.add("  (none)");
        } else {
            for (var e : localOffsets.entrySet()) {
                String line = String.format("  %-15s -> %d", e.getKey(), e.getValue());
                lines.add(line);
            }
        }

        lines.add("Current frameOffset: " + frameOffset);

        return lines;
    }


}
