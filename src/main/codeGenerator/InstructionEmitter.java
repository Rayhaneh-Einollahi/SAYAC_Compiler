package main.codeGenerator;

import java.util.ArrayList;
import java.util.List;

public class InstructionEmitter {
    private final List<String> code = new ArrayList<>();

    public void emit(String opcode, String... operands) {
        StringBuilder line = new StringBuilder(opcode);
        for (String op : operands) {
            line.append(" ").append(op);
        }
        code.add(line.toString());
    }
    public void emitLoadAddress(String reg, String label) {
        emitRaw("ldr " + reg + " =" + label);
    }

    public void emitRaw(String line) {
        code.add(line);
    }

    public List<String> getCode() {
        return code;
    }

    public void printCode() {
        code.forEach(System.out::println);
    }
}

