package main.codeGenerator;

import java.util.*;

public class MemoryManager {
    private int currentOffset = 0;
    private Deque<Integer> frameStack = new ArrayDeque<>();
    private Map<String, Integer> variableMap = new HashMap<>();

    public void beginFrame() {
        frameStack.push(currentOffset);
        currentOffset = 0;
        variableMap.clear();
    }

    public void endFrame() {
        if (frameStack.isEmpty()) throw new RuntimeException("No frame to pop");
        currentOffset = frameStack.pop();
        variableMap.clear();
    }

    public int allocateLocal(String varName, int size) {
        currentOffset += size;
        variableMap.put(varName, -currentOffset);
        return -currentOffset;
    }

    public int getOffset(String varName) {
        if (!variableMap.containsKey(varName))
            throw new RuntimeException("Variable not allocated: " + varName);
        return variableMap.get(varName);
    }

    public String stackAccess(int offset) {
        return offset + "(sp)";
    }
}
