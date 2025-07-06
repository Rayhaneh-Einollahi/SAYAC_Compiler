""" --------------------------Important Notes-------------------------------
 R14 Register in Register File is reserved for storing label addresses, and 
 shouldn't be used in the compiled assembly code, unless no labels are used!

 Labels can be used in consecutive lines all pointing to a single line"""


"""" -----------------------Macro Instructions------------------------------
JMP: used to jump to a label
    usage:  JMP LABEL1
BRR: used to jump to a label if flag
    usage:  BRR LABEL1
"""


def reg(val):
    return format(int(val[1:]), '04b')

def imm(val, bits):
    val = int(val)
    if val < 0:
        val = (1 << bits) + val 
    return format(val, f'0{bits}b')

def assemble_sayac(line):
    parts = line.strip().split()
    if not parts:
        return None
    op = parts[0].upper()
    b = ''

    if op == 'LDR':
        b = '0010' + '00' + '0' + '0' + reg(parts[1]) + reg(parts[2])
    elif op == 'LIR':
        b = '0010' + '00' + '0' + '1' + reg(parts[1]) + reg(parts[2])
    elif op == 'LDB':
        b = '0010' + '00' + '1' + '0' + reg(parts[1]) + reg(parts[2])
    elif op == 'LIB':
        b = '0010' + '00' + '1' + '1' + reg(parts[1]) + reg(parts[2])


    elif op == 'STR':
        b = '0010' + '01' + '0' + '0' + reg(parts[1]) + reg(parts[2])
    elif op == 'SIR':
        b = '0010' + '01' + '0' + '1' + reg(parts[1]) + reg(parts[2])
    elif op == 'STB':
        b = '0010' + '01' + '1' + '0' + reg(parts[1]) + reg(parts[2])
    elif op == 'SIB':
        b = '0010' + '01' + '1' + '1' + reg(parts[1]) + reg(parts[2])


    elif op == 'JMR': #JMR s r1 rd
        s = parts[1]
        b = '0010' + '10' + s + '0' + reg(parts[2]) + reg(parts[3])
    elif op == 'JMB': #JMB s r1 rd
        s = parts[1]
        b = '0010' + '10' + s + '1' + reg(parts[2]) + reg(parts[3])

    elif op == 'JMI': #JMI imm rd
        b = '0010' + '11' + imm(parts[1], 6) + reg(parts[2])



    elif op == 'ANR':
        b = '0011' + reg(parts[1]) + reg(parts[2]) + reg(parts[3])
    elif op == 'ANI':
        b = '0100' + imm(parts[1], 8) + reg(parts[2])
    elif op == 'MSI':
        b = '0101' + imm(parts[1], 8) + reg(parts[2])
    elif op == 'MHI':
        b = '0110' + imm(parts[1], 8) + reg(parts[2])


    elif op == 'SIR':
        b = '0111' + reg(parts[1]) + reg(parts[2]) + reg(parts[3])
    elif op == 'SAR':
        b = '1000' + reg(parts[1]) + reg(parts[2]) + reg(parts[3])
    elif op == 'ADR':
        b = '1001' + reg(parts[1]) + reg(parts[2]) + reg(parts[3])
    elif op == 'SUR':
        b = '1010' + reg(parts[1]) + reg(parts[2]) + reg(parts[3])


    elif op == 'ADI':
        b = '1011' + imm(parts[1], 8) + reg(parts[2])
    elif op == 'SUI':
        b = '1100' + imm(parts[1], 8) + reg(parts[2])


    elif op == 'MUL':
        b = '1101' + reg(parts[1]) + reg(parts[2]) + reg(parts[3])
    elif op == 'DIV':
        b = '1110' + reg(parts[1]) + reg(parts[2]) + reg(parts[3])


    elif op == 'MEC':
        b = '1111' + '00' + '0' + '0' + '0000' + '0000'
    elif op == 'CMR':
        b = '1111' + '00' + '0' + '1' + reg(parts[1]) + reg(parts[2])
    elif op == 'CMI':
        b = '1111' + '00' + '1'  + imm(parts[1], 5) + reg(parts[2])

    elif op == 'BRC':
        b = '1111' + '01' + '0'  + imm(parts[1], 5) + reg(parts[2])
    elif op == 'BRR':
        b = '1111' + '01' + '1'  + imm(parts[1], 5) + reg(parts[2])

    elif op == 'SHI':
        b = '1111' + '10' + '0' + imm(parts[1], 5) + reg(parts[2])
    elif op == 'SHA':
        b = '1111' + '10' + '1' + imm(parts[1], 5) + reg(parts[2])


    elif op == 'NTR':
        b = '1111' + '11' + '0' + '0' + reg(parts[1]) + reg(parts[2])
    elif op == 'NTR2':
        b = '1111' + '11' + '0' + '1' + reg(parts[1]) + reg(parts[2])
    elif op == 'NTD':
        b = '1111' + '11' + '1' + '0' + '0000' + reg(parts[1])
    elif op == 'NTD2':
        b = '1111' + '11' + '1' + '1' + '0000' + reg(parts[1])
    else:
        raise ValueError(f"Unknown operation: {op}")

    return b


def collect_labels(lines):
    labels = {}
    pc = 0

    pending_labels  = []
    instruction_lines = [] 
    for line in lines:
        line = line.strip()
        if not line:
            continue
        if line.endswith(':'):  # label-only line
            label = line[:-1].strip()
            pending_labels .append(label)
        else:
            for label in pending_labels:
                labels[label] = pc
            pending_labels.clear()
            instruction_lines.append(line)
            pc += 1
    return labels, instruction_lines

def compute_prefix(instruction, lines):
    prefix_sum = [0] * (len(lines) + 1)
    count = 0
    i = 0
    for line in lines:
        line = line.strip()
        if line.endswith(':'):
            continue

        parts = line.split()
        if parts and parts[0].upper() == instruction:
            count += 1
        prefix_sum[i] = count
        i += 1
    return prefix_sum

def expand_macros(lines, labels):
    jmp_prefix = compute_prefix('JMP', lines)
    brr_prefix = compute_prefix('BRR', lines)
    pc = 0
    new_lines = []
    for i,line in enumerate(lines):
        line = line.strip()
        parts = line.split()

        if (not parts) or line.endswith(':'):
            new_lines.append(line)
            continue


        op = parts[0].upper()
        
        if op == 'JMP':
            target = parts[1]
            # TODO:
            # HERE WE ASSUME THE WORST CASE, THAT EVERY JMP IN THE WAY OF A JMP TO IT'S LABEL, IS JMR AND TAKE 
            # 3 INSTRUCTIONS LINES, IT MAY BE A BETTER SOLUTION TO OPTIMALLY ASSIGN JMR AND JMI TO JMP INSTRUCTIONS
            # THE TRICKY PART:
            # MAKING ONE JMP INTO JMR MAY AFFECT OTHER JMI WE HAVE ALREADY ASSIGNED SO THIS WOULD 
            # MAKE A CIRCULAR DEPENDENCY WHICH NEEDS TO BE CONSIDERED

            approx_offset = labels[target] - pc + (jmp_prefix[labels[target] - 1] - jmp_prefix[pc] + brr_prefix[labels[target] - 1] - brr_prefix[pc]) * 2
            if -32 <= approx_offset <= 31:
                new_lines.append(f'JMI {target} ')
            else:
                new_lines.extend([
                    f'MSI r14 ',
                    f'MHI r14 ',
                    f'JMR {target} '
                ])
        elif op == 'BRR':
            target = parts[1]
            new_lines.extend([
                    f'MSI r14 ',
                    f'MHI r14 ',
                    f'BRR {target} '
                ])
        else:
            new_lines.append(line)
        pc += 1 
    return new_lines


def replace_labels(lines, labels):
    pc = 0
    for i,line in enumerate(lines):
        parts = line.strip().split()
        if not parts:
            continue
        op = parts[0].upper()
        
        if op == 'JMI':
            target = parts[1]
            offset = labels[target] - pc
            lines[i] = f'JMI {offset} r0'

        elif op == 'JMR':
            target = parts[1]
            if target in labels: 
                offset = labels[target] - pc
                full = offset & 0xFFFF
                lo = full & 0x00FF
                hi = (full >> 8) & 0x00FF
                lines[i-2:i+1] = [
                    f'MSI {lo} r14',
                    f'MHI {hi} r14',
                    f'JMR 0 r14 r0'
                ]

        elif op == 'BRR':
            target = parts[1]
            if target in labels:
                offset = labels[target] - pc
                full = offset & 0xFFFF
                lo = full & 0x00FF
                hi = (full >> 8) & 0x00FF
                lines[i-2:i+1] = [
                    f'MSI {lo} r14',
                    f'MHI {hi} r14',
                    f'BRR 0 r14 r0'
                ]
        
        pc += 1

    return lines

def assemble_program(lines):
    labels, _ = collect_labels(lines)
    expanded_lines = expand_macros(lines, labels)
    new_labels, new_lines = collect_labels(expanded_lines)
    no_label_lines = replace_labels(new_lines, new_labels)
    print_assembly(no_label_lines)
    binaries = []

    for line in no_label_lines:
        result = assemble_sayac(line)
        if result:
            binaries.append(result)

    return binaries



test_programs = [
    ["MSI 10 R1",    
    "MSI 20 R2",    
    "MSI 5 R3",    
    "MSI -3 R4",    
    "STR R1 R2",         
    "LDR R5 R2",         
    ],
    ["MSI 2 R7",
    "JMP TO",
    "HI:",
    "TO:",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "MSI 1 R2 ",
    "MSI 5 R1",
    "JMP HI",
    ],
]
def print_assembly(lines):
    for l in lines:
        print(l)
for i,program in enumerate(test_programs):
    print(f"\n*********** test NO.{i+1} ************\n")
    print("initial code:\n")
    print_assembly(program)
    print("------------------")
    print("pure assembly:\n")
    binary = assemble_program(program)
    print("------------------")
    print("binary code:\n")
    print_assembly(binary)
