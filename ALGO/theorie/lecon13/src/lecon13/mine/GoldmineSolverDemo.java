package lecon13.mine;

import java.util.List;

public class GoldmineSolverDemo {

	private static int[][] squaredGrid = new int[][] { 
		{ 10, 20, 0 }, 
		{ 30, 10, 100 }, 
		{ 10, 10, 10 },
	};
	
	private static int[][] bad1stChoice = new int[][] { 
		{  50, 50, 200 }, 
		{   0,  0,  10 }, 
		{ 100,  0,  10 },
	};

	private static int[][] verticalRectGrid = new int[][] { 
		{1, 3, 1},
		{2, 2, 4},
		{5, 0, 2},
		{0, 6, 1}
	};

	private static int[][] horizontalRectGrid = new int[][] { 
		{1, 3, 1, 5},
		{2, 2, 4, 4},
		{5, 0, 2, 3},
	};

	private static int[][] bigMine = new int[][] { 
		{ 0, 1, 4, 2, 8, 2 }, 
		{ 4, 3, 6, 5, 0, 4 }, 
		{ 1, 2, 4, 1, 4, 6 },
		{ 2, 0, 7, 3, 2, 2 }, 
		{ 3, 1, 5, 9, 2, 4 }, 
		{ 2, 7, 0, 8, 5, 1 } 
	};

	public static void main(String[] args) {
		List<GoldmineSolver> solvers = List.of(new DpGoldmineSolver(), new GreedyGoldmineSolver());

		for (var mine : List.of(squaredGrid, bad1stChoice, verticalRectGrid, horizontalRectGrid, bigMine)) {
			lauchSolver(solvers, mine);
			System.out.println();
		}
	}

	public static void lauchSolver(List<GoldmineSolver> solvers, int[][] mine) {
		for(var solver : solvers) {
			System.out.printf("%s : %d\n", solver.getStrategyName(), solver.solve(mine));
		}
	}
}
