# args : a0, a1, ...
# return : a14
# temp : a8, a9, a10, ...

main:
MSI r1 20
MSI r2 30
MSI r3 10
JMI f0
ADR r0 r1 r4
ADR r0 r3 r1
ADR r0 r4 r3      # swap r1, r3
JMI f1
JMI f2
ADR r0 r14 r4    # y : r4
ADR r0 r1 r5
ADR r0 r4 r1
ADR r0 r5 r4      # swap r1, r4
JMI f3
ADR r0 r14 r5    # z : r5

f0:
MSI r8 1
ADI r8 1 r9

f1:
ADI r1 1 r9

f2:
MSI r8 1
ADD r0 r8 r14

f3:
ADI r1 1 r8
ADD r0 r8 r14