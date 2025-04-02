package lecon13.mine;

public class BFGoldMineSolver implements GoldmineSolver {
	
	@Override
	public int solve(int[][] goldMine) {
		int curMax = 0;
		for(int row=0; row < goldMine.length; ++row) {
			try {
				curMax = max(curMax, solveRec(goldMine, row, 0));
			} catch(Exception e) {
				System.out.print("At row "+row);
			}
		}
		
		return curMax;
	}

	/**
	 * Résoud le problème de manière récursive.
	 * @param goldMine la mine
	 * @param row la ligne de départ
	 * @param col la colonne de départ
	 * @return le profit réalisé
	 */
	private static int solveRec(int[][] goldMine, int row, int col) {
		if(col == goldMine[row].length - 1) {
			return goldMine[row][col];
		}
		
		int term = solveRec(goldMine, row, col + 1);
		
		if(row < goldMine.length - 1) {
			term = max(term, solveRec(goldMine, row + 1, col+1));
		} 
		
		if(row > 0) {
			term = max(term, solveRec(goldMine, row -1, col+1));
		}
		
		return goldMine[row][col] + term;
	}
	
	/**
	 * Calcule la valeur maximum entre une première valeur et les autres.
	 * @param first une première valeur
	 * @param others d'autres valeurs
	 * @return le maximum entre toutes les valeurs
	 */
	private static int max(int first, int...others) {
		int curMax = first;
		for(int other : others) {
			curMax = Math.max(curMax, other);
		}
		return curMax;
	}

	@Override
	public String getStrategyName() {
		return "Brute force";
	}
}
