package poo.labo04.pmd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests pour la classe DpmineSolver
 */
public class DpGoldminSolverTest {
	/**
	 * test 1
	 */
	@Test
	public void validatesSquaredGrid() {
		int[][] mine = new int[][] { 
			{ 10, 20, 0 }, 
			{ 30, 10, 100 }, 
			{ 10, 10, 10 },
		};
		
		assertEquals(150, DPmineSolver.maxGold(mine, 3, 3));
	}
	
	/**
	 * test 2
	 */
	@Test
	public void validatesVerticalRectangularGrid() {
		int[][] mine = new int[][] { 
			{1, 3, 1},
            {2, 2, 4},
            {5, 0, 2},
            {0, 6, 1}
        };
		
		assertEquals(13, DPmineSolver.maxGold(mine, 4, 3));
	}
	/**
	 * test 3
	 */
	
	@Test
	public void validatesHorizontalRectangularGrid() {
		int[][] mine = new int[][] { 
			{1, 3, 1, 5},
            {2, 2, 4, 4},
            {5, 0, 2, 3},
        };
		
		assertEquals(16, DPmineSolver.maxGold(mine, 3, 4));
	}
	
	/**
	 * test 4
	 */
	@Test
	public void validatesABiggerGrid() {
		int[][] mine = new int[][] { 
			{ 0, 1, 4, 2, 8, 2 }, 
			{ 4, 3, 6, 5, 0, 4 }, 
			{ 1, 2, 4, 1, 4, 6 },
			{ 2, 0, 7, 3, 2, 2 }, 
			{ 3, 1, 5, 9, 2, 4 }, 
			{ 2, 7, 0, 8, 5, 1 } 
		};
		
		assertEquals(33, DPmineSolver.maxGold(mine, 6, 6));
	}
}
