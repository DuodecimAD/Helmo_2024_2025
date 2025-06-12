package bitwise;

import matrix.Matrix;

public class Decode {

	public static void main(String[] args) {
		/*
		 * Décodage d'un message secret
		 */
		Matrix secret = new Matrix(new int[][] {{1292832527,2098138895,1846480655,2031030031,1611599631,588189455,789516047,1812926223,1779371791,1812926223,1712262927,789516047,1779371791,2081361679,2064584463,789516047,1829703439,1712262927,1779371791,1628376847,789516047,1661931279,1779371791,789516047,1645154063,1779371791,2081361679,2081361679,1846480655,1745817359,1779371791,789516047,2081361679,1779371791,1812926223,2098138895,1779371791,2064584463,772738831,789516047,890179343,571412239,638521103}});

		System.out.println("Décodage d'un message secret...");
		Matrix decoded = decode(secret);
		decoded.printAscii();
	}

	/**
	 * Déchiffre le message secret en fonction des consignes de l'énoncé
	 * @param m Message secret chiffré
	 * @return Message en clair
	 */
	public static Matrix decode(Matrix m) {
		Matrix matA = m.shiftLeftLogical(24);
		Matrix matB = m.and(0x0000FF00).shiftLeftLogical(8);
		Matrix matC = m.and(0x00FF0000).shiftRightLogical(8);
		Matrix matD = m.shiftRightLogical(24);
		
		Matrix together = matA.or(matB).or(matC).or(matD);
		Matrix mMsb = together.and(0xF0F0F0F0);
		Matrix mLsb = together.and(0x0F0F0F0F).not();
		Matrix mLsbInvert = mLsb.and(0x0F0F0F0F);

		return mMsb.or(mLsbInvert);
	}
}
