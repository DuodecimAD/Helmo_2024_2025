package bitwise;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import matrix.Matrix;

/**
 * Plan de test : Decode.java
 * 
 * @author François Schumacker
 */

public class DecodeTest {
	//Texte en clair
	String texte = "Phrase de test pour decode";
	//Texte codé
	Matrix secret = new Matrix(new int[][] {{1594822415,1729040143,2098138895,1846480655,2081361679,1779371791,789516047,1796149007,1779371791,789516047,2064584463,1779371791,2081361679,2064584463,789516047,2131693327,1611599631,2047807247,2098138895,789516047,1796149007,1779371791,1812926223,1611599631,1796149007,1779371791}});
					
	@Test
	public void testDecode() {
		Matrix texteMatrix = new Matrix(1, texte.length());
		codeMatrix(texte, texteMatrix);
		
		Matrix decodeMatrix = Decode.decode(secret);

		assertNotEquals(null, decodeMatrix);
		assertEquals(true, texteMatrix.equals(Decode.decode(secret)));
	}
	
	//Méthode pour transposer le texte sous forme matriciel
	private void codeMatrix(String str, Matrix matrice){
		for (int i = 0; i < str.length(); i++) {
			matrice.set(0, i, str.charAt(i));
		}
	}

}
