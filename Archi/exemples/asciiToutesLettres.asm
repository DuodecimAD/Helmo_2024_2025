.data
TXT:	.ascii  "HELMO"	
LEN:	.word	5
.text
	la $t0, TXT		# load address TEXT ($t0 = "HELMO")
	lw $t1, LEN		# load .word ($t1 = 5)
LOOP:	blez $t1, EXIT		# si LEN <= 0 go EXIT 
	    lb $a0, 0($t0)	# load byte (character) de $t0 dans $a0
	    jal PR_INT		# print la lettre (son équivalence ascii = chiffre)
	    addi $t0, $t0, 1 	# on passe à la lettre suivante
	    subi $t1, $t1, 1	# on diminue de 1 le LEN stocké dans $t1
	    # addi $t1, $t1, -1 # équivalent de ligne au dessus : subi
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
