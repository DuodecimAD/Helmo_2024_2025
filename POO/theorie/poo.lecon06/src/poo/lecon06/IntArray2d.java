package poo.lecon06;

import java.util.*;


/**
 * Représente un tableau 2d non-vide d'entiers.
 * 
 * @implNote L'implémentation favorise la mise en cache de tout l'objet et évite les sauts en mémoire.
 * */
public class IntArray2d {
	
	// méthodes d'objet
	// toString() 		-> &IntArray2d.toString()

	// setAt() 			-> &IntArray2d.setAt() 
	// getAt() 			-> &IntArray2d.getAt() 

	
	public static final int MAX_INDEX = 999;
	private final int rowCount;
	private final int colCount;
	private int[] data;

	/**
	 * Construit un tableau rowCount lignes et colCount colonnes.
	 * <p>
	 * Après l'appel, chaque élément {@code [row, col] == 0 (row=0,...,rowCount-1; col=0,...,colCount-1)}
	 * </p>
	 * @param rowCount un entier compris dans {@code [1; MAX_INDEX[}
	 * @param colCount un entier compris dans {@code [1; MAX_INDEX[}
	 * 
	 * @throws IndexOutOfBoundsException si rowCount ou colCount sont hors de {@code [1; MAX_INDEX[}
	 * */
	public IntArray2d(int rowCount, int colCount) {
		this.rowCount = 1 + Objects.checkIndex(rowCount - 1, MAX_INDEX);//0 < rowCount < MAX_INDEX
		this.colCount = 1 + Objects.checkIndex(colCount - 1, MAX_INDEX);//0 < colCount < MAX_INDEX
		this.data = new int[rowCount * colCount];
	}
	
	
	public int getRowCount() {
		return rowCount;
	}

	public int getColCount() {
		return colCount;
	}

	/**
	 * Affecte value à l'élément {@code [row, col]}.
	 * <p>Après l'appel {@code this.get(row, col) == value}</p>
	 * 
	 * @throws IndexOutOfBoundsException si row ou col sont respectivement hors de {@code [0, rowCount]} ou de  {@code [0, colCount]}
	 * */
	public void setAt(int row, int col, int value) {
		int r = Objects.checkIndex(row, rowCount);
		int c = Objects.checkIndex(col, colCount);
		
		data[r * colCount + c] = value;
	}
	
	/**
	 * Retourne l'élément {@code [row, col]}.
	 * 
	 * @throws IndexOutOfBoundsException si row ou col sont respectivement hors de {@code [0, rowCount]} ou de  {@code [0, colCount]}
	 * */
	public int getAt(int row, int col) {
		int c = Objects.checkIndex(col, colCount);
		int r = Objects.checkIndex(row, rowCount);
		
		return data[r * colCount + c];
	}
	
	/**
	 * Retourne une représentation du tableau.
	 * */
	@Override
	public String toString() {
		var rowJoiner = new StringJoiner("","[\n", "]");
		
		for(int i=0; i < getRowCount(); ++i) {
			var colJoiner = new StringJoiner(","," [","]\n");
			
			for(int j=0; j < getColCount(); ++j) {
				colJoiner.add(""+this.getAt(i, j));
			}
			
			rowJoiner.add(colJoiner.toString());
		}
		
		return rowJoiner.toString();
	}
}
