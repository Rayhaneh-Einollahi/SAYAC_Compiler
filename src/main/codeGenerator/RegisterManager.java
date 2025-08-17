package main.codeGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegisterManager {
    public enum RegisterState { FREE, USED, RESERVED }
    private final Map<String, RegisterState> registerStates = new HashMap<>();
    private final List<String> allRegisters = Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11");
    private final MemoryManager memoryManager;
    private final Set<String> pinnedRegisters = new HashSet<>();
    private  Map<String, String> regToVar = new HashMap<>();
    private  Map<String, String> varToReg = new HashMap<>();
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
        return getFreeRegister(List.of(varName), actions);
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

        if (memoryManager.hasVariable(varName)) {
            return loadSpilled(varName,null, actions);
        }

        return getFreeRegister(List.of(varName), actions);
    }


    public String allocateTwoForRead(String mainVar,String helperVar, List<RegisterAction> actions) {

        if (varToReg.containsKey(mainVar)) {
            incrementUseCount(mainVar);
            String mainReg = varToReg.get(mainVar);
            if (isNextFree(mainReg))
                return mainReg;
            if (allRegisters.indexOf(mainReg)!= allRegisters.size()-1){
                handleSpill(List.of(helperVar), List.of(getNextReg(mainReg)), actions).getFirst();
                return mainReg;
            }
        }
        if (varToReg.containsKey(helperVar)) {
            incrementUseCount(helperVar);
            String helperReg = varToReg.get(helperVar);
            if (isPrevFree(helperVar))
                return getPrevReg(helperReg);
            if (allRegisters.indexOf(helperReg)!= 0){
                handleSpill(List.of(mainVar), List.of(getPrevReg(helperReg)), actions).getFirst();
                return getPrevReg(helperReg);
            }
        }

        if (memoryManager.hasVariable(mainVar) || memoryManager.hasVariable(helperVar)) {
            return loadSpilled(mainVar,helperVar, actions);
        }
        return getFreeRegister(List.of(mainVar, helperVar),actions);

    }

    public String getFreeRegister(List<String> varNames, List<RegisterAction> actions){
        int cnt = varNames.size();
        List<String> regs = findFreeRegister(cnt);
        if (regs != null) {
            String firstReg = regs.getFirst();
            for(String var: varNames){
                assignRegister(firstReg, var);
                incrementUseCount(var);
            }
            return firstReg;
        }
        List<String> spillRegs = chooseSpillCandidate(cnt);
        return handleSpill(varNames,spillRegs, actions).getFirst();
    }

    public void freeRegister(String varName) {
        if (!varToReg.containsKey(varName)) return;

        String reg = varToReg.get(varName);
        regToVar.remove(reg);
        varToReg.remove(varName);
        registerStates.put(reg, RegisterState.FREE);
        varUseCounts.remove(varName);
    }

    public String loadSpilled(String var1, String var2, List<RegisterAction> actions) {
        String needLoadVar = (var2 != null && memoryManager.hasVariable(var2)) ? var2 : var1;

        if (!memoryManager.hasVariable(needLoadVar)) {
            throw new RuntimeException("Variable not spilled: " + needLoadVar);
        }
        incrementUseCount(needLoadVar);

        String reg = null;
        if(memoryManager.isLocal(needLoadVar)){
            int offset = memoryManager.getLocalOffset(needLoadVar);
            reg = getFreeRegister(Stream.of(var1, var2).filter(Objects::nonNull).toList(), actions);
            actions.add(new RegisterAction(RegisterAction.Type.LOAD_L, reg, offset,0));
        }
        else if(memoryManager.isGlobal(needLoadVar)){
            int address = memoryManager.getGlobalAddress(needLoadVar);
            reg = getFreeRegister(Stream.of(var1, var2).filter(Objects::nonNull).toList(), actions);
            actions.add(new RegisterAction(RegisterAction.Type.LOAD_G, reg, 0,address));
        }
        return reg;
    }


    public String getRegisterByVar(String varName){
        return varToReg.get(varName);
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

    }


    public boolean isPrevFree(String regName) {
        int index = allRegisters.indexOf(regName);
        if (index == -1 || index == 0) {
            return false;
        }
        String nextReg = allRegisters.get(index - 1);
        return registerStates.get(nextReg) == RegisterState.FREE;
    }
    public String getPrevReg(String regName) {
        int index = allRegisters.indexOf(regName);
        if (index == -1 || index == 0) {
            return null;
        }
        return allRegisters.get(index - 1);
    }
    public boolean isNextFree(String regName) {
        int index = allRegisters.indexOf(regName);
        if (index == -1 || index == allRegisters.size() - 1) {
            return false;
        }
        String nextReg = allRegisters.get(index + 1);
        return registerStates.get(nextReg) == RegisterState.FREE;
    }

    public String getNextReg(String regName) {
        int index = allRegisters.indexOf(regName);
        if (index == -1 || index == allRegisters.size() - 1) {
            return null;
        }
        return allRegisters.get(index + 1);
    }

    private List<String> findFreeRegister(int cnt) {
        List<String> freeRegs = new ArrayList<>();

        for (int i = 0; i <= allRegisters.size() - cnt; i++) {
            boolean allFree = true;

            for (int j = 0; j < cnt; j++) {
                String reg = allRegisters.get(i + j);
                if (registerStates.get(reg) != RegisterState.FREE) {
                    allFree = false;
                    break;
                }
            }

            if (allFree) {
                for (int j = 0; j < cnt; j++) {
                    freeRegs.add(allRegisters.get(i + j));
                }
                return freeRegs;
            }
        }
        return null;
    }

    private List<String> handleSpill(List<String> varNames, List<String> spillRegs, List<RegisterAction> actions) {
        int cnt = varNames.size();
        for (int i = 0; i < cnt; i++) {
            String spillReg = spillRegs.get(i);
            String varName = varNames.get(i);

            String spilledVar = regToVar.get(spillReg);
            if(memoryManager.isGlobal(spilledVar)){
                int address = memoryManager.getGlobalAddress(spilledVar);
                actions.add(new RegisterAction(RegisterAction.Type.SPILL_G, spillReg, 0,address));
            }
            else{
                int offset = memoryManager.getLocalOffset(spilledVar);
                actions.add(new RegisterAction(RegisterAction.Type.SPILL_G, spillReg, offset, 0));
            }


            regToVar.remove(spillReg);
            varToReg.remove(spilledVar);
            registerStates.put(spillReg, RegisterState.FREE);

            assignRegister(spillReg, varName);
            incrementUseCount(varName);
        }


        return spillRegs;
    }

    public void assignRegister(String reg, String varName) {
        //if it had a register before:
        String prevReg = varToReg.get(varName);
        if(prevReg!=null){
            freeRegister(varName);
        }
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
    private List<String> chooseSpillCandidate(int cnt) {
        int minUsageSum = Integer.MAX_VALUE;
        List<String> bestBlock = null;

        for (int i = 0; i <= allRegisters.size() - cnt; i++) {
            List<String> block = allRegisters.subList(i, i + cnt);

            boolean allEligible = block.stream().allMatch(reg ->
                    registerStates.get(reg) == RegisterState.USED &&
                            !pinnedRegisters.contains(reg)
            );

            if (!allEligible) continue;

            int usageSum = 0;
            for (String reg : block) {
                String var = regToVar.get(reg);
                int count = varUseCounts.getOrDefault(var, Integer.MAX_VALUE);
                usageSum += count;
            }

            if (usageSum < minUsageSum) {
                minUsageSum = usageSum;
                bestBlock = new ArrayList<>(block);
            }
        }

        if (bestBlock == null) {
            throw new RuntimeException("No register block to spill");
        }

        return bestBlock;
    }

    public void clearRegisters() {
        this.allRegisters.forEach(reg -> registerStates.put(reg, RegisterState.FREE));
        regToVar = new HashMap<>();
        varToReg = new HashMap<>();
        varUseCounts = new HashMap<>();
    }

}