
---

# SAYAC Assembly Code Generator

This Python script converts SAYAC assembly code into its corresponding binary representation. It supports a variety of instructions, labels, and macro expansions.

## 📌 Important Notes

- **R14 Register**:  
  The `R14` register in the Register File is reserved for storing label addresses. **Do not use it in your compiled assembly code unless no macro instructions are used!**  

- **Labels**:  
  Labels can be used in consecutive lines, all pointing to a single line. Example:  
  ```assembly
  LABEL1:
  LABEL2:
      LDR R1, R2  ; Both LABEL1 and LABEL2 point to this line
  ```

- **Comments:**:  
  One-line Comments supported using ``#`` character across the file

---

## 🛠 Macro Instructions

| Macro     | Usage               | Description                                                                                                    |
|-----------|---------------------|----------------------------------------------------------------------------------------------------------------|
| **`JMP`** | `JMP LABEL1 DESREG` | Unconditionally jumps to `LABEL1` and store the return address in `DESREG`. if no return address needed use R0 |
| **`BRR`** | `BRR FLAG LABEL1`   | Jumps to `LABEL1` if the R15 flag bits equals FLAG. FLAG can be compare symbols like ==, <=,...                |
| **`STI`** | `STI VALREG ADRIMM` | Stores the value of `VALREG` to memory address `ADRIMM` which is an immediate                                  |
| **`LDI`** | `LDI DESREG ADRIMM` | Loads the value memory address `ADRIMM` to `DESREG`                                                            |
| **`MSI`** | `MSI IMM DESREG`    | if imm ∉ [-128,127], adds `MHI` to store upper immediate too                                                   |
| **`CMI`** | `CMI IMM DESREG`    | if imm ∉ [-16,15], uses a register and replaces CMI with CMR                                                   |

---

## 🔧 Supported Instructions
The assembler supports the following SAYAC instructions:
## 🔧 Supported Instructions

### Data Transfer Instructions
| Mnemonic | Format | Binary Encoding | Description |
|----------|--------|-----------------|-------------|
| `LDR`    | `LDR Rs, Rd` | `00100000` + `Rs(4)` + `Rd(4)` | Load word from memory address R[Rs] into R[Rd] |
| `LIR`    | `LIR Rs, Rd` | `00100001` + `Rs(4)` + `Rd(4)` | Load from IO - address in Rs, value stored in Rd |
| `LDB`    | `LDB Rs, Rd` | `00100010` + `Rs(4)` + `Rd(4)` | Load from memory address in Rs to register bank Rd |
| `LIB`    | `LIB Rs, Rd` | `00100011` + `Rs(4)` + `Rd(4)` | - |
| `STR`    | `STR Rs, Rd` | `00100100` + `Rs(4)` + `Rd(4)` | Store value Rs to destination memory with address Rd |
| `SIR`    | `SIR Rs, Rd` | `00100101` + `Rs(4)` + `Rd(4)` | Store value Rs to destination IO with address Rd |
| `STB`    | `STB Rs, Rd` | `00100110` + `Rs(4)` + `Rd(4)` | - |
| `SIB`    | `SIB Rs, Rd` | `00100111` + `Rs(4)` + `Rd(4)` | - |

### Arithmetic/Logical Instructions
| Mnemonic | Format | Binary Encoding | Description |
|----------|--------|-----------------|-------------|
| `ANR`    | `ANR Rs2, Rs1, Rd` | `0011` + `Rs2(4)` + `Rs1(4)` + `Rd(4)` | Bitwise AND of Rs1 and Rs2, result in Rd |
| `ANI`    | `ANI imm, Rd` | `0100` + `imm(8)` + `Rd(4)` | Bitwise AND of immediate value with Rd |
| `MSI`    | `MSI imm, Rd` | `0101` + `imm(8)` + `Rd(4)` | Move signed immediate value to Rd (sign-extended) |
| `MHI`    | `MHI imm, Rd` | `0110` + `imm(8)` + `Rd(4)` | Move high immediate (upper 8 bits) to Rd |
| `SIR`    | `SIR Rs2, Rs1, Rd` | `0111` + `Rs2(4)` + `Rs1(4)` + `Rd(4)` | Logical shift Rs1 by Rs2 bits, result in Rd (Rd = Rs1 << Rs2)|
| `SAR`    | `SAR Rs2, Rs1, Rd` | `1000` + `Rs2(4)` + `Rs1(4)` + `Rd(4)` | Arithmetic shift |
| `SHI`    | `SHI imm, Rd` | `1111100` + `imm(5)` + `Rd(4)` | Shift Rs left by immediate bits |
| `SHA`    | `SHA imm, Rd` | `1111101` + `imm(5)` + `Rd(4)` | Arithmetic shift Rs right by immediate bits |
| `ADR`    | `ADR Rs2, Rs1, Rd` | `1001` + `Rs2(4)` + `Rs1(4)` + `Rd(4)` | Add Rs1 and Rs2, result in Rd |
| `SUR`    | `SUR Rs2, Rs1, Rd` | `1010` + `Rs2(4)` + `Rs1(4)` + `Rd(4)` | Subtract Rs2 from Rs1, result in Rd (Rd = Rs1 - Rs2)|
| `ADI`    | `ADI imm, Rd` | `1011` + `imm(8)` + `Rd(4)` | Add immediate value to Rd |
| `SUI`    | `SUI imm, Rd` | `1100` + `imm(8)` + `Rd(4)` | Subtract immediate value from Rd (rd - SE(imm)) |
| `MUL`    | `MUL Rs2, Rs1, Rd` | `1101` + `Rs2(4)` + `Rs1(4)` + `Rd(4)` | Multiply Rs1 by Rs2, result in Rd, hi result in Rd+1 |
| `DIV`    | `DIV Rs2, Rs1, Rd` | `1110` + `Rs2(4)` + `Rs1(4)` + `Rd(4)` | Divide Rs1 by Rs2, result in Rd, mod in Rd+1 |

### Control Flow Instructions
| Mnemonic | Format | Binary Encoding | Description |
|----------|--------|-----------------|-------------|
| `JMR`    | `JMR s, Rs, Rd` | `001010` + `s` + `0`  + `Rs(4)` + `Rd(4)` | Jump to address in Rs. if s is set, store return address in Rd |
| `JMB`    | `JMB s, Rs, Rd` | `001010` + `s` + `1`  + `Rs(4)` + `Rd(4)` | - |
| `JMI`    | `JMI imm, Rd` | `001011` + `imm(6)` + `Rd(4)` | Jump to immediate address, store return address in Rd |
| `MEC`    | `MEC` | `1111000000000000` | Trigger machine exception/interrupt |
| `CMR`    | `CMR Rs, Rd` | `11110001` + `Rs(4)` + `Rd(4)` | Compare Rs and Rd, set condition flags |
| `CMI`    | `CMI imm, Rd` | `1111001` + `imm(5)` + `Rd(4)` | Compare immediate value with Rs |
| `BRC`    | `BRC flag, Rd` | `1111010` + `flag(5)` + `Rd(4)` | Branch to address in Rs if condition flag matches |
| `BRR`    | `BRR flag, Rd` | `1111011` + `flag(5)` + `Rd(4)` | Relative branch (PC + Rs) if condition flag matches |


### Complements
| Mnemonic | Format | Binary Encoding | Description |
|----------|--------|-----------------|-------------|
| `NTR`    | `NTR Rs, Rd` | `11111100` + `Rs(4)` + `Rd(4)` | rd <= 1sComp(rs1) |
| `NTR2`   | `NTR2 Rs, Rd` | `11111101` + `Rs(4)` + `Rd(4)` | rd <= 2sComp(rs1) |
| `NTD`    | `NTD Rs` | `11111110` + `0000` + `Rs(4)` | rd <= 1sComp(rd) |
| `NTD2`   | `NTD2 Rs` | `11111111` + `0000` + `Rs(4)` | rd <= 2sComp(rd) |

### Flag Conditions for Branching
| Value | Mnemonic | Description |
|-------|----------|-------------|
| 0 | `==` | Equal |
| 1 | `<` | Less than |
| 2 | `>` | Greater than |
| 3 | `>=` | Greater than or equal |
| 4 | `<=` | Less than or equal |
| 5 | `!=` | Not equal |

**Operand Key**:
- `Rd`: Destination register (always last operand)
- `Rs`/`Rs1`/`Rs2`: Source registers
- `imm`: Immediate value (bit width varies by instruction)
- `flag`: Condition flag (1-bit for jumps, 5-bit for branches)

## ⚙️ How It Works

### Key Functions:
1. **`reg(val)`**  
   - Converts a register (e.g., `R3`) into its 4-bit binary form (e.g., `0011`).

2. **`imm(val, bits)`**  
   - Converts an immediate value into its `bits`-bit binary form, handling negative numbers using two's complement.

3. **`flag(sign)`**  
   - Maps comparison operators (`==`, `<`, `>`, etc.) to their 5-bit flag encodings.

4. **`assemble_sayac(line)`**  
   - Takes an assembly instruction and converts it into its 16-bit binary string.

5. **`collect_labels(lines)`**  
   - Scans the code for labels and tracks their addresses.
   - Returns label addresses along with cleaned code without labels

6. **`assemble_program(lines)`**  
   - The main function that processes an entire program:
     - Removes comments.
     - Expands macros.
     - Resolves labels.
     - Generates binary output.

---

## Macro Translations

### `STI`

**Usage:** `STI valueReg addImm`

Expands to:

```asm
MSI addImm R14
STR valueReg R14
```

---

### `LDI`

**Usage:** `LDI desReg addImm`

Expands to:

```asm
MSI addImm R14
LDR R14 desReg
```

---

### `BRR`

**Usage:** `BRR flag label`

> **Note:** `approx_offset` is computed assuming all `JMP` and `BRR` between a `JUMP` and its `Label` expand to three lines.

Expands to:

```asm
MSI lo r14
MHI hi r14   # if approx_offset ∉ [-128,127]
BRR flag r14
```

---

### `JMP`

**Usage:** `JMP label desReg`

> **Note:** `approx_offset` is computed assuming all `JMP` and `BRR` between a `JUMP` and its `Label` expand to three lines.

* If `-32 <= approx_offset <= 31`:

```asm
JMI offset desReg
```

* Otherwise:

```asm
MSI lo r14
MHI hi r14   # if approx_offset ∉ [-128,127]
JMR 1 r14 desReg
```
---

## 🚀 Usage

1. **Run the Assembler**  
   ```sh
   python assembler.py test1.in test2.in ...
   ```
   *(Replace `test1.in`, `test2.in` with your input files.)*

2. **Input File Format**  
   Example (`test1.in`):
   ```assembly
   START:
      LDR R1, R2
      ADI 5, R1
      JMP START
   ```

3. **Output**  
   The script prints the binary representation of each instruction:
   ```
   0010000000010010
   1011000001010001
   001010000000...
   ```

---

## 📝 Example

**Input (`test.in`)**:
```assembly
LOOP:
    ADI 1, R1
    CMR R1, R2
    BRR > LOOP
```

**Output**:
```
1011000000010001
1111000100010010
111101100100...
```

---