#
# Boucle pour saisir et afficher des nombres entiers.
# La boucle s'arrête si le nombre introduit est 0.
#
.data
INVITE:	.asciiz	"Introduisez un nombre entier : "
.text
LOOP:	la $a0, INVITE		# Affichage du message d'invite
	li $v0, 4
	syscall
	li $v0, 5		# Saisie d'un nombre entier N
	syscall
	beq $v0, $zero, EXIT	# Si N=0, on s'arrête
	move $a0, $v0		# Affichage du nombre
	li $v0, 1
	syscall
	li $a0, '\n'		# Affichage d'un retour à la ligne
	li $v0, 11
	syscall
	j LOOP			# Saisie du nombre suivant
EXIT: 	li $v0, 10		# Fin du programme
	syscall
