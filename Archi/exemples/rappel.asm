li $t0, 123
la $t0, LABEL
lw $t0, N

.word 4 32
.half 2 16
.byte 1 8

jl LABEL
jal LABEL