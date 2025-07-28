package main.codeGenerator;


import java.util.HashSet;
import java.util.Set;

public class LabelManager {
    private final Set<String> labels = new HashSet<>();
//    private final String prefix;
    private int counter = 0;
    static final private String funcPrefix = "func_";
    static final private String funcReturnPrefix = "func_ret_";

    public LabelManager(/*String prefix = " "*/) {
//        this.prefix = prefix;
    }

    public String generateLabel() {
        String label;
        do {
            label = /*prefix + */ "_" + counter++;
        } while (labels.contains(label));
        labels.add(label);
        return label;
    }

    public String generateFunctionLabel(String funcName){
        return funcPrefix  + funcName;
    }

    public String generateFunctionReturnLabel(String funcName){
        return funcReturnPrefix + funcName;
    }
    public boolean contains(String label) {
        return labels.contains(label);
    }

    public Set<String> getAllLabels() {
        return new HashSet<>(labels);
    }
}