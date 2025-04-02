package lecon13.mine;

import java.util.Objects;

public class GreedyGoldmineSolver implements GoldmineSolver {

	public final static int[] DELTA_ROW = new int[] { 0, -1, 1}; // used to traverse grid
	public final static int DELTA_COL = 1; // used to traverse grid
	
	private int rowCount;
	private int colCount;
	private int[][] mine;
	
	@Override
	public int solve(final int[][] mine) {
		initialisation(mine);
		
		// On commence à gauche en cherchant le meilleur emplacement de départ
		int row = maxGoldRowCol0();
		int gold = mine[row][0];
		
		// On parcourt de gauche à droite
		for(int col = 0; col < colCount - 1; col++) {
			// À partir du point (row, col), on calcule le meilleur choix LOCAL
			row = nextBestRow(row, col);
			// On amasse directement l'or récolté
			gold += mine[row][col + 1];
		}
		return gold;
	}
	
	private int nextBestRow(int currRow, int currCol) {
		/*
		 * Si je suis à la case (curRow, curCol), je peux aller à trois endroits différents :
		 * d'en haut à droite, à droite, ou d'en bas à droite :
		 * 
		 *  src dest
		 * +---+---+
		 * |   |H/D|
		 * +---+---+
		 * | X | D |
		 * +---+---+
		 * |   |B/D|
		 * +---+---+
		 * Je suis glouton : je choisis le profit à court terme.
		 */
		int nextCol = currCol + 1;
		int max = mine[currRow][nextCol];
		int bestRow = currRow;
		
		for (int deltaIndex = 1; deltaIndex < 3; deltaIndex++) {
			int nextRow = currRow + DELTA_ROW[deltaIndex];
			
			if (rowInBound(nextRow) && colInBound(nextCol)) {
				if (mine[nextRow][nextCol] > max) {
					max = mine[nextRow][nextCol];
					bestRow = nextRow;
				}
			}
		}
		return bestRow;
	}

	private int maxGoldRowCol0() {
		int max = mine[0][0];
		int rowMax = 0;
		for (int row = 1; row < rowCount; row++) {
			if (mine[row][0] > max) {
				rowMax = row;
				max = mine[row][0];
			}
		}
		return rowMax;
	}

	private void initialisation(int[][] mine) {
		Objects.requireNonNull(mine);
		rowCount = mine.length;
		colCount = mine[0].length;
		if (rowCount < 1 || colCount < 1)
			throw new IllegalArgumentException("La mine devrait être au moins de dimensions 1 x 1");
		this.mine = mine;
	}

	private boolean rowInBound(int row) {
		return row >= 0 && row < rowCount;
	}

	private boolean colInBound(int col) {
		return col >= 0 && col < colCount;
	}
	
	@Override
	public String getStrategyName() {
		return "Greedy";
	}

}
