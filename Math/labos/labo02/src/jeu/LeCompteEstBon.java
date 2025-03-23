package jeu;



public class LeCompteEstBon {
	
    private static final char[] OPERATIONS = {'+', '-', '*', '/'};
    
    /**
     * Recherche récursive d'une solution pour atteindre le nombre recherché en combinant les nombres donnés
     * avec les opérations mathématiques élémentaires (+, -, *, /). 
     *
     * @param tabNombres Le tableau des nombres disponibles pour les opérations
     * @param nombreRecherche  Le nombre recherché.
     * @return le détail des calculs si une solution exacte est trouvée, null sinon.
     */
    public static String solveur(int[] tabNombres, int nombreRecherche) {
            	
    	// cas de base
    	if(tabNombres.length == 1) {
    		if(tabNombres[0] == nombreRecherche) {
    			return "Le compte est bon !";
    		} else {
    			return null;
    		}
    	}
    	
    	//cas récursif
    	int taille = tabNombres.length;
    	// on explore toutes les paires de valeurs (a,b)
    	for (int i = 0; i < taille; i++) {
			for (int j = i+1; j < taille; j++) {
				// on récupère et on ordonne les valeurs a et b
				int a = Math.max(tabNombres[i], tabNombres[j]);
				int b = Math.min(tabNombres[i], tabNombres[j]);
				
				// Préparer le tableau suivant 
				int[] tabSuivant = new int[taille -1];
				
				int pos = 0;
				for (int k = 0; k < tabNombres.length; k++) {
					if(k != i && k != j) {
						tabSuivant[pos++] = tabNombres[k];
					}
				}
				
				// explorer toutes les opérations possibles sur (a,b)
				for (char operation : OPERATIONS) {
					int result = calculer(a, b, operation);
					if(result > 0) {
						// ajouter le resultat à la fin du tableau suivant
						tabSuivant[tabSuivant.length - 1] = result;
						String solution = solveur(tabSuivant, nombreRecherche);
						if(solution != null) {
							return String.format("%d %c %d = %d\n", a, operation, b, result) + solution;
						}
					}
				}
			}
		}
    	
        return null; 
    }
    
    /**
     * Applique l'opération arithmétique choisie aux deux nombres nombre1 et nombre2.
     * @param nombre1 Premier entier naturel (le plus grand)
     * @param nombre2 Deuxième entier naturel (le plus petit)
     * @return le résultat de l'opération arithmétique ou -1 si l'opération est impossible
     */
    private static int calculer(int nombre1, int nombre2, char operation) {
    	
    	
    	switch (operation) {
			case '-': return nombre1 - nombre2;
			case '*': return nombre1 * nombre2;
			case '+': return nombre1 + nombre2;
			case '/': 
				if( nombre1 % nombre2 == 0) {
					return nombre1 / nombre2;
				} else {
					return -1;
				}
				
			default: return -1;
		}
 
    }
    

    /**
     * Sélectionne aléatoirement nombre nombres distincts dans la liste proposée.
     * @param listeNombre Liste des 24 nombres parmi lesquels 'nombre' seront sélectionnés
     * @param nombre Nombre de nombres à sélectionner
     * @return le tableau contenant les 'nombre' nombres sélectionnés
     */
    private static int[] tirageNombres(int[] listeNombres, int nombre) {
    	
        // TODO
    	
        return new int[] {};
    }
    
      
    public static void main(String[] args) {
    	
    	// TODO
    	int[] nombresDepart = {3, 6, 25, 50, 75, 100};
    	int nombreRecherche = 952;
    	String solution = solveur(nombresDepart, nombreRecherche);
    	if (solution != null) {
    		System.out.println(solution);
    	} else {
    		System.out.println("Pas de solution !");
    	}
    }
    
}
	
	

