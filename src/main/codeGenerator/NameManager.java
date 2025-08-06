package main.codeGenerator;

public class NameManager {
    private int tmpCounter = 0;
    private int uniqueIdCounter = 0;

    public String generateUniqueName(String baseName, int scopeDepth) {
        return baseName + "@" + scopeDepth + "#" + (uniqueIdCounter++);
    }

    public String newTmpVarName() {
        return "tmp" + (tmpCounter++);
    }

    public boolean isTmp(String varName){
        return varName.startsWith("tmp");
    }
}
