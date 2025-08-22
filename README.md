# SAYAC Compiler

**Authors:** Rayhaneh Einolahi, Bahareh Einolahi, Mahdis Mirzaei, Hasti Abolhasani  
**Supervisor:** Professor Navabi

---

## Overview

The SAYAC compiler translates **Mini-C ASTs** into **SAYAC assembly**. Its backend consists of:

- **Memory Manager:** Handles globals, locals, temps, stack frames, and alignment.
- **Register Manager:** Allocates CPU registers, handles spills/reloads.
- **Instruction Emitter:** Generates SAYAC syntax for ALU, memory, and control operations.
- **Code Generator:** Handles main conversion of AST nodes to assembly.
---

## Memory Manager

- **Globals:** Absolute addresses `[0x7000–0xDFFF]`.
- **Locals/Temps:** FP-relative stack slots.
- **Alignment:** 2-byte enforced.

**Example Prologue/Epilogue:**
```asm
PUSH FP
MOV  FP, SP
SUB  SP, SP, #frame_size
; ... body ...
ADD  SP, SP, #frame_size
POP  FP
RET
````

---

## Register Manager

* Maps variable names ↔ registers.
* Uses **register actions** to separate allocation from emission.
* **Linear-scan allocation:** reuse free registers; spill if needed.

**Key Methods:**

* `allocateForRead(varName, actions)`
* `allocateForWrite(varName, actions)`
* `allocateTwoForRead(varNames, actions)`
* `allocateTwoForWrite(varNames, actions)`

---

## Instruction Emitter

Provides high-level methods to generate SAYAC assembly:

* **ALU:** `ADD, SUB, MUL, ADDI, AND, OR, XOR, NOT, SHL, SHR`
* **Memory:** `LI, LW, SW`
* **Control:** `CMP, Bxx, JMP, CALL, RET`
* **Labels:** `emitLabel(name)`

---

## Code Generation

* **Variables:** Globals get absolute addresses; locals get FP-relative offsets.
* **Expressions:**

    * Unary & binary: direct instruction or temporary reuse.
    * Boolean: use true/false labels.
    * Bitwise OR/XOR: emulated using AND/NOT.
    * Compound assignments: use helper variables.
* **Function Calls:** Push arguments on stack; use `RA` for return.
* **Control Flow:**

    * **While/For:** Labels for condition, body, step, end; handle `break`/`continue` with stacks.
    * **If/Else:** Conditional branch, jump to end label.
* **Functions:** Prologue/epilogue, save FP & RA, allocate locals.

**Example Mini-C → SAYAC:**

```c
int main() {
    int i;
    for (i = 0; i < 5; i++) {
        if (i == 3) break;
    }
    return 0;
}
```

```asm
func_main:
    STR FP SP
    ADR ZR SP FP
    ADI -2 SP
    MSI 0 R1
    ADI -2 R2
    LDR FP R2
    ADI 2 R2
for_condition_0:
    CMI 5 R1
    BRR > for_body_1
    JMP for_end_2
for_body_1:
    CMI 3 R1
    BRR == If_4
    JMP After_If_6
If_4:
    JMP for_end_2
    JMP After_If_6
After_If_6:
    JMP for_step_3
for_step_3:
    ADR ZR R1 R2
    ADI 1 R1
    JMP for_condition_0
for_end_2:
    MSI 0 R3
    ADR ZR R3 RT
    JMP func_ret_main
func_ret_main:
    ADR ZR FP SP
    LDR FP FP
    JMR 0 RA R0
```

---

## Assembler

* Converts SAYAC assembly → machine code.
* Supports all SAYAC instructions + `JMP` and `BRR` and `STI` and `LDI`.
* Resolves labels for control flow.

---

## Run from Terminal

*You can build and run the compiler directly from the terminal without IntelliJ:

```bash
# 1
java -jar lib/antlr-4.13.1-complete.jar \
  -Dlanguage=Java \
  -visitor \
  -package main.grammar \
  -o out/gen/main/grammar \
  src/main/grammar/SimpleLang.g4

# 2
mkdir -p out
javac -cp lib/antlr-4.13.1-complete.jar \
     -d out \
     $(find out/gen -type f -name "*.java") \
     $(find src -type f -name "*.java")

# 3
java -cp "out:lib/antlr-4.13.1-complete.jar" SimpleLang tests/CodeGeneration/Array/array_1.c -o out/output.s

```


