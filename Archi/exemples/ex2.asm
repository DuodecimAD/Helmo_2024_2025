.data
M: 	.asciiz	"Introduisez un nombre entier : "
N: 	.word	10
RES:	.word	0:10
.text		

MAIN: 	lw $t0, N		# on récupère counter maximum
	la $a0, M		# on récupère message à afficher
	la $t2, RES		# on load tableau dans $t2
	li $v0, 4		# on affiche message Console
	syscall
	li $v0, 5		# Saisie d'un nombre entier N
	syscall
	
	move $t1, $v0		# chiffre va dans $t1 pour somme
	move $t3, $v0		# copie chiffre original
	sw $v0, ($t2)		# copie dans tableau 1er element

LOOP:	beqz $t0, END		# si $t0 == 0 alors EXIT
	addi $t0, $t0, -1	# on diminue le compteur de 1
	addi $t2, $t2, 4	# on va next element du tableau
	add  $t1, $t1, $t3	# on ajoute 3 à 3 par ex pour créer multiple
	sw $t1, ($t2)		# on met nouvelle valeur dans new index du tableau
	j LOOP			# on loop

END:	lw $t4, N		# 2eme counter pour afficher tableau
	la $t0, RES		# on revient au debut du tableau

PR_ARR: beqz $t4, EXIT
	lw $a0, ($t0)
	li $v0, 1		# afficher int
	syscall
	li $a0, ','
	li $v0, 11		# on affiche ","
	syscall	
	li $a0, ' '
	li $v0, 11		# on affiche " "
	syscall		
	addi $t0, $t0, 4	# next element du tableau
	addi $t4, $t4, -1
	j PR_ARR		# on loop

EXIT: 	li $v0, 10	# Fin du programme
	syscall
	
