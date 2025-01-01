.data
TXT:	.ascii "HELMO"

.text
MAIN:	la $t0, TXT
	lb $a0, 0($t0)
	jal PR_INT
	lb $a0, 1($t0)
	jal PR_INT
	lb $a0, 2($t0)
	jal PR_INT
	
EXIT:	li $v0, 10	# Fin programme
	syscall
# PR_INT($a0)
# $a0 : valeur entière à afficher
PR_INT: li $v0, 1	# afficher int
	syscall
	li $a0, '\n'
	li $v0, 11	# Afficher char
	syscall
	jr $ra		# return