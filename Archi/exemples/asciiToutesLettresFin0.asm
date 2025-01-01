# ici on utilise .assiiz, c'est à dire tableau termine par 0
# on loop sur HELMO0, jusqu'à ce que le byte chargé = 0

.data
TXT:	.asciiz    "HELMO"	# ajoute
.text
	la $t0, TXT		# load address TEXT ($t0 = "HELMO")
LOOP:	lb $a0, 0($t0)		# load byte (character) de $t0 dans $a0
	beq $a0, $zero, EXIT	# si LEN = 0 go EXIT 
	    jal PR_INT		# print la lettre (son équivalence ascii = chiffre)
	    addi $t0, $t0, 1 	# on passe à la lettre suivante
	    j LOOP
	
EXIT:	li $v0, 10	# Fin programme
	syscall
# PR_INT($a0)
# $a0 : valeur entière à afficher
PR_INT: li $v0, 1	# afficher int
	syscall
	li $a0, '\n'
	li $v0, 11	# Afficher char
	syscall
	jr $ra		# return
