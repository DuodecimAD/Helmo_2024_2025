package bitwise;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import matrix.Matrix;

/**
 * Plan de test : Imaging.java
 * 
 * @author François Schumacker
 */

public class ImagingTest {
	//Création d'une image de test et de ses équivalents RGB et GrayScale
	Matrix imageTest = new Matrix(new int[][] {{0xFF0000,0x00FF00,0x0000FF},{0x222222,0x990000,0x330033}});
	Matrix imageRed = new Matrix(new int[][] {{0xFF0000,0x000000,0x000000},{0x220000,0x990000,0x330000}});
	Matrix imageGreen = new Matrix(new int[][] {{0x000000,0x00FF00,0x000000},{0x002200,0x000000,0x000000}});
	Matrix imageBlue = new Matrix(new int[][] {{0x000000,0x000000,0x0000FF},{0x000022,0x000000,0x000033}});
	Matrix imageGray = new Matrix(new int[][] {{0x555555,0x555555,0x555555},{0x222222,0x333333,0x222222}});
	
	@Test
	public void testRedComponent() {
		assertEquals(true, imageRed.equals(Imaging.redChannel(imageTest)));
	}
	
	@Test
	public void testGreenComponent() {
		assertEquals(true, imageGreen.equals(Imaging.greenChannel(imageTest)));
	}
	
	@Test
	public void testBlueComponent() {
		assertEquals(true, imageBlue.equals(Imaging.blueChannel(imageTest)));
	}
	
	@Test
	public void testGrayScale() {
		assertEquals(true, imageGray.equals(Imaging.grayScale(imageTest)));
	}

}
