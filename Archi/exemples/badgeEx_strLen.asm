.data
TEXT: 	.asciiz "HELMO"
.text		
	
MAIN: 	la $a0, TEXT	# on load le text HELMO + 0
	jal STRLEN
	
	move $a0, $v0 	# on met la r�sultat de la longueur de la string dans $a0 pour le print
	jal PR_INT	# appelle PR_INT

EXIT: 	li $v0, 10	#exit
	syscall
	
#STRLEN($a0) -> $v0 (r�sultat)
# $a0 : adresse d'une cha�ne d�limit�e par '\0'
# $v0 : longueur de la cha�ne
STRLEN: li $v0, 0		# on cr�e variable pour compteur, initialisation = 0
LOOP:	lb $t0, ($a0)		# on r�cup�re 1�re lettre
	beqz $t0, END 		# si char == 0 alors END
	addi $v0, $v0, 1	# compteur +1
	addi $a0, $a0, 1	# char suivant
	j LOOP			# boucle sur la suite

END: 	jr $ra		# return

# PR_INT($a0)
# $a0 : valeur enti�re � afficher
PR_INT: li $v0, 1	# afficher int
	syscall
	li $a0, '\n'
	li $v0, 11	# Afficher char
	syscall
	jr $ra		# return