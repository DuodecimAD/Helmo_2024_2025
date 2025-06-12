package stegano;

import matrix.Matrix;
import matrix.Utils;

public class Steganography {

	public static void main(String[] args) {
		
		System.out.println(">>> Stéganographie\n");
		
		/*
		 * Extraction d'une image cachée dans un stéganogramme...
		 */
		System.out.println("Extraction d'image cachée...");
		// Chargement et affichage du stéganogramme
		Matrix mSteganogram = Utils.loadImage("img/stegano/steganogram.png");
		Utils.displayMatrix(mSteganogram, "Stéganogramme");

		// Extraction de l'image secrète codée sur 3 bits par couleur
		Matrix mSecret = steganoExtract(mSteganogram, 3);
		Utils.displayMatrix(mSecret, "Image cachée");

		/*
		 * Création d'un stéganogramme...
		 */
		System.out.println("Création d'un stéganogramme...");

		// Chargement de l'image d'une fleur
		Matrix mFleur = Utils.loadImage("img/stegano/Chrysanthemum.jpg");
		Utils.displayMatrix(mFleur,"Chrysanthème");

		// Chargement de l'image d'un Koala
		Matrix mKoala = Utils.loadImage("img/stegano/Koala.jpg");
		Utils.displayMatrix(mKoala, "Koala");

		// Création du stéganogramme
		mSteganogram = steganoCreate(mFleur, mKoala, 4);
		Utils.displayMatrix(mSteganogram, "Stéganogramme Koala");
		
		// Extraction de l'image cachée (vérification)
		mSecret = steganoExtract(mSteganogram, 4);
		Utils.displayMatrix(mSecret, "Image cachée Koala");
		
	}
	
	/**
	 * Crée un stéganogramme qui cache une image dans une autre image
	 * @param publicImage - objet Matrix contenant l'image visible
	 * @param secretImage - objet Matrix contenant l'image à cacher
	 * @param hiddenBits - nombre de bits utilisés (par couleur) pour cacher l'image
	 * @return un objet Matrix contenant le stéganogramme
	 */
	public static Matrix steganoCreate(Matrix publicImage, Matrix secretImage, int hiddenBits) {
		int maskHidden = rgbMsbMask(hiddenBits);
		int mask = rgbMsbMask(8-hiddenBits);
		
		Matrix image = publicImage.and(mask);
		Matrix hiddenImage = secretImage.and(maskHidden);
		Matrix newPos = hiddenImage.shiftRightLogical(8-hiddenBits);
		
		return image.or(newPos);
	}
	
	/**
	 * Extrait l'image cachée dans un stéganogramme
	 * @param steganogram - objet Matrix contenant steganogram
	 * @param hiddenBits - nombre de bits utilisés (par couleur) pour cacher l'image
	 * @return un objet Matrix contenant l'image cachée
	 */
	public static Matrix steganoExtract(Matrix steganogram, int hiddenBits) {
		int mask = rgbLsbMask(hiddenBits);
		
		Matrix hiddenImage = steganogram.and(mask);

		return hiddenImage.shiftLeftLogical(8 - hiddenBits);
	}

	public static int rgbLsbMask(int n) {
	    int blue = (int) Math.pow(2, n)-1;
		int green = blue << 8;
		int red = blue << 16;
		
		return red | green | blue;
	}

	public static int rgbMsbMask(int n) {
		int blue = 256 - (int) Math.pow(2, 8-n);
		int green = blue << 8;
		int red = blue << 16;
		
		return red | green | blue;
	}
}
