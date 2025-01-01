.data
TEXT1:	.asciiz  ""
TEXT2:	.asciiz  "B"
TEXT3:	.asciiz  "Hello World!"

# Programme
.text
MAIN:	la   $a0, TEXT1		# On charge l'adresse du texte 1 dans $a0
	jal  STRLEN		# On calcule sa longueur
	move $a0, $v0		# On charge la valeur entière à afficher dans $a0
	jal PR_INT		# -> Affichage de la longueur

	la   $a0, TEXT2		# On charge l'adresse du texte 2 dans $a0
	jal  STRLEN		# On calcule sa longueur
	move $a0, $v0		# On charge la valeur entière à afficher dans $a0
	jal PR_INT		# -> Affichage de la longueur
	
	la   $a0, TEXT3		# On charge l'adresse du texte 3 dans $a0
	jal  STRLEN		# On calcule sa longueur
	move $a0, $v0		# On charge la valeur entière à afficher dans $a0
	jal PR_INT		# -> Affichage de la longueur

EXIT:	li   $v0, 10		# Appel système : 10 = exit
	syscall			# -> Fin du programme

# STRLEN($a0) -> $v0
# Calcule la longueur d'une chaîne de caractères.
# $a0 : adresse de début d'une chaîne de caractères terminée par '\0'
# $v0 : longueur de la chaîne de caractères
STRLEN:	li   $v0, 0		# On initialise $v0 à 0
LOOP:	lbu  $t0, ($a0)		# On charge le caractère courant dans $t0
	beq  $t0, $zero, END	# Si le caractère est '\0', on a terminé et on va en END
	addi $a0, $a0, 1	# Sinon, on passe au caractère suivant
	addi $v0, $v0, 1	# On ajoute 1 à la longueur de la chaîne
	j    LOOP		# On poursuit la boucle
END:	jr   $ra		# Return

# PR_INT($a0)
# $a0 : valeur entière à afficher
PR_INT:	li $v0, 1	# On affiche le nombre entier (code ascii)
	syscall
	li $a0, '\n'	# On affiche le caractère de retour à la ligne
	li $v0, 11
	syscall
	jr $ra		# Fin du sous-programme (return)
