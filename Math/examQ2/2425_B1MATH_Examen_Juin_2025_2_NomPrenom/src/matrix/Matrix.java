package matrix;


import java.util.Arrays;


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
    	if (numRows <= 0) {
    		throw new IllegalArgumentException("Le nombre de lignes doit être strictement positif");
    	}
    	if (numCols <= 0) {
    		throw new IllegalArgumentException("Le nombre de colonnes doit être strictement positif");
    	}
        this.data = new int[numRows][numCols];
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
    }

    /**
     * Crée une matrice de taille numRows x numCols remplie avec value
     *
     * @param numRows Nombre de lignes
     * @param numCols Nombre de colonnes
     * @param value Valeur à attribuer à toutes les cases de la matrice
     */
    public Matrix(int numRows, int numCols, int value) {
        this(numRows, numCols); // Appel au constructeur Matrix(int numRows, int numCols)
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                this.set(i, j, value);
//               this.data[i][j] = value;
            }
        }
    }

    /**
     * Crée une matrice qui est une copie de celle fournie en argument
     *
     * @param mat La matrice à dupliquer
     */
    public Matrix(Matrix mat) {
        this(mat.data); // Appel au constructeur Matrix(int[][] data)
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
     * 
     * @param mat   Matrice
     * @return true si les matrices sont égales
     */
    public boolean equals(Matrix mat) {
        return Arrays.deepEquals(this.data, mat.data);
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
     * 
     * @param mat   Matrice
     * @return true si les matrices ont la même taille
     */
    public boolean hasSameSize(Matrix mat) {
        return (this.getNumRows() == mat.getNumRows() &&
                this.getNumCols() == mat.getNumCols());
    }

    /**
     * Teste si la matrice est une matrice diagonale
     * 
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
     * 
     * @return true si la matrice contient uniquement des zéros
     */
    public boolean isNull() {
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                if (this.get(i, j) != 0) return false;
            }
        }
        return true;
    }

    /**
     * Teste si la matrice est carrée
     * 
     * @return true si la matrice est carrée
     */
    public boolean isSquare() {
        return (this.getNumRows() == this.getNumCols());
    }
    
    
 // Ajout examen Juin 2025
 // TODO  ne pas supprimer !!!
    /**
     * Teste si la matrice est antisymétrique
     * Note: = matrice carrée opposée à sa tranposée
     * 
     * @return true si la matrice est antisymétrique, false sinon
     */
    public boolean isAntisymmetric() {
    	
    	// TODO DONE
    	// antisymetric si Matrice d'une valeur qui est 0 
    	if(this.getNumCols() == 1 && this.get(0, 0) == 0) {
    		return true;
    	}

    	// boucles sur la matrice
    	for (int i = 0; i < this.getNumRows(); i++) {
    		for (int j = 0; j < this.getNumCols(); j++) {
    			// compare chaque valeur avec son opposé dans la matrice, si pas 
    			// egal à cette même valeur mais négatif, pas antisymetric
				if(this.get(i, j) != -this.get(j, i)) {
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
     *   
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
     *   
     * @param m Matrice dont on veut faire le ET logique avec THIS
     * @return  Matrice de résultat R
     */
	public Matrix and(Matrix m) {
		// On vérifie que les 2 matrices ont la même taille
		if (!this.hasSameSize(m)) {
			throw new IllegalArgumentException("Les matrices doivent avoir la même taille");
		}
		// Création de la matrice de résultat
		Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
		// ET logique des 2 matrices
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
     *   
     * @param m Matrice dont on veut faire le OU logique avec THIS
     * @return  Matrice de résultat R
     */
	public Matrix or(Matrix m) {
		// On vérifie que les 2 matrices ont la même taille
		if (!this.hasSameSize(m)) {
			throw new IllegalArgumentException("Les matrices doivent avoir la même taille");
		}
		// Création de la matrice de résultat
		Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
		// OU logique des 2 matrices
		for (int i = 0; i < this.getNumRows(); i++) {
			for (int j = 0; j < this.getNumCols(); j++) {
				r.set(i, j, this.get(i, j) | m.get(i, j));
			}
		}
		return r;
	}

// Ajout examen Juin 2025
// TODO  ne pas supprimer !!!	
	/**
     * Extrait une sous-matrice de la matrice courante, de dimensions données,<br>
     * à partir de la position spécifiée.<br>
     *   R = éléments de THIS à partir de la position (extractRow, extractCol)<br>
     *   jusqu'à la position (extractRow + height, extractCol + width)<br>
     *   r(i,j) = this(extractRow + i, extractCol + j) 
     *   
     * @param extractRow Indice de la première ligne à partir de laquelle il faut extraire la sous-matrice
     * @param extractCol Indice de la première colonne à partir de laquelle il faut extraire la sous-matrice
     * @param height Hauteur de la sous-matrice (= nombre de lignes de la sous-matrice)
     * @param width Largeur de la sous-matrice (= nombre de colonnes de la sous-matrice)
     * @return  Matrice de résultat R
     */
    public Matrix extractFromThis(int extractRow, int extractCol, int height, int width) {
    	
    	// TODO DONE
    	// on check si les datas sont bien dans la matrice et qu'on ne dépasse pas sinon exception    	
    	if(extractRow < 0) {
    		throw new IllegalArgumentException("extractRow ne peut pas être négatif");
    	} else if (extractCol < 0) {
    		throw new IllegalArgumentException("extractCol ne peut pas être négatif");
    	} else if (this.getNumRows() < extractRow) {
    		throw new IllegalArgumentException("extractRow est trop grand");
    	} else if (this.getNumCols() < extractCol) {
    		throw new IllegalArgumentException("extractRow est trop grand");
    	} else if (this.getNumCols() < extractCol + width) {
    		throw new IllegalArgumentException("nombre de colonnes insuffisant");
    	} else if (this.getNumRows() < extractRow + height) {
    		throw new IllegalArgumentException("nombre de lignes insuffisant");
    	}
    	
    	// on récupère les valeurs de la matrice qu'on ajoute à un tableau 2d pour le renvoyer 
    	// sous forme de matrice
    	int[][] recup = new int[height][width];
    	
    	for (int i = extractRow; i < extractRow+height; i++) {
			for (int j = extractCol; j < extractCol+width; j++) {
				recup[i-extractRow][j-extractCol] = this.get(i, j);
			}
		}

		return new Matrix(recup);
    }

    
    // ------------------------------------------------------------------------
    //  Opérations matrices / scalaire
    // ------------------------------------------------------------------------

    /**
     * Addition d'un nombre à tous les éléments d'une matrice<br>
     *   R = THIS + v<br>
     *   r(i,j) = this(i,j) + v
     *   
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
     *   
     * @param v Valeur scalaire
     * @return  Matrice de résultat
     */
    public Matrix div(int v) {
        if (v == 0) {
            throw new IllegalArgumentException("Division par zéro non autorisée");
        }
        Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, (int)(this.get(i, j) / v));
            }
        }
        return r;
    }
    
    /**
     * ET logique entre un nombre et chaque élément d'une matrice<br>
     *   R = THIS & v<br>
     *   r(i,j) = this(i,j) & v
     *   
     * @param v Valeur scalaire
     * @return  Matrice de résultat
     */
    public Matrix and(int v) {
    	if (v == 0) {
            return new Matrix(this.getNumRows(), this.getNumCols());
        }
        Matrix r = new Matrix(this.getNumRows(), this.getNumCols());
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumCols(); j++) {
                r.set(i, j, this.get(i,j) & v);
            }
        }
        return r;
    }
    
    /**
     * OU logique entre un nombre et chaque élément d'une matrice.<br>
     *   R = THIS | v<br>
     *   r(i,j) = this(i,j) | v
     *   
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
     * NOT logique (complément) de chaque élément d'une matrice<br>
     *   R = NOT(THIS)<br>
     *   r(i,j) = ~this(i,j)
     *   
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
     * Décalage logique à gauche de chaque élément d'une matrice<br>
     *   R = THIS << n<br>
     *   r(i,j) = this(i,j) << n
     *   
     * @param n Valeur du décalage à gauche
     * @return  Matrice de résultat
     */
    public Matrix shiftLeftLogical(int n) {
		// On vérifie que la quantité de décalage est valide
		if (n < 0 || n > Integer.SIZE) {
			throw new IllegalArgumentException("Quantité de décalage invalide");
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
     *   
     * @param n Valeur du décalage à droite
     * @return  Matrice de résultat
     */
    public Matrix shiftRightLogical(int n) {
		// On vérifie que la quantité de décalage est valide
		if (n < 0 || n > Integer.SIZE) {
			throw new IllegalArgumentException("Quantité de décalage invalide");
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
     * Affiche la matrice à l'écran avec un format par défaut
     */
    public void print() {
        print(6);
    }

    /**
     * Affiche la matrice à l'écran avec le nombre de chiffres demandé
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
     * Affiche la matrice à l'écran en considérant que chaque élément
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
