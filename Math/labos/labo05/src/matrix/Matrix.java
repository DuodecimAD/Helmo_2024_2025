package matrix;


import java.util.Arrays;
import java.util.Iterator;


/**
 * La classe Matrix permet de représenter et de manipuler des matrices
 * de nombres entiers.
 * 
 * @author François Schumacker
 */
public class Matrix {

    // ------------------------------------------------------------------------
    //  Variable d'instance
    // ------------------------------------------------------------------------
    
    private int[][] data; // contient les données de la matrice

    // ------------------------------------------------------------------------
    //  Constructeurs
    // ------------------------------------------------------------------------
    
    /**
     * Crée une matrice nulle de taille numRows x numCols
     *
     * @param numRows Nombre de lignes
     * @param numCols Nombre de colonnes
     */
    public Matrix(int numRows, int numCols) {
    	this(numRows, numCols, 0);
    }

    /**
     * Crée une matrice à partir du tableau de int fourni en argument
     *
     * @param data Tableau contenant les données de la matrice
     */
    public Matrix(int[][] data) {
        this(data.length, data[0].length); // Appel au constructeur Matrix(int numRows, int numCols)
        for (int i = 0; i < data.length; i++) {
            if (data[i].length != data[0].length) {
                throw new IllegalArgumentException("Toutes les lignes doivent avoir la même taille");
            }
            for (int j = 0; j < data[0].length; j++) {
                this.set(i, j, data[i][j]);
            }
        }
        //this(mat.data);
    }

    /**
     * Crée une matrice de taille numRows x numCols remplie avec value
     *
     * @param numRows Nombre de lignes
     * @param numCols Nombre de colonnes
     * @param value Valeur à attribuer à toutes les cases de la matrice
     */
    public Matrix(int numRows, int numCols, int value) {
    	if (numRows <= 0) {
    		throw new IllegalArgumentException("Le nombre de lignes doit être strictement positif");
    	}
    	if (numCols <= 0) {
    		throw new IllegalArgumentException("Le nombre de colonnes doit être strictement positif");
    	}
    	
    	this.data = new int[numRows][numCols];
    	for (int i = 0; i < data.length; i++) {
    	    for (int j = 0; j < data[i].length; j++) {
    	    	data[i][j] = value;
    	    }
    	}
    }

    /**
     * Crée une matrice qui est une copie de celle fournie en argument
     *
     * @param mat La matrice à dupliquer
     */
    public Matrix(Matrix mat) {
    	
    	int rowSize = mat.data.length;
    	this.data = new int[rowSize][];
    	
    	for (int i = 0; i < rowSize; i++) {
			this.data[i] = mat.data[i].clone();
		}
    }

    // ------------------------------------------------------------------------
    //  Accesseurs et mutateurs
    // ------------------------------------------------------------------------
    
    /**
     * Renvoie le nombre de lignes de la matrice
     *
     * @return Nombre de lignes
     */
    public int getNumRows() {
        return this.data.length;
    }

    /**
     * Renvoie le nombre de colonnes de la matrice
     *
     * @return Nombre de colonnes
     */
    public int getNumCols() {
        return this.data[0].length;
    }

    /**
     * Renvoie la valeur stockée dans la case (row, col)
     *
     * @param row Numéro de ligne
     * @param col Numéro de colonne
     * @return Valeur stockée
     */
    public int get(int row, int col) {
        return this.data[row][col];
    }

    /**
     * Stocke une valeur dans la case (row, col)
     *
     * @param row Numéro de ligne
     * @param col Numéro de colonne
     * @param value Valeur à stocker
     */
    public void set(int row, int col, int value) {
        this.data[row][col] = value;
    }

    // ------------------------------------------------------------------------
    //  Méthodes de test
    // ------------------------------------------------------------------------

    /**
     * Teste si la matrice est égale à celle fournie en paramètre 
     * @param mat   Matrice
     * @return true si les matrices sont égales
     */
    public boolean equals(Matrix mat) {
        return Arrays.deepEquals(this.data, mat.data);
        // return this.getNumRows() == this.getNumCols();
        
//        if (!this.sameSize(mat)) return false;
//        for (int i = 0; i < this.getNumRows(); i++) {
//            for (int j = i; j < this.getNumCols(); j++) {
//                if (this.get(i, j) != mat.get(i, j)) return false;
//            }
//        }
//        return true;
    }

    /**
     * Teste si la matrice a la même taille que celle fournie en paramètre
     * @param mat   Matrice
     * @return true si les matrices ont la même taille
     */
    public boolean hasSameSize(Matrix mat) {
        return (this.getNumRows() == mat.getNumRows() &&
                this.getNumCols() == mat.getNumCols());
    }

    /**
     * Teste si la matrice est une matrice diagonale
     * @return true si la matrice est une matrice diagonale
     */
    public boolean isDiagonal() {
        if (!this.isSquare()) return false;
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                if (i != j && this.get(i, j) != 0) return false;
            }
        }
        return true;
    }

    /**
     * Teste si la matrice contient uniquement des zéros
     * @return true si la matrice contient uniquement des zéros
     */
    public boolean isNull() {
    	for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if(data[i][j] != 0) {
					return false;
				}
			}
		}
    	return true;
    }

    /**
     * Teste si la matrice est carrée
     * @return true si la matrice est carrée
     */
    public boolean isSquare() {
    	if(data.length == data[0].length) {
    		return true;
    	}
    	return false;   // To be modified !
    }

    /**
     * Teste si la matrice est symétrique
     * @return true si la matrice est symétrique
     */
    public boolean isSymmetric() {
    	
    	if(!isSquare()) {
    		return false;
    	}

    	for (int i = 0; i < this.getNumRows()-1; i++) {
			for (int j = i+1; j < this.getNumCols(); j++) {
				if(data[i][j] != data[j][i]) {
					return false;
				}
			}
		}
    	return true;
    }

    // ------------------------------------------------------------------------
    //  Opérations sur les matrices
    // ------------------------------------------------------------------------

    /**
     * Addition de deux matrices<br>
     *   R = THIS + M<br>
     *   r(i,j) = this(i,j) + m(i,j)
     * @param m Matrice à ajouter à THIS
     * @return  Matrice de résultat R
     */
    public Matrix add(Matrix m) {
        // On vérifie que les 2 matrices ont la même taille
        if (!this.hasSameSize(m)) {
            throw new IllegalArgumentException("Les matrices doivent avoir la même taille");
        }
        // Création de la matrice de résultat
        Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
        // Addition des 2 matrices
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) + m.get(i, j));
            }
        }
        return r;
    }

    /**
     * ET logique de deux matrices<br>
     *   R = THIS AND M<br>
     *   r(i,j) = this(i,j) & m(i,j)
     * @param m Matrice dont on veut faire le ET logique avec THIS
     * @return  Matrice de résultat R
     */
	public Matrix and(Matrix m) {
		if (!this.hasSameSize(m)) {
            throw new IllegalArgumentException("Les matrices doivent avoir la même taille");
        }
		
		Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
		for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) & m.get(i, j));
            }
        }
		return r;
	}
    
    /**
     * OU logique de deux matrices<br>
     *   R = THIS OR M<br>
     *   r(i,j) = this(i,j) | m(i,j)
     * @param m Matrice dont on veut faire le OU logique avec THIS
     * @return  Matrice de résultat R
     */
	public Matrix or(Matrix m) {
		
		if (!this.hasSameSize(m)) {
            throw new IllegalArgumentException("Les matrices doivent avoir la même taille");
        }
		
		Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
		for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) | m.get(i, j));
            }
        }
		return r;
	}
    
    // ------------------------------------------------------------------------
    //  Opérations matrices / scalaire
    // ------------------------------------------------------------------------

    /**
     * Addition d'un nombre à tous les éléments d'une matrice<br>
     *   R = THIS + v<br>
     *   r(i,j) = this(i,j) + v
     * @param v Valeur scalaire
     * @return  Matrice de résultat
     */
    public Matrix add(int v) {
     	
        Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) + v);
            }
        }
        return r;
    }
    
    /**
     * Division de tous les éléments d'une matrice par un nombre<br>
     *   R = THIS / v<br>
     *   r(i,j) = this(i,j) / v
     * @param v Valeur scalaire
     * @return  Matrice de résultat
     */
    public Matrix div(int v) {
    	if(v==0) {
    		throw new IllegalArgumentException();
    	}
    	Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) / v);
            }
        }
        return r;
    }
    
    /**
     * ET logique entre un nombre et chaque élément d'une matrice<br>
     *   R = THIS & v<br>
     *   r(i,j) = this(i,j) & v
     * @param v Valeur scalaire
     * @return  Matrice de résultat
     */
    public Matrix and(int v) {
    	Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) & v);
            }
        }
        return r;
    }

    /**
     * NOT logique (complément) de chaque élément d'une matrice<br>
     *   R = NOT(THIS)<br>
     *   r(i,j) = ~this(i,j)
     * @return  Matrice de résultat
     */
    public Matrix not() {
    	Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, ~this.get(i, j));
            }
        }
        return r;
    }
    
    /**
     * OU logique entre un nombre et chaque élément d'une matrice.<br>
     *   R = THIS | v<br>
     *   r(i,j) = this(i,j) | v
     * @param v Valeur scalaire
     * @return  Matrice de résultat
     */
    public Matrix or(int v) {
    	Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) | v);
            }
        }
        return r;
    }
    
    /**
     * Décalage logique à gauche de chaque élément d'une matrice<br>
     *   R = THIS << n<br>
     *   r(i,j) = this(i,j) << n
     * @param n Valeur du décalage à gauche
     * @return  Matrice de résultat
     */
    public Matrix shiftLeftLogical(int n) {
    	if (n<0) {
            throw new IllegalArgumentException("Les matrices doivent avoir la même taille");
        }
    	
    	if (n>32) {
            throw new IllegalArgumentException("Les matrices doivent avoir la même taille");
        }
		
		Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
		for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) << n);
            }
        }
		return r;
    }
    
    /**
     * Décalage logique à droite de chaque élément d'une matrice<br>
     *   R = THIS >>> n<br>
     *   r(i,j) = this(i,j) >>> n
     * @param n Valeur du décalage à droite
     * @return  Matrice de résultat
     */
    public Matrix shiftRightLogical(int n) {
    	if (n<0) {
            throw new IllegalArgumentException("Les matrices doivent avoir la même taille");
        }
    	
    	if (n>32) {
            throw new IllegalArgumentException("Les matrices doivent avoir la même taille");
        }
		
		Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
		for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i, j) >>> n);
            }
        }
		return r;
    }

    // ------------------------------------------------------------------------
    //  Méthodes utilitaires
    // ------------------------------------------------------------------------
    
    /**
     * Imprime la matrice à l'écran avec un format par défaut
     */
    public void print() {
        print(6);
    }

    /**
     * Imprime la matrice à l'écran avec le nombre de chiffre demandés
     *
     * @param numDigits Nombre de chiffres
     */
    public void print(int numDigits) {
        String format = "%" + numDigits + "d  ";

        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                System.out.printf(format, this.get(i, j));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Imprime la matrice à l'écran en considérant que chaque élément
     * est un caractère ASCII (entre 32 et 126). Les autres valeurs
     * sont remplacées par un caractère '.'
     */
    public void printAscii() {
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                if (this.get(i, j) >= 32 && this.get(i, j) < 127) {
                    System.out.printf("%c", this.get(i, j));
                } else {
                    System.out.printf(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Construit une chaîne de caractères qui représente le contenu de la matrice.
     * On considère que chaque élément est un caractère ASCII (entre 32 et 126).
     * Les autres valeurs sont remplacées par un caractère '.'
     * 
     * @return une chaîne de caractères qui représente le contenu ASCII de la matrice
     */
    public String toAscii() {
    	String result = "";
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                if (this.get(i, j) >= 32 && this.get(i, j) < 127) {
                    result += (char)this.get(i, j);
                } else {
                	result += '.';
                }
            }
            result += '\n';
        }
        return result;
    }
}
