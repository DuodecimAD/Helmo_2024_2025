package stegano;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Steganography.java
 * 
 * @author François Schumacker
 */

public class RgbLsbMaskTest {

	@Test
	public void testRgbLsbMask0() {
		assertEquals(0x000000,Steganography.rgbLsbMask(0));
	}
	
	@Test
	public void testRgbLsbMask1() {
		assertEquals(0x010101,Steganography.rgbLsbMask(1));
	}
	
	@Test
	public void testRgbLsbMask2() {
		assertEquals(0x030303,Steganography.rgbLsbMask(2));
	}
	
	@Test
	public void testRgbLsbMask3() {
		assertEquals(0x070707,Steganography.rgbLsbMask(3));
	}
	
	@Test
	public void testRgbLsbMask4() {
		assertEquals(0x0F0F0F,Steganography.rgbLsbMask(4));
	}
	
	@Test
	public void testRgbLsbMask5() {
		assertEquals(0x1F1F1F,Steganography.rgbLsbMask(5));
	}
	
	@Test
	public void testRgbLsbMask6() {
		assertEquals(0x3F3F3F,Steganography.rgbLsbMask(6));
	}
	
	@Test
	public void testRgbLsbMask7() {
		assertEquals(0x7F7F7F,Steganography.rgbLsbMask(7));
	}
	
	@Test
	public void testRgbLsbMask8() {
		assertEquals(0xFFFFFF,Steganography.rgbLsbMask(8));
	}

}
