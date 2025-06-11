package main.codeGenerator;


import java.util.HashSet;
import java.util.Set;

public class LabelGenerator {
    private final Set<String> labels = new HashSet<>();
    private final String prefix;
    private int counter = 0;

    public LabelGenerator(String prefix) {
        this.prefix = prefix;
    }

    public String generateLabel() {
        String label;
        do {
            label = prefix + "_" + counter++;
        } while (labels.contains(label));
        labels.add(label);
        return label;
    }

    public boolean contains(String label) {
        return labels.contains(label);
    }

    public Set<String> getAllLabels() {
        return new HashSet<>(labels); // Return a copy to avoid modification
    }
}