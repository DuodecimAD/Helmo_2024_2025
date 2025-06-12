package stegano;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import matrix.Matrix;

/**
 * Plan de test : Steganography.java
 * 
 * @author Fran�ois Schumacker
 */

public class SteganoCreateTest {
	Matrix imagePublic = new Matrix(new int[][] {{0x000103,0x070F1F,0x3F7FFF},{0xAAAAAA,0xF0F0F0,0x0F0F0F}});
	Matrix imageSecret = new Matrix(new int[][] {{0xFFFEFC,0xF8F0E0,0xC08000},{0x555555,0x0F0F0F,0xF0F0F0}});

	@Test
	public void testSteganoCreate0bit() {
		assertEquals(true, imagePublic.equals(Steganography.steganoCreate(imagePublic, imageSecret, 0)));
	}
	
	@Test
	public void testSteganoCreate1bit() {
		Matrix imageCreate = new Matrix(new int[][] {{0x010103,0x070F1F,0x3F7FFE},{0xAAAAAA,0xF0F0F0,0x0F0F0F}});
		assertEquals(true, imageCreate.equals(Steganography.steganoCreate(imagePublic, imageSecret, 1)));
	}
	
	@Test
	public void testSteganoCreate2bit() {
		Matrix imageCreate = new Matrix(new int[][] {{0x030303,0x070F1F,0x3F7EFC},{0xA9A9A9,0xF0F0F0,0x0F0F0F}});
		assertEquals(true, imageCreate.equals(Steganography.steganoCreate(imagePublic, imageSecret, 2)));
	}
	
	@Test
	public void testSteganoCreate3bit() {
		Matrix imageCreate = new Matrix(new int[][] {{0x070707,0x070F1F,0x3E7CF8},{0xAAAAAA,0xF0F0F0,0x0F0F0F}});
		assertEquals(true, imageCreate.equals(Steganography.steganoCreate(imagePublic, imageSecret, 3)));
	}
	
	@Test
	public void testSteganoCreate4bit() {
		Matrix imageCreate = new Matrix(new int[][] {{0x0F0F0F,0x0F0F1E,0x3C78F0},{0xA5A5A5,0xF0F0F0,0x0F0F0F}});
		assertEquals(true, imageCreate.equals(Steganography.steganoCreate(imagePublic, imageSecret, 4)));
	}
	
	@Test
	public void testSteganoCreate5bit() {
		Matrix imageCreate = new Matrix(new int[][] {{0x1F1F1F,0x1F1E1C,0x3870E0},{0xAAAAAA,0xE1E1E1,0x1E1E1E}});
		assertEquals(true, imageCreate.equals(Steganography.steganoCreate(imagePublic, imageSecret, 5)));
	}

	@Test
	public void testSteganoCreate6bit() {
		Matrix imageCreate = new Matrix(new int[][] {{0x3F3F3F,0x3E3C38,0x3060C0},{0x959595,0xC3C3C3,0x3C3C3C}});
		assertEquals(true, imageCreate.equals(Steganography.steganoCreate(imagePublic, imageSecret, 6)));
	}
	
	@Test
	public void testSteganoCreate7bit() {
		Matrix imageCreate = new Matrix(new int[][] {{0x7F7F7E,0x7C7870,0x604080},{0xAAAAAA,0x878787,0x787878}});
		assertEquals(true, imageCreate.equals(Steganography.steganoCreate(imagePublic, imageSecret, 7)));
	}
	
	@Test
	public void testSteganoCreate8bit() {
		assertEquals(true, imageSecret.equals(Steganography.steganoCreate(imagePublic, imageSecret, 8)));
	}
}
