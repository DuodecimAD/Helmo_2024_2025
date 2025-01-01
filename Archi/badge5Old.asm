.data
ASK: 	.asciiz	"Introduisez un nombre entier : "

.text
MAIN: 	la $a0, ASK		# on r�cup�re message � afficher
	li $v0, 4		# on affiche message Console
	syscall
	li $v0, 5		# Saisie d'un nombre entier N
	syscall
	move $t0, $v0		# on store le nombre r�cup�rer (final)
	move $t1, $v0		# sera utilis� pour loop
	
	li   $a0, 0		# On initialise $a0 � 0
LOOP: 	beqz $t1, EXIT
	move $a0, $t4
	jal AFFINC
	move $t4, $v0		# on donne le r�sultat de AFFINC � $t4
	li $a0, '\n'		# Affichage d'un retour à la ligne
	li $v0, 11
	syscall			# on appelle fonction pour afficher et incr�menter
	addi $t1, $t1, -1
	j LOOP

EXIT:	li   $v0, 10		# -> Fin du programme
	syscall			

# BUILDS($a0) -> $v0
# Affiche ligne de # et retourne l'incr�mentation de 1
# $a0 : int qui d�termine le nombre de fois que # sera affich� pour la ligne
# $v0 : $a0 + 1
AFFINC:	move $t2, $a0		# On initialise $v0 avec valeur de $a0
	move $t3, $a0		# On garde valeur de $a0 en entr�e pour passer � $v0 en sortie
	addi $t2, $t2, 1
	li $a0, '#'		# Affichage d'un retour à la ligne
LOCOL:	beqz $t2, END
	li $v0, 11		# on affiche #
	syscall
	addi $t2, $t2, -1
	j    LOCOL		# On poursuit la boucle
	
END:	move $v0, $t3		# on redonne la valeur d'entr�e � $v0
	addi $v0, $v0, 1	# On incr�mente de 1
	jr   $ra		# Return


