package bitwise;

import matrix.Matrix;
import matrix.Utils;

public class Imaging {

	public static void main(String[] args) {
		// Chargement de l'image d'une fleur
		Matrix mFleur = Utils.loadImage("img/stegano/Chrysanthemum.jpg");
		Utils.displayMatrix(mFleur,"Chrysanthème");

		// Extraction des canaux R/G/B
		System.out.println(">>> Canaux R, G et B d'une image\n");
		Utils.displayMatrix(redChannel(mFleur), "Canal rouge");
		Utils.displayMatrix(greenChannel(mFleur), "Canal vert");
		Utils.displayMatrix(blueChannel(mFleur), "Canal bleu");

		// Conversion en nuances de gris
		System.out.println(">>> Version en nuances de gris d'une image\n");
		Matrix mGrayScale = grayScale(mFleur);
		Utils.displayMatrix(mGrayScale,"Nuances de gris");
	}

	/**
	 * Extrait le canal rouge d'une image
	 * @param img Image RGB
	 * @return Canal R de l'image de départ
	 */
	public static Matrix redChannel(Matrix img) {

		return img.and(0x00FF0000);
	}
	
	/**
	 * Extrait le canal vert d'une image
	 * @param img Image RGB
	 * @return Canal G de l'image de départ
	 */
	public static Matrix greenChannel(Matrix img) {

		return img.and(0x0000FF00);
	}
	
	/**
	 * Extrait le canal bleu d'une image
	 * @param img Image RGB
	 * @return Canal B de l'image de départ
	 */
	public static Matrix blueChannel(Matrix img) {

		return img.and(0x000000FF);
	}
	
	/**
	 * Conversion d'une image en couleurs vers une image en nuances de gris
	 * @param img Image en couleurs
	 * @return Image en nuances de gris
	 */
	public static Matrix grayScale(Matrix img) {
		
		Matrix red = redChannel(img).shiftRightLogical(16);
		Matrix green = greenChannel(img).shiftRightLogical(8);
		Matrix blue = blueChannel(img);
		
		Matrix average = red.add(green).add(blue).div(3);

		Matrix 	r1 = average.shiftLeftLogical(16);
		Matrix 	r2 = average.shiftLeftLogical(8);

		return r1.or(r2).or(average);
	}

}
