.text
MAIN:	li $t0, 123456
	li $t1, 987654
 	add $a0, $t0, $t1
	li $v0, 1	# afficher int
	syscall
	li $a0, '\n'
	li $v0, 11	# Afficher char
	syscall
	li $v0, 10	# Fin programme
	syscall