# on loop sur un tableau de valeurs

.data
TABW:	.word 123, 456, 789, 741 # tableau de 4 bytes each
.text
	la $t0, TABW	# on charge le tableau à l'adresse
	lw $a0, 0($t0)	# on load la 1ère valeur
	jal PR_INT	# on imprime la 1ere valeur 
	lw $a0, 4($t0)	# on passe au mot suivant, 
	jal PR_INT	# on imprime la 2eme valeur
	lw $a0, 8($t0)	# on passe au mot suivant, 
	jal PR_INT	# on imprime la 3eme valeur
	
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