# ici on utilise .assiiz, c'est � dire tableau termine par 0
# on loop sur HELMO0, jusqu'� ce que le byte charg� = 0

.data
TXT:	.asciiz    "HELMO"	# ajoute
.text
	la $t0, TXT		# load address TEXT ($t0 = "HELMO")
LOOP:	lb $a0, 0($t0)		# load byte (character) de $t0 dans $a0
	beq $a0, $zero, EXIT	# si LEN = 0 go EXIT 
	    jal PR_INT		# print la lettre (son �quivalence ascii = chiffre)
	    addi $t0, $t0, 1 	# on passe � la lettre suivante
	    j LOOP
	
EXIT:	li $v0, 10	# Fin programme
	syscall
# PR_INT($a0)
# $a0 : valeur enti�re � afficher
PR_INT: li $v0, 1	# afficher int
	syscall
	li $a0, '\n'
	li $v0, 11	# Afficher char
	syscall
	jr $ra		# return
