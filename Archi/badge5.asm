# Le but de ce programme est de construire une pyramide de hashtags a la super mario bros
# la documentation du code a ete ecrite sans accents car ceux-ci changent d'un pc a l'autre

.data
ASK: 	 .asciiz "Introduisez un nombre entier : "
STR: 	 .space 10 		# Une chaine de 10 caracteres modifiable a chaque tour
.text
MAIN: 	la $a0, ASK		# Chargement du message pour l'utilisateur
	li $v0, 4		# Affichage du message en Console
	syscall
	li $v0, 5		# Recuperation d'un nombre entier par l'user
	syscall
	move $t3, $v0		# Copie de ce nombre equivalent aux nombres d'etapes (final)
	li $t4, 0		# Initialisation de la premiere ligne a 0
	
LOOP: 	beq $t4, $t3, EXIT	# Quitte la boucle si toutes les lignes ont ete generees
	move $a0, $t4		# Initialisation du parametre $a0 (index de la ligne)
	la $a1, STR		# Initialisation du parametre $a1 (adresse de string)
	jal BUILD_STR		# Appel de la fonction build_string
	move $a0, $v0		# Preparation de $a0 pour l'affichage de la ligne
	li $v0, 4		# Affichage de la ligne
	syscall	
	li $a0, '\n'		# Preparation d'un retour a la ligne
	li $v0, 11		# Affichage d'un retour a la ligne
	syscall			
	addi $t4, $t4, 1	# Passage a la ligne suivante
	j LOOP			# Retour a LOOP pour creer ligne suivante ou quitter
	
EXIT:	li   $v0, 10		# -> Fin du programme
	syscall			

# BUILD_STR($a0, $a1) -> $v0
# Le sous-programme construit et renvoie une string de n hashtags (#)
# $a0 : <Integer representant l'index de la ligne>
# $a1 : <Adresse de la variable String que l'on modifie>
# $v0 : <String composee de n # pour index de ligne n>
BUILD_STR:
	move $t5, $a0		# Copie de la valeur du parametre $a0 (index de ligne)
	move $t7, $a1		# Copie de la valeur du parametre $a1 (adresse de la string a build)
	move $v0, $t7		# Copie de l'adresse du 1er element de la string (final)
	addi $t5, $t5, 1	# nombre de # a afficher (numero de ligne +1), exemple -> ligne 0 + 1 = 1 # affiche	
	li $t6, '#'		# Preparation du #
				
COL_LOOP:
	beqz $t5, END		# Quitte la boucle si tous les # de la ligne ont ete generes
	sb $t6, ($t7)		# Append du #
	addi $t7, $t7, 1	# Passage au caractere suivant
	addi $t5, $t5, -1	# Decrementation du nombre de # a afficher
	j COL_LOOP		# Retour a COL_LOOP pour ajouter # ou quitter	
		
END:	jr   $ra		# Return