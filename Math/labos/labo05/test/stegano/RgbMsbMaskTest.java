package stegano;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Steganography.java
 * 
 * @author François Schumacker
 */

public class RgbMsbMaskTest {

	@Test
	public void testRgbMsbMask0() {
		assertEquals(0x000000,Steganography.rgbMsbMask(0));
	}
	
	@Test
	public void testRgbMsbMask1() {
		assertEquals(0x808080,Steganography.rgbMsbMask(1));
	}
	
	@Test
	public void testRgbMsbMask2() {
		assertEquals(0xC0C0C0,Steganography.rgbMsbMask(2));
	}
	
	@Test
	public void testRgbMsbMask3() {
		assertEquals(0xE0E0E0,Steganography.rgbMsbMask(3));
	}
	
	@Test
	public void testRgbMsbMask4() {
		assertEquals(0xF0F0F0,Steganography.rgbMsbMask(4));
	}
	
	@Test
	public void testRgbMsbMask5() {
		assertEquals(0xF8F8F8,Steganography.rgbMsbMask(5));
	}
	
	@Test
	public void testRgbMsbMask6() {
		assertEquals(0xFCFCFC,Steganography.rgbMsbMask(6));
	}
	
	@Test
	public void testRgbMsbMask7() {
		assertEquals(0xFEFEFE,Steganography.rgbMsbMask(7));
	}
	
	@Test
	public void testRgbMsbMask8() {
		assertEquals(0xFFFFFF,Steganography.rgbMsbMask(8));
	}

}
