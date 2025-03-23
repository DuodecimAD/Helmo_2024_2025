package poo.labo04.pmd;

/**
 * classe calculant le problème de la mine par programmation dynamique
 */
public class DPmineSolver {
	public final static int[] DELTA_ROW = new int[] { -1, 0, 1 }; // used to traverse grid
	public final static int[] DELTA_COL = new int[] { -1, -1, -1 }; // used to traverse grid

	/**
	 * 
	 * @param mine
	 * @param rowCount
	 * @param colCount
	 * @return
	 */
	public static int maxGold(int[][] mine, int rowCount, int colCount) {
		
		
		int[][] maxValues = new int[rowCount][colCount];

		initialization(mine, rowCount, maxValues);

		for (int curCol = 1; curCol < colCount; curCol++) {
			for (int curRow = 0; curRow < rowCount; curRow++) {
				computeMaxValueForRowCol(mine, rowCount, colCount, maxValues, curCol, curRow);
			}
		}

		int ans = Integer.MIN_VALUE;

		ans = calculMax(rowCount, colCount, maxValues, ans);
		
		return ans;
	}

	private static int calculMax(int rowCount, int colCount, int[][] maxValues, int ans) {
		int newAns = ans;
		for (int i = 0; i < rowCount; i++) {
			newAns = Math.max(newAns, maxValues[i][colCount - 1]);
		}
		return newAns;
	}

	private static void computeMaxValueForRowCol(int[][] mine, int rowCount, int colCount, int[][] maxValues,
			int curCol, int curRow) {
		int max = Integer.MIN_VALUE;
		for (int diagIndex = 0; diagIndex < 3; diagIndex++) {
			int i = curRow + DELTA_ROW[diagIndex];
			int j = curCol + DELTA_COL[diagIndex];

			max = coupleOfIfs(mine, rowCount, colCount, maxValues, curCol, curRow, max, i, j);
		}
		maxValues[curRow][curCol] = max;
	}

	private static int coupleOfIfs(int[][] mine, int rowCount, int colCount, int[][] maxValues, int curCol, int curRow,
			int max, int i, int j) {
		int newMax = max;
		if (coordonatesInMines(rowCount, colCount, i, j)) {
			newMax = maxIfExist(mine, maxValues, curCol, curRow, max, i, j);
		}
		return newMax;
	}

	private static boolean coordonatesInMines(int rowCount, int colCount, int i, int j) {
		return i >= 0 && i < rowCount && j >= 0 && j < colCount;
	}

	private static int maxIfExist(int[][] mine, int[][] maxValues, int curCol, int curRow, int max, int i, int j) {
		int newMax = max;
		if(max < maxValues[i][j] + mine[curRow][curCol]) {
			newMax = maxValues[i][j] + mine[curRow][curCol];
		}
		return newMax;
	}

	private static void initialization(int[][] mine, int rowCount, int[][] maxValues) {
		for (int row = 0; row < rowCount; row++) {
			maxValues[row][0] = mine[row][0];
		}
	}
}
