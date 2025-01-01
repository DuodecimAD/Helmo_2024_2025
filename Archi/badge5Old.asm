.data
ASK: 	.asciiz	"Introduisez un nombre entier : "

.text
MAIN: 	la $a0, ASK		# on récupère message à afficher
	li $v0, 4		# on affiche message Console
	syscall
	li $v0, 5		# Saisie d'un nombre entier N
	syscall
	move $t0, $v0		# on store le nombre récupérer (final)
	move $t1, $v0		# sera utilisé pour loop
	
	li   $a0, 0		# On initialise $a0 à 0
LOOP: 	beqz $t1, EXIT
	move $a0, $t4
	jal AFFINC
	move $t4, $v0		# on donne le résultat de AFFINC à $t4
	li $a0, '\n'		# Affichage d'un retour Ã  la ligne
	li $v0, 11
	syscall			# on appelle fonction pour afficher et incrémenter
	addi $t1, $t1, -1
	j LOOP

EXIT:	li   $v0, 10		# -> Fin du programme
	syscall			

# BUILDS($a0) -> $v0
# Affiche ligne de # et retourne l'incrémentation de 1
# $a0 : int qui détermine le nombre de fois que # sera affiché pour la ligne
# $v0 : $a0 + 1
AFFINC:	move $t2, $a0		# On initialise $v0 avec valeur de $a0
	move $t3, $a0		# On garde valeur de $a0 en entrée pour passer à $v0 en sortie
	addi $t2, $t2, 1
	li $a0, '#'		# Affichage d'un retour Ã  la ligne
LOCOL:	beqz $t2, END
	li $v0, 11		# on affiche #
	syscall
	addi $t2, $t2, -1
	j    LOCOL		# On poursuit la boucle
	
END:	move $v0, $t3		# on redonne la valeur d'entrée à $v0
	addi $v0, $v0, 1	# On incrémente de 1
	jr   $ra		# Return


