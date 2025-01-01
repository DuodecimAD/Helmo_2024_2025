.data
M: .asciiz	"Introduisez un nombre entier : "
N: .word	10
.text		

MAIN: 	lw $t0, N 		# on récupère counter maximum
	la $a0, M		# on récupère chiffre
	li $v0, 4
	syscall
	li $v0, 5		# Saisie d'un nombre entier N
	syscall
	move $t1, $v0		# chiffre va dans $t1 pour somme
	move $t2, $v0		# copie du chiffre original
	addi $t0, $t0, -1
	move $a0, $t1		# passe le chiffre dans a0 pour afficher
	jal PR_INT		# on print une première fois la valeur pour faire 1 x valeur

	
LOOP:	beqz $t0, EXIT		# si $t0 == 0 alors EXIT
	add $t1, $t1, $t2	# on ajoute 3 à 3 par ex pour créer multiple
	move $a0, $t1
	jal PR_INT		# on affiche résultat
	
	addi $t0, $t0, -1	# on diminue le compteur de 1
	j LOOP			# on loop

EXIT: 	li $v0, 10	# Fin du programme
	syscall
	
PR_INT: li $v0, 1	# afficher int
	syscall
	li $a0, '\n'
	li $v0, 11	# Afficher char
	syscall
	jr $ra		# return
