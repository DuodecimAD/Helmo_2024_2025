# on loop sur un tableau .half de 16 bits (2 bytes) au lieu de words 32 bits (4 bytes) de valeurs
# et on cherche à additionner chaque nombre

.data
TABH:	.half 12, 34, 56, 78, 90 # tableau de 2 bytes each
LENH: 	.word 5
.text
	la $t0, TABH		# on charge le tableau à l'adresse
	lw $t1, LENH		# on charge la longueur du tableau
	li $t2, 0		# on utilise la variable $t2 que l'on initialize à 0 (on calculera la somme dedans)
LOOP:	beqz $t1, EXIT		# si $t1 == 0 alors EXIT
	  lh $t3, 0($t0)	# on load 1er nombre (12)
	  add $t2, $t2, $t3 	# 0 = 0 + 12
	  addi $t1, $t1, -1	# on décrémente de 1
	  addi $t0, $t0, 2	# on avance de 2 bytes dans le tableau
	  j LOOP

EXIT:	move $a0, $t2	# on mets le total de somme dans $a0 pour le print
	jal PR_INT	# On affiche la somme
	li $v0, 10	# Fin programme
	syscall
# PR_INT($a0)
# $a0 : valeur entière à afficher
PR_INT: li $v0, 1	# afficher int
	syscall
	li $a0, '\n'
	li $v0, 11	# Afficher char
	syscall
	jr $ra		# return