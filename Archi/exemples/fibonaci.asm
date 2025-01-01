# fibonaci 1, 2, 3, 4, 5  > 1, 3, 5, 7, 9

.data
TABW:	.word 1, 2, 3, 4, 5
LENW: 	.word 5
RESW:	.word 0:5		# un tableau de 5 0, même chose wue .word 0, 0, 0, 0, 0

.text
	la $t0, TABW 		# on charge tableau à l'adresse TABW = 1,2,3,4,5
	la $t1, LENW		# on charge la longueur = 5
	la $t2, RESW		# on charge le tableau de résultat = 0,0,0,0,0
	li $t3, 0		# on crée variable pour somme cumulé, initialisation = 0
LOOP:	beqz $t1, END		# si LENW  == 0 alors go END
	   lw $t4, 0($t0)	# on load 1er chiffre dans $t4
	   add $t3, $t3, $t4	# somme de t3 + t4 = 0 + 1 = 1
	   sw $t3, 0($t0)	# sw store word = enregistrer word du resultat de la somme dans tableau resultat au 1er emplacement
	   addi $t0, $t0, 4	# on go next element dans tableau (2)
	   addi $t1, $t1, -1	# LEN -1
	   addi $t2, $t2, 4	# on go next element dans tableau resultat 1, ICI, 0, 0, 0
	   j LOOP


END: 	la $a0, RESW
	lw $a1, LENW
	jal LPRTAB

# PR_TAB($a0, $a1)
# Affiche les elements d'un tableau d'entiers (word)
# $a0 = adresse  tableau
# $a1 = longueur tableau
LPRTAB:	move $t0, $a0		# $t0 = adresse du tableau
	beqz $a1, EPRTAB	# si $a1 == 0, on a fini
	lw $a0, 0($t0)		# on charge l'element courant
	li $v0, 1		# afficher int
	syscall
	li $a0, '\n'
	li $v0, 11		# Afficher char
	syscall
	jr $ra			# return
	
	addi $t0, $t0, 4
	addi $a1, $a1, -1 
	j LPRTAB
EPRTAB: jr $ra
	
	
	
	
