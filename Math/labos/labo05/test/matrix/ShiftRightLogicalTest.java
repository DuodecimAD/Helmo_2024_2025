package matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class ShiftRightLogicalTest {
	
	Matrix matriceBase = new Matrix(new int[][]{{0xFFFFFFFF, 0x00000000}, {0xF0F0F0F0, 0xA5A5A5A5}});
		
	/* -- public Matrix shiftRight(int n) -- */
	@Test
	public void testShiftRight_0() {		
		assertEquals(true, matriceBase.equals(matriceBase.shiftRightLogical(0)));
	}
	
	@Test
	public void testShiftRight_1() {
		Matrix matriceResult = new Matrix(new int[][]{{0x7FFFFFFF, 0x00000000}, {0x78787878, 0x52D2D2D2}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftRightLogical(1)));
	}
	
	@Test
	public void testShiftRight_2() {
		Matrix matriceResult = new Matrix(new int[][]{{0x3FFFFFFF, 0x00000000}, {0x3C3C3C3C, 0x29696969}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftRightLogical(2)));
	}
	
	@Test
	public void testShiftRight_3() {
		Matrix matriceResult = new Matrix(new int[][]{{0x1FFFFFFF, 0x00000000}, {0x1E1E1E1E, 0x14B4B4B4}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftRightLogical(3)));
	}
	
	@Test
	public void testShiftRight_4() {
		Matrix matriceResult = new Matrix(new int[][]{{0x0FFFFFFF, 0x00000000}, {0x0F0F0F0F, 0x0A5A5A5A}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftRightLogical(4)));
	}
	
	@Test
	public void testShiftRight_5() {
		Matrix matriceResult = new Matrix(new int[][]{{0x07FFFFFF, 0x00000000}, {0x07878787, 0x052D2D2D}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftRightLogical(5)));
	}
	
	@Test
	public void testShiftRight_6() {
		Matrix matriceResult = new Matrix(new int[][]{{0x03FFFFFF, 0x00000000}, {0x03C3C3C3, 0x02969696}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftRightLogical(6)));
	}
	
	@Test
	public void testShiftRight_7() {
		Matrix matriceResult = new Matrix(new int[][]{{0x01FFFFFF, 0x00000000}, {0x01E1E1E1, 0x014B4B4B}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftRightLogical(7)));
	}
	
	@Test
	public void testShiftRight_8() {
		Matrix matriceResult = new Matrix(new int[][]{{0x00FFFFFF, 0x00000000}, {0x00F0F0F0, 0x00A5A5A5}});
		assertEquals(true, matriceResult.equals(matriceBase.shiftRightLogical(8)));
	}
	
	@Test
	public void testShiftRight_Negatif() {
		assertThrows(IllegalArgumentException.class, () -> { matriceBase.shiftRightLogical(-1); }, "Un décalage ne peut pas être négatif");
	}

	@Test
	public void testShiftRight_33() {
		assertThrows(IllegalArgumentException.class, () -> { matriceBase.shiftRightLogical(33); }, "Un décalage ne peut pas être supérieur à 32");
	}

}
