package main.codeGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class RegisterManager {
    public enum RegisterState { FREE, USED, RESERVED }
    private final Map<String, RegisterState> registerStates = new HashMap<>();
    private final List<String> allRegisters = Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11");
    private final MemoryManager memoryManager;
    private final Set<String> pinnedRegisters = new HashSet<>();
    private  Map<String, String> regToVar = new HashMap<>();
    private  Map<String, String> varToReg = new HashMap<>();
    private  Map<String, Integer> spilledVars = new HashMap<>();
    private  Map<String, Integer> varUseCounts = new HashMap<>();


    public RegisterManager(MemoryManager memoryManager) {
        this.memoryManager = memoryManager;
        this.allRegisters.forEach(reg -> registerStates.put(reg, RegisterState.FREE));
    }


    /**
     * get a register for the purpose of writing into it that refers to the variable varName
     */
    public String allocateForWrite(String varName, List<RegisterAction> actions){
        if (varToReg.containsKey(varName)) {
            incrementUseCount(varName);
            return varToReg.get(varName);
        }
        spilledVars.remove(varName);

        String reg = findFreeRegister();
        if (reg != null) {
            assignRegister(reg, varName);
            incrementUseCount(varName);
            return reg;
        }
        return handleSpill(varName, actions);

    }
    /**
     * get a register for the purpose of reading from it that refers to the variable varName
     * so if it's not in a register we undo spilling it from memory
     */
    public String allocateForRead(String varName, List<RegisterAction> actions) {

        if (varToReg.containsKey(varName)) {
            incrementUseCount(varName);
            return varToReg.get(varName);
        }

        if (spilledVars.containsKey(varName)) {
            return loadSpilled(varName, actions);
        }

        String reg = findFreeRegister();
        if (reg != null) {
            assignRegister(reg, varName);
            incrementUseCount(varName);
            return reg;
        }
        return handleSpill(varName, actions);
    }


    public void freeRegister(String varName) {
        if (!varToReg.containsKey(varName)) return;

        String reg = varToReg.get(varName);
        regToVar.remove(reg);
        varToReg.remove(varName);
        registerStates.put(reg, RegisterState.FREE);
        varUseCounts.remove(varName);
    }


    public String loadSpilled(String varName, List<RegisterAction> actions) {
        if (!spilledVars.containsKey(varName)) {
            throw new RuntimeException("Variable not spilled: " + varName);
        }

        int offset = spilledVars.remove(varName);
        String reg = allocateForRead(varName, actions);
        actions.add(new RegisterAction(RegisterAction.Type.LOAD, reg, varName, offset));
        incrementUseCount(varName);
        return reg;
    }


    /**
     * Allocate a specific register (for special purposes)
     */
    public String allocateSpecificRegister(String reg, String varName) {
        if (registerStates.get(reg) != RegisterState.FREE) {
            throw new RuntimeException("Register " + reg + " is not free");
        }

        assignRegister(reg, varName);
        incrementUseCount(varName);
        return reg;
    }
    public void freeRegisterByReg(String reg) {
        if (!regToVar.containsKey(reg)) return;

        String varName = regToVar.get(reg);
        freeRegister(varName);
    }

    /**
     * Reserve a register so it won't be allocated
     */
    public void reserveRegister(String reg) {
        if (regToVar.containsKey(reg)) {
            throw new RuntimeException("Cannot reserve register " + reg + " - it's currently in use");
        }
        registerStates.put(reg, RegisterState.RESERVED);
        pinnedRegisters.add(reg);
    }

    /**
     * Release a reserved register
     */
    public void releaseRegister(String reg) {
        if (pinnedRegisters.contains(reg)) {
            registerStates.put(reg, RegisterState.FREE);
            pinnedRegisters.remove(reg);
        }
    }
    public Set<String> getUsedRegisters() {
        return regToVar.keySet();
    }

    public Set<String> getSpilledVariables() {
        return spilledVars.keySet();
    }

    public Set<String> getFreeRegisters() {
        return registerStates.entrySet().stream()
                .filter(e -> e.getValue() == RegisterState.FREE)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
    public List<String> getAllRegisters() {
        return allRegisters;
    }


    public void printState() {
        System.out.println("\nRegister State:");
        System.out.println("---------------");

        for (String reg : allRegisters) {
            String var = regToVar.getOrDefault(reg, "-");
            String state = registerStates.get(reg).toString();
            if (pinnedRegisters.contains(reg)) {
                state += " (pinned)";
            }
            System.out.printf("%-4s -> %-10s %s%n", reg, var, state);
        }

        if (!spilledVars.isEmpty()) {
            System.out.println("\nSpilled Variables:");
            spilledVars.forEach((var, offset) ->
                    System.out.printf("%s -> [FP %d]%n", var, offset));
        }
    }



    private String findFreeRegister() {
        for (String reg : allRegisters) {
            if (registerStates.get(reg) == RegisterState.FREE) {
                return reg;
            }
        }
        return null;
    }

    private String handleSpill(String varName, List<RegisterAction> actions) {
        String spillReg = chooseSpillCandidate();
        String spilledVar = regToVar.get(spillReg);

        int offset = memoryManager.getLocalOffset(spilledVar);
        actions.add(new RegisterAction(RegisterAction.Type.SPILL, spillReg, spilledVar, offset));

        regToVar.remove(spillReg);
        varToReg.remove(spilledVar);
        spilledVars.put(spilledVar, offset);
        registerStates.put(spillReg, RegisterState.FREE);

        assignRegister(spillReg, varName);
        incrementUseCount(varName);
        return spillReg;
    }

    private void assignRegister(String reg, String varName) {
        regToVar.put(reg, varName);
        varToReg.put(varName, reg);
        registerStates.put(reg, RegisterState.USED);
    }

    private void incrementUseCount(String varName) {
        varUseCounts.put(varName, varUseCounts.getOrDefault(varName, 0) + 1);
    }

    /* Todo: include the registers needed for the operation in calling this function
        so they are kept untouched
     */
    private String chooseSpillCandidate() {
        // Don't spill pinned registers
        List<String> candidates = allRegisters.stream()
                .filter(reg -> registerStates.get(reg) == RegisterState.USED)
                .filter(reg -> !pinnedRegisters.contains(reg))
                .toList();

        if (candidates.isEmpty()) {
            throw new RuntimeException("No register to spill");
        }

        return candidates.stream()
                .min(Comparator.comparingInt(reg ->
                        varUseCounts.getOrDefault(regToVar.get(reg), Integer.MAX_VALUE)))
                .orElse(candidates.getFirst());
    }

    public void clearRegisters() {
        this.allRegisters.forEach(reg -> registerStates.put(reg, RegisterState.FREE));
        regToVar = new HashMap<>();
        varToReg = new HashMap<>();
        spilledVars = new HashMap<>();
        varUseCounts = new HashMap<>();
    }

}