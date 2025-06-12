package imageProcessing;

import matrix.Matrix;
import matrix.Utils;

/**
 * Manipulations d'image - Zoom 2x appliqué au centre d'une image
 *
 */
public class Zoom {
	
	public static void main(String[] args) {
		
		// Chargement et affichage de l'image origine
		Matrix originalImage = Utils.loadImage("images/fleur.jpg");
		Utils.displayMatrix(originalImage, "Fleur");
		
		// Création et affichage de l'image zoomée centrée
		Matrix zoomImage = zoom2Image(originalImage);
		Utils.displayMatrix(zoomImage, "Fleur - zoom 2x");
		
	}
	
	/**
	 * Effectue un zoom de facteur 2 sur une image en extrayant une sous-région centrale 
	 * et en l'agrandissant de manière à obtenir une nouvelle image de mêmes dimensions que l'image originale.
	 * 
	 * Plus précisément, cette méthode extrait une sous-image de taille (largeur/2 × hauteur/2) 
	 * située au centre de l'image originale, puis l'agrandit par un facteur 2 
	 * en dupliquant chaque pixel dans une zone 2×2 (chaque pixel devient un bloc 2×2) pour retrouver les dimensions 
	 * originales de l'image.
	 * 
	 * Exemple : Image 8×8 → extraction d'une zone 4×4 au centre → agrandissement vers 8×8
	 * 
	 * @param image la matrice représentant l'image à traiter; ses dimensions doivent être des nombres pairs.
	 * 
	 * @return une nouvelle matrice de mêmes dimensions que l'image originale, 
	 *         contenant la sous-image centrale agrandie par un facteur 2
	 */
	public static Matrix zoom2Image(Matrix image) {
		
		// TODO HALF DONE
		// on extrait la partie de l'image centrale
		Matrix extractedImage = image.extractFromThis(image.getNumRows()/4, image.getNumCols()/4,image.getNumRows()/2, image.getNumCols()/2);
		// on crée une matrice de taille double à l'image extract
		Matrix zoom = new Matrix(extractedImage.getNumRows()*2, extractedImage.getNumCols()*2);
		// on fait les opérations pour doubler la taille des pixel dans une zone 2x2
		
		// --- pas le temps ---
		return extractedImage;
	}
	
}
