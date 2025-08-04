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

    private String generateUniqueLabel(String prefix) {
        String label;
        do {
            label = prefix + counter++;
        } while (labels.contains(label));
        labels.add(label);
        return label;
    }

    public String generateNextLabel(){return generateUniqueLabel("Next_");}

    public String generateAfterIfLabel(){return generateUniqueLabel("After_If_");}

    public String generateIfLabel(){return generateUniqueLabel("If_");}

    public String generateElseLabel(){return generateUniqueLabel("Else_");}

    public String generateWhileConditionLabel() {
        return generateUniqueLabel("while_condition_");
    }

    public String generateWhileBodyLabel() {
        return generateUniqueLabel("while_body_");
    }

    public String generateWhileEndLabel() {
        return generateUniqueLabel("while_end_");
    }

    public String generateForConditionLabel() {
        return generateUniqueLabel("for_condition_");
    }

    public String generateForBodyLabel() {
        return generateUniqueLabel("for_body_");
    }

    public String generateForEndLabel() {
        return generateUniqueLabel("for_end_");
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