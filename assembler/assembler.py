def reg(val):
    return format(int(val[1:]), '04b')

def imm(val, bits):
    val = int(val)
    if val < 0:
        val = (1 << bits) + val 
    return format(val, f'0{bits}b')

def flag(sign):
    val = sign

    if sign == "==":
        val = 0
    elif sign == "<":
        val = 1
    elif sign == ">":
        val = 2
    elif sign == ">=":
        val = 3
    elif sign == "<=":
        val = 4
    elif sign == "!=":
        val = 5
    return imm(val, 5)

def assemble_sayac(line):
    parts = line.strip().split()
    if not parts:
        return None
    op = parts[0].upper()
    b = ''

    if op == 'LDR':
        b = '00100000' + reg(parts[1]) + reg(parts[2])
    elif op == 'LIR':
        b = '00100001' + reg(parts[1]) + reg(parts[2])
    elif op == 'LDB':
        b = '00100010' + reg(parts[1]) + reg(parts[2])
    elif op == 'LIB':
        b = '00100011' + reg(parts[1]) + reg(parts[2])
    elif op == 'STR':
        b = '00100100' + reg(parts[1]) + reg(parts[2])
    elif op == 'SIR':
        b = '00100101' + reg(parts[1]) + reg(parts[2])
    elif op == 'STB':
        b = '00100110' + reg(parts[1]) + reg(parts[2])
    elif op == 'SIB':
        b = '00100111' + reg(parts[1]) + reg(parts[2])
    elif op == 'JMR':
        b = '001010' + parts[1] + '0' + reg(parts[2]) + reg(parts[3])
    elif op == 'JMB':
        b = '001010' + parts[1] + '1' + reg(parts[2]) + reg(parts[3])
    elif op == 'JMI':
        b = '001011' + imm(parts[1], 6) + reg(parts[2])
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
        b = '1111000000000000'
    elif op == 'CMR':
        b = '11110001' + reg(parts[1]) + reg(parts[2])
    elif op == 'CMI':
        b = '1111001' + imm(parts[1], 5) + reg(parts[2])
    elif op == 'BRC':
        b = '1111010' + flag(parts[1]) + reg(parts[2])
    elif op == 'BRR':
        b = '1111011' + flag(parts[1]) + reg(parts[2])
    elif op == 'SHI':
        b = '1111100' + imm(parts[1], 5) + reg(parts[2])
    elif op == 'SHA':
        b = '1111101' + imm(parts[1], 5) + reg(parts[2])
    elif op == 'NTR':
        b = '11111100' + reg(parts[1]) + reg(parts[2])
    elif op == 'NTR2':
        b = '11111101' + reg(parts[1]) + reg(parts[2])
    elif op == 'NTD':
        b = '11111110' + '0000' + reg(parts[1])
    elif op == 'NTD2':
        b = '11111111' + '0000' + reg(parts[1])
    else:
        raise ValueError(f"Unknown operation: {op}")
    return b

def collect_labels(lines):
    labels = {}
    pc = 0
    pending_labels = []
    instruction_lines = []
    for line in lines:
        line = line.strip()
        if not line:
            continue
        if line.endswith(':'):
            label = line[:-1].strip()
            pending_labels.append(label)
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
        if line.strip().endswith(':'):
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
    for i, line in enumerate(lines):
        line = line.strip()
        parts = line.split()
        if (not parts) or line.endswith(':'):
            new_lines.append(line)
            continue
        op = parts[0].upper()
        if op == 'JMP':
            target = parts[1]
            approx_offset = labels[target] - pc + (jmp_prefix[labels[target] - 1] - jmp_prefix[pc] + brr_prefix[labels[target] - 1] - brr_prefix[pc]) * 2
            if -32 <= approx_offset <= 31:
                new_lines.append(f'JMI {target}')
            else:
                new_lines.extend([
                    f'MSI r14',
                    f'MHI r14',
                    f'JMR {target}'
                ])
        elif op == 'BRR':
            target = parts[2]
            flag = parts[1]
            new_lines.extend([
                f'MSI r14',
                f'MHI r14',
                f'BRR {flag} {target}'
            ])
        else:
            new_lines.append(line)
        pc += 1
    return new_lines

def replace_labels(lines, labels):
    pc = 0
    for i in range(len(lines)):
        line = lines[i].strip()
        parts = line.split()
        if not parts:
            continue
        op = parts[0].upper()
        if op == 'JMI':
            target = parts[1]
            offset = labels[target] - pc
            lines[i] = f'JMI {offset} r0'
        elif op == 'JMR':
            target = parts[1]
            offset = labels[target] - pc
            lo = offset & 0x00FF
            hi = (offset >> 8) & 0x00FF
            lines[i-2:i+1] = [
                f'MSI {lo} r14',
                f'MHI {hi} r14',
                f'JMR 0 r14 r0'
            ]
        elif op == 'BRR':
            flag = parts[1]
            target = parts[2]
            offset = labels[target] - pc
            lo = offset & 0x00FF
            hi = (offset >> 8) & 0x00FF
            lines[i-2:i+1] = [
                f'MSI {lo} r14',
                f'MHI {hi} r14',
                f'BRR {flag} r14'
            ]
        pc += 1
    return lines

def remove_comments(lines):
    cleaned_lines = []
    for line in lines:
        stripped_line = line.split('#', 1)[0].strip()
        if stripped_line:
            cleaned_lines.append(stripped_line)
    return cleaned_lines

def assemble_program(lines):
    lines = remove_comments(lines)
    labels, _ = collect_labels(lines)
    expanded_lines = expand_macros(lines, labels)
    new_labels, new_lines = collect_labels(expanded_lines)
    no_label_lines = replace_labels(new_lines, new_labels)
    binaries = []
    for line in no_label_lines:
        result = assemble_sayac(line)
        if result:
            binaries.append(result)
    return binaries

def print_lines(lines):
    for l in lines:
        print(l)

import sys

if len(sys.argv) < 2:
    print("Usage: python your_script.py test1.in test2.in ...")
    sys.exit(1)

test_programs = []
for filename in sys.argv[1:]:
    with open(filename, 'r') as f:
        program = f.read().strip().splitlines()
        test_programs.append(program)


for i, program in enumerate(test_programs):
    binary = assemble_program(program)
    print_lines(binary)