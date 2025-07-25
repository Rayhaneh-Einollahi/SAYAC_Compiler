package main.codeGenerator;

import java.util.HashMap;
import java.util.Map;

public class GlobalVariableTable {
    private Map<String, Integer> globalMap = new HashMap<>();

    public void addGlobal(String varName, int initialValue) {
        globalMap.put(varName, initialValue);
    }

    public String getGlobalLabel(String varName) {
        if (!globalMap.containsKey(varName))
            throw new RuntimeException("Global variable not declared: " + varName);
        return varName;
    }

    public boolean isGlobal(String varName) {
        return globalMap.containsKey(varName);
    }

    public void emitGlobalDeclarations(InstructionEmitter emitter) {
        emitter.emitRaw(".data");

        for (String var : globalMap.keySet()) {
            int initialValue = globalMap.get(var);
            emitter.emitRaw(var + ": .word " + initialValue);
        }

        emitter.emitRaw(".text");
    }

}
