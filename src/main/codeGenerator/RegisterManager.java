package main.codeGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegisterManager {
    private final List<Register> allOpRegisters = new ArrayList<>();
    private final MemoryManager memoryManager;
    private  Map<String, Register> varToReg = new HashMap<>();
    private  Map<String, Integer> varUseCounts = new HashMap<>();

    public Register ZR = new Register(0, Register.Purpose.ZR);
    public Register RA = new Register(10, Register.Purpose.RA);
    public Register RT = new Register(11, Register.Purpose.RT);
    public Register FP = new Register(12, Register.Purpose.FP);
    public Register SP = new Register(13, Register.Purpose.SP);

    public RegisterManager(MemoryManager memoryManager) {
        this.memoryManager = memoryManager;
        for(int i=1; i<=9; i++){
            allOpRegisters.add(new Register(i, Register.Purpose.OP));
        }
    }

    /**
     * get a register for the purpose of writing into it that refers to the variable varName
     */
    public Register allocateForWrite(String varName, List<RegisterAction> actions){
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
    public Register allocateForRead(String varName, List<RegisterAction> actions) {

        if (varToReg.containsKey(varName)) {
            incrementUseCount(varName);
            return varToReg.get(varName);
        }

        if (memoryManager.hasVariable(varName)) {
            return loadSpilled(varName,null, actions);
        }

        return getFreeRegister(List.of(varName), actions);
    }


    public Register allocateTwoForRead(String mainVar,String helperVar, List<RegisterAction> actions) {

        if (varToReg.containsKey(mainVar)) {
            incrementUseCount(mainVar);
            Register mainReg = varToReg.get(mainVar);
            if (mainReg.id <= allOpRegisters.size() - 1 &&  getNextReg(mainReg).isFree()){
                assignRegister(getNextReg(mainReg), helperVar);
                return mainReg;
            }
            if (mainReg.id <= allOpRegisters.size()-1 && !getNextReg(mainReg).isLock()){ //check if it's not the last register
                handleSpill(List.of(helperVar), List.of(getNextReg(mainReg)), actions).getFirst();
                return mainReg;
            }
        }
        if (varToReg.containsKey(helperVar)) {
            incrementUseCount(helperVar);
            Register helperReg = varToReg.get(helperVar);
            if (1 < helperReg.id && getPrevReg(helperReg).isFree()){
                assignRegister(getPrevReg(helperReg), mainVar);
                return getPrevReg(helperReg);
            }
            if (1 < helperReg.id && !getPrevReg(helperReg).isLock()){
                handleSpill(List.of(mainVar), List.of(getPrevReg(helperReg)), actions).getFirst();
                return getPrevReg(helperReg);
            }
        }

        if (memoryManager.hasVariable(mainVar) || memoryManager.hasVariable(helperVar)) {
            return loadSpilled(mainVar,helperVar, actions);
        }
        return getFreeRegister(List.of(mainVar, helperVar),actions);

    }

    public Register getFreeRegister(List<String> varNames, List<RegisterAction> actions){
        int cnt = varNames.size();
        List<Register> regs = findFreeRegister(cnt);
        if (regs != null) {
            Register firstReg = regs.getFirst();
            for(String var: varNames){
                Register reg = regs.removeFirst();
                assignRegister(reg, var);
            }
            return firstReg;
        }
        List<Register> spillRegs = chooseSpillCandidate(cnt);
        return handleSpill(varNames,spillRegs, actions).getFirst();
    }

    public void freeRegister(String varName) {
        if (!varToReg.containsKey(varName)) return;

        Register reg = varToReg.get(varName);
        varToReg.remove(varName);
        reg.clearVarName();
        reg.free();
        varUseCounts.remove(varName);
    }

    public Register loadSpilled(String var1, String var2, List<RegisterAction> actions) {
        String needLoadVar = (var2 != null && memoryManager.hasVariable(var2)) ? var2 : var1;

        if (!memoryManager.hasVariable(needLoadVar)) {
            throw new RuntimeException("Variable not spilled: " + needLoadVar);
        }

        Register reg = null;
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


    /**
     * Allocate a specific register (for special purposes)
     */
    public void freeRegisterByReg(Register reg) {
        if (reg.getVarName() == null) return;

        String varName = reg.getVarName();
        freeRegister(varName);
    }



    public List<String> getState() {
        List<String> lines = new ArrayList<>();
        lines.add("Register State:");
        lines.add("---------------");

        for (Register reg : allOpRegisters) {
            String var = reg.getVarName();
            if (var == null) var = "-";
            String state = reg.isLock() ? "lock" : reg.isFree() ? "free" : "used";
            String line = String.format("%-4s -> %-10s %s", reg, var, state);
            lines.add(line);
        }

        return lines;
    }


    public Register getPrevReg(Register regName) {
        int index = allOpRegisters.indexOf(regName);
        if (index == -1 || index == 0) {
            return null;
        }
        return allOpRegisters.get(index - 1);
    }

    public Register getNextReg(Register regName) {
        if (regName.id == allOpRegisters.size() - 1) {
            throw new RuntimeException("No operation Register after Input Reg");
        }
        return allOpRegisters.get(regName.id + 1);
    }

    private List<Register> findFreeRegister(int cnt) {
        List<Register> freeRegs = new ArrayList<>();

        for (int i = 0; i <= allOpRegisters.size() - cnt; i++) {
            boolean allFree = true;

            for (int j = 0; j < cnt; j++) {
                Register reg = allOpRegisters.get(i + j);
                if (reg.isLock() || !reg.isFree()) {
                    allFree = false;
                    break;
                }
            }

            if (allFree) {
                for (int j = 0; j < cnt; j++) {
                    freeRegs.add(allOpRegisters.get(i + j));
                }
                return freeRegs;
            }
        }
        return null;
    }

    public List<Register> handleSpill(List<String> varsToAssign, List<Register> spillRegs, List<RegisterAction> actions) {
        int cnt = spillRegs.size();
        for (int i = 0; i < cnt; i++) {
            Register spillReg = spillRegs.get(i);
            String spilledVar = spillReg.getVarName();
            if(memoryManager.isGlobal(spilledVar)){
                int address = memoryManager.getGlobalAddress(spilledVar);
                actions.add(new RegisterAction(RegisterAction.Type.SPILL_G, spillReg, 0,address));
            }
            else{
                int offset = memoryManager.getLocalOffset(spilledVar);
                actions.add(new RegisterAction(RegisterAction.Type.SPILL_L, spillReg, offset, 0));
            }

            spillReg.clearVarName();
            varToReg.remove(spilledVar);
            spillReg.free();

            if(varsToAssign!=null) {
                String varName = varsToAssign.get(i);
                assignRegister(spillReg, varName);
            }
        }


        return spillRegs;
    }

    public void assignRegister(Register reg, String varName) {
        //if it had a register before:
        Register prevReg = varToReg.get(varName);
        if(prevReg!=null){
            freeRegister(varName);
        }
        incrementUseCount(varName);
        reg.setVarName(varName);
        varToReg.put(varName, reg);
        reg.use();
    }

    private void incrementUseCount(String varName) {
        varUseCounts.put(varName, varUseCounts.getOrDefault(varName, 0) + 1);
    }

    /* Todo: include the registers needed for the operation in calling this function
        so they are kept untouched
     */
    private List<Register> chooseSpillCandidate(int cnt) {
        int minUsageSum = Integer.MAX_VALUE;
        List<Register> bestBlock = null;

        for (int i = 0; i <= allOpRegisters.size() - cnt; i++) {
            List<Register> block = allOpRegisters.subList(i, i + cnt);

            boolean allEligible = block.stream().allMatch(reg ->
                    !reg.isFree() && !reg.isLock()
            );

            if (!allEligible) continue;

            int usageSum = 0;
            for (Register reg : block) {
                String var = reg.getVarName();
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
        this.allOpRegisters.forEach(reg -> {
            reg.free();
            reg.clearVarName();
            if(reg.isLock())
                throw new RuntimeException("Locked Register Never UnLocked");
            });
        varToReg = new HashMap<>();
        varUseCounts = new HashMap<>();
    }

}