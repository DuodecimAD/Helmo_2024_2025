package lecon13.mine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class BFGoldminSolverTest {
	
	GoldmineSolver solver = new BFGoldMineSolver();
	
	@Test
	public void validatesSquaredGrid() {
		int[][] mine = new int[][] { 
			{ 10, 20, 0 }, 
			{ 30, 10, 100 }, 
			{ 10, 10, 10 },
		};
		
		assertEquals(150, solver.solve(mine));
	}
	
	@Test
	public void validatesVerticalRectangularGrid() {
		int[][] mine = new int[][] { 
			{1, 3, 1},
            {2, 2, 4},
            {5, 0, 2},
            {0, 6, 1}
        };
		
		assertEquals(13, solver.solve(mine));
	}
	
	@Test
	public void validatesHorizontalRectangularGrid() {
		int[][] mine = new int[][] { 
			{1, 3, 1, 5},
            {2, 2, 4, 4},
            {5, 0, 2, 3},
        };
		
		assertEquals(16, solver.solve(mine));
	}
	
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
		
		assertEquals(33, solver.solve(mine));
	}
	
	@Test
	@Timeout(value = 3, unit = TimeUnit.MINUTES, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void validatesABigOne() {
		final int[][] mine = {
			    {1, 3, 1, 5, 0, 2, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2},
			    {2, 2, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4},
			    {5, 0, 2, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5},
			    {1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5},
			    {2, 2, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4},
			    {5, 0, 2, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5},
			    {1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5},
			    {2, 2, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4},
			    {5, 0, 2, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5},
			    {1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5, 4, 6, 8, 9, 7, 2, 1, 3, 5},
		};
		

		assertEquals(203, solver.solve(mine));
	}
}
