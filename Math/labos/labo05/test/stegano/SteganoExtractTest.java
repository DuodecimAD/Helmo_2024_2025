package stegano;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import matrix.Matrix;

/**
 * Plan de test : Steganography.java
 * 
 * @author Fran�ois Schumacker
 */

public class SteganoExtractTest {

	Matrix image = new Matrix(new int[][] {{0x000103,0x070F1F,0x3F7FFF},{0xAAAAAA,0xF0F0F0,0x0F0F0F},
										   {0xFFFEFC,0xF8F0E0,0xC08000},{0x555555,0x0F0F0F,0xF0F0F0}});

	@Test
	public void testSteganoExtract0bit() {
		Matrix imageExtract = new Matrix(new int[][] {{0,0,0},{0,0,0},{0,0,0},{0,0,0}});
		assertEquals(true, imageExtract.equals(Steganography.steganoExtract(image, 0)));
	}
	
	@Test
	public void testSteganoExtract1bit() {
		Matrix imageExtract = new Matrix(new int[][] {{0x008080,0x808080,0x808080},{0x000000,0x000000,0x808080},
			   										  {0x800000,0x000000,0x000000},{0x808080,0x808080,0x000000}});
		assertEquals(true, imageExtract.equals(Steganography.steganoExtract(image, 1)));
	}
	
	@Test
	public void testSteganoExtract2bit() {
		Matrix imageExtract = new Matrix(new int[][] {{0x0040C0,0xC0C0C0,0xC0C0C0},{0x808080,0x000000,0xC0C0C0},
													  {0xC08000,0x000000,0x000000},{0x404040,0xC0C0C0,0x000000}});
		assertEquals(true, imageExtract.equals(Steganography.steganoExtract(image, 2)));
	}
	
	@Test
	public void testSteganoExtract3bit() {
		Matrix imageExtract = new Matrix(new int[][] {{0x002060,0xE0E0E0,0xE0E0E0},{0x404040,0x000000,0xE0E0E0},
													  {0xE0C080,0x000000,0x000000},{0xA0A0A0,0xE0E0E0,0x000000}});
		assertEquals(true, imageExtract.equals(Steganography.steganoExtract(image, 3)));
	}
	
	@Test
	public void testSteganoExtract4bit() {
		Matrix imageExtract = new Matrix(new int[][] {{0x001030,0x70F0F0,0xF0F0F0},{0xA0A0A0,0x000000,0xF0F0F0},
													  {0xF0E0C0,0x800000,0x000000},{0x505050,0xF0F0F0,0x000000}});
		assertEquals(true, imageExtract.equals(Steganography.steganoExtract(image, 4)));
	}
	
	@Test
	public void testSteganoExtract5bit() {
		Matrix imageExtract = new Matrix(new int[][] {{0x000818,0x3878F8,0xF8F8F8},{0x505050,0x808080,0x787878},
													  {0xF8F0E0,0xC08000,0x000000},{0xA8A8A8,0x787878,0x808080}});
		assertEquals(true, imageExtract.equals(Steganography.steganoExtract(image, 5)));
	}

	@Test
	public void testSteganoExtract6bit() {
		Matrix imageExtract = new Matrix(new int[][] {{0x00040C,0x1C3C7C,0xFCFCFC},{0xA8A8A8,0xC0C0C0,0x3C3C3C},
													  {0xFCF8F0,0xE0C080,0x000000},{0x545454,0x3C3C3C,0xC0C0C0}});
		assertEquals(true, imageExtract.equals(Steganography.steganoExtract(image, 6)));
	}
	
	@Test
	public void testSteganoExtract7bit() {
		Matrix imageExtract = new Matrix(new int[][] {{0x000206,0x0E1E3E,0x7EFEFE},{0x545454,0xE0E0E0,0x1E1E1E},
													  {0xFEFCF8,0xF0E0C0,0x800000},{0xAAAAAA,0x1E1E1E,0xE0E0E0}});
		assertEquals(true, imageExtract.equals(Steganography.steganoExtract(image, 7)));
	}
	
	@Test
	public void testSteganoExtract8bit() {
		assertEquals(true, image.equals(Steganography.steganoExtract(image, 8)));
	}

}
