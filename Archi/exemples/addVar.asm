.data
A:	.word 123456
B:	.word 987654

.text
MAIN:	lw $t0, A
	lw $t1, B
 	add $a0, $t0, $t1
	li $v0, 1	# afficher int
	syscall
	li $a0, '\n'
	li $v0, 11	# Afficher char
	syscall
	li $v0, 10	# Fin programme
	syscall