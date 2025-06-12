package matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class AndTest {

	/* --- public Matrix and(Matrix m) --- */
	
	@Test
	public void testAndM_NotSameSize() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceCarree.and(MatrixTestUtils.matriceRect43); }, "Les matrices doivent avoir la même taille.");
	}
	
	@Test
	public void testAndM_CarreeWithItself() {
		assertEquals(true, MatrixTestUtils.matriceCarree.equals(MatrixTestUtils.matriceCarree.and(MatrixTestUtils.matriceCarree)));
	}
	
	@Test
	public void testAndM_RectwithItself() {
		assertEquals(true, MatrixTestUtils.matriceRect43.equals(MatrixTestUtils.matriceRect43.and(MatrixTestUtils.matriceRect43)));
	}
	
	@Test
	public void testAndM_CarreeWith0() {
		Matrix matriceCarree0 = new Matrix(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
		assertEquals(true, matriceCarree0.equals(MatrixTestUtils.matriceCarree.and(matriceCarree0)));
	}
	
	@Test
	public void testAndM_CarreeWith1() {
		Matrix matriceCarree1 = new Matrix(new int[][]{{0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}});
		assertEquals(true, MatrixTestUtils.matriceCarree.equals(MatrixTestUtils.matriceCarree.and(matriceCarree1)));
	}
	
	@Test
	public void testAndM_CarreeWithDiag1() {
		Matrix matriceCarree1 = new Matrix(new int[][]{{0xFFFFFF, 0, 0}, {0, 0xFFFFFF, 0}, {0, 0, 0xFFFFFF}});
		assertEquals(true, MatrixTestUtils.matriceCarreeDiagonale.equals(MatrixTestUtils.matriceCarree.and(matriceCarree1)));
	}
	
	@Test
	public void testAndM_RectWith0() {
		Matrix matriceRect0 = new Matrix(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
		assertEquals(true, matriceRect0.equals(MatrixTestUtils.matriceRect43.and(matriceRect0)));
	}
	
	@Test
	public void testAndM_RectWith1() {
		Matrix matriceRect1 = new Matrix(new int[][]{{0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}, {0xFFFFFF, 0xFFFFFF, 0xFFFFFF}});
		assertEquals(true, MatrixTestUtils.matriceRect43.equals(MatrixTestUtils.matriceRect43.and(matriceRect1)));
	}
	
	/* --- public Matrix and(int v) --- */
	
	@Test
	public void testAndV_CarreeWith0() {
		Matrix matriceCarree0 = new Matrix(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
		assertEquals(true, matriceCarree0.equals(MatrixTestUtils.matriceCarree.and(0)));
	}
	
	@Test
	public void testAndV_CarreeWith1() {
		assertEquals(true, MatrixTestUtils.matriceCarree.equals(MatrixTestUtils.matriceCarree.and(0xFFFFFF)));
	}
	
	@Test
	public void testAndV_RectWith0() {
		Matrix matriceRect0 = new Matrix(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
		assertEquals(true, matriceRect0.equals(MatrixTestUtils.matriceRect43.and(0)));
	}
	
	@Test
	public void testAndV_RectWith1() {
		assertEquals(true, MatrixTestUtils.matriceRect43.equals(MatrixTestUtils.matriceRect43.and(0xFFFFFF)));
	}
	

}
