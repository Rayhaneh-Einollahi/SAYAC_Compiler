package main.codeGenerator;

import java.util.*;

public class RegisterManager {
    private final boolean[] used = new boolean[16];

    public RegisterManager() {
        used[0] = true;
        used[15] = true;
    }

    public int allocate() {
        for (int i = 1; i < 15; i++) {
            if (!used[i]) {
                used[i] = true;
                return i;
            }
        }
        throw new RuntimeException("No free registers available!");
    }

    public void free(int reg) {
        if (reg <= 0 || reg >= 15)
            throw new IllegalArgumentException("Cannot free r" + reg);
        used[reg] = false;
    }

    public String regName(int reg) {
        return "r" + reg;
    }
}
