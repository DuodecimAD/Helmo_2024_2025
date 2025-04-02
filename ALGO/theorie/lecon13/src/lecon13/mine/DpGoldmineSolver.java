package lecon13.mine;

import java.util.Objects;

/**
 * DP Goldmine Solver:
 * Résoud le problème de la mine d'or par programmation dynamique
 */
public class DpGoldmineSolver implements GoldmineSolver {
	public final static int[] DELTA_ROW = new int[] { -1, 0, 1 }; // used to traverse grid
	public final static int[] DELTA_COL = new int[] { -1, -1, -1 }; // used to traverse grid
	
	private int rowCount;
	private int colCount;
	private int[][] mine;
	/**
	 * maxGold[row][col] est la quantité d'or maximum récoltable de gauche à droite jusqu'à arriver 
	 * à la position (row, col).
	 */
	private int[][] maxGold;
	
	/**
	 * Calcule la quantité maximale minable en un trajet (G -> D)
	 * @param mine la représentation d'une mine sous la forme d'un tableau
	 * @return la quantité maximale d'or que l'on peut miner.
	 */
	@Override
	public int solve(final int[][] mine) {
		initialisation(mine);
		
		//Initialise la 1re colonne de maxGold : ce sont les mêmes quantités que dans la mine.
		maxGoldCol0();

		// On parcourt les colonnes une à une et chaque colonne par ligne.
		for (int curCol = 1; curCol < colCount; curCol++) {
			for (int curRow = 0; curRow < rowCount; curRow++) {
				/* 
				 * Pour chaque position, on calcule dans maxGold[curRow][curCol] le profit max
				 * que l'on peut faire dans les 3 directions possibles.
				 */
				maxGold[curRow][curCol] = bestDig(curCol, curRow);
			}
		}
		
		// Quand maxGold est rempli, la solution au problème est la plus grande valeur de sa dernière colonne.
		return maxGoldAtLastCol();
	}

	private void initialisation(int[][] mine) {
		Objects.requireNonNull(mine);
		rowCount = mine.length;
		colCount = mine[0].length;
		if (rowCount < 1 || colCount < 1)
			throw new IllegalArgumentException("La mine devrait être au moins de dimensions 1 x 1");
		this.mine = mine; // Pas besoin de la copier.
		maxGold = new int[rowCount][colCount];
	}

	/**
	 * Détermine le meilleur profit possible au point (curCol, curRow).
	 * @param curCol
	 * @param curRow
	 * @return le meilleur score possible au point (curCol, curRow).
	 */
	private int bestDig(int curCol, int curRow) {
		/*
		 * Si je suis à la case (curRow, curCol), je peux venir de trois endroits différents :
		 * d'en haut à gauche, de la gauche, ou d'en bas à gauche :
		 * 
		 *  src dest
		 * +---+---+
		 * |H/G|   |
		 * +---+---+
		 * | G | X |
		 * +---+---+
		 * |B/G|   |
		 * +---+---+
		 * Mon profit max à ma position courrante, c'est le profit maximum atteint à l'une de ces trois 
		 * positions (existant dans la mine (!)) + l'or dans ma propre case.
		 * On teste donc ces trois possibilités et on retient le maximum.
		 */
		int max = Integer.MIN_VALUE;
		for (int deltaIndex = 0; deltaIndex < 3; deltaIndex++) {
			int nextRow = curRow + DELTA_ROW[deltaIndex];
			int nextCol = curCol + DELTA_COL[deltaIndex];

			if (rowInBound(nextRow) && colInBound(nextCol)) {
				max = Math.max(max, maxGold[nextRow][nextCol] + mine[curRow][curCol]);
			}
		}
		return max;
	}

	private boolean rowInBound(int row) {
		return row >= 0 && row < rowCount;
	}

	private boolean colInBound(int col) {
		return col >= 0 && col < colCount;
	}

	private int maxGoldAtLastCol() {
		
		int ans = Integer.MIN_VALUE;

		for(int[] maxValuesRow : maxGold) {
			ans = Math.max(ans, maxValuesRow[colCount - 1]);
		}
		return ans;
	}

	/**
	 * Initialise la première colonne de maxGold.
	 */
	private void maxGoldCol0() {
		for (int row = 0; row < mine.length; row++) {
			maxGold[row][0] = mine[row][0];
		}
	}

	@Override
	public String getStrategyName() {
		return "Programmation Dynamique";
	}
}
