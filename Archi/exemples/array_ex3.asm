# ARRAY
# Exercice 3 : calculer et mémoriser les sommes cumulées des valeurs d'un tableau de WORD + LEN
.data
TABW:	.word	1, 2, 3, 4, 5, 6, 7, 8, 9, 10	
LENW:	.word	10
RESW:	.word	0:10		# Tableau pour les résultats (10 éléments de valeur 0)

.text
ARR3:	la $t0, TABW		# On charge l'adresse de base du tableau de données
	la $t3, RESW		# On charge l'adresse de base du tableau de résultats
	lw $t1, LENW		# On charge le nombre d'éléments
	li $a0, 0		# On initialise la somme à 0
	
L_ARR3:	blez $t1, E_ARR3	# S'il n'y a plus d'éléments à additionner, on a fini
	lw $t2, ($t0)		# On charge l'élément courant de TABW
	add $a0, $a0, $t2	# On l'ajoute à la somme
	sw $a0, ($t3)		# On stocke la somme partielle dans RESW
	addi $t0, $t0, 4	# On passe à l'élément suivant de TABW
	addi $t3, $t3, 4	# On passe à l'élément suivant de RESW
	subi $t1, $t1, 1	# On décrémente le nombre d'éléments à traiter
	j L_ARR3		# On passe à l'itération suivante

E_ARR3:	la $a0, RESW		# On charge l'adresse du tableau de résultats
	lw $a1, LENW		# On charge la longueur du tableau de résultats
	jal PRTABW		# On appelle le sous-programme d'affichage

EXIT:	li $v0, 10		# Fin du programme
	syscall
	
# --- Sous-srogrammes utilitaires ---

# PR_INT($a0)
# $a0 : valeur entière à afficher
PR_INT:	li $v0, 1	# On affiche le nombre entier (code ascii)
	syscall
	li $a0, '\n'	# On affiche le caractère de retour à la ligne
	li $v0, 11
	syscall
	jr $ra		# Fin du sous-programme (return)


# PRTABW($a0, $a1)
# $a0 : adresse du tableau à afficher
# $a1 : nombre d'éléments
.data
SEP:	.asciiz	", "
.text
PRTABW:	move $t0, $a0		# On place l'adresse du tableau à afficher dans $t0
	move $t1, $a1		# On place la longueur du tableau dans $t1

L_PRT:	blez $t1, E_PRT		# Tant qu'il reste des éléments à afficher
	lw $a0, ($t0)		# On charge la valeur de l'élément courant
	li $v0, 1		# On affiche sa valeur
	syscall
	
	addi $t0, $t0, 4	# On passe à l'élément suivant
	subi $t1, $t1, 1	# On décrémente le nombre d'éléments à traiter
	blez $t1, E_PRT		# S'il n'en reste pas, on a fini
	
	la $a0, SEP		# suivie d'une espace ' '
	li $v0, 4
	syscall
	j L_PRT			# On passe à l'itération suivante

E_PRT:	li $a0, '\n'		# On affiche le caractère de retour à la ligne
	li $v0, 11
	syscall
	jr $ra			# Fin du sous-programme (return)
