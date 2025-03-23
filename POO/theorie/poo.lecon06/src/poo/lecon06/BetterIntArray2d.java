package poo.lecon06;

import java.util.Objects;

public class BetterIntArray2d extends IntArray2d {
	
	// méthodes d'objet
	// toString() 				-> &IntArray2d.toString()

	// setAt(int, int, int) 	-> &BetterIntArray2d.setAt() 
	// getAt(int, int) 			-> &BetterIntArray2d.getAt()
	
	// Le domaine des valeurs augmente donc les préconditions sont affaiblies,
	// ce qui est recommandé par le principe de substitution de Liskov
	


	public BetterIntArray2d(int rowCount, int colCount) {
		super(rowCount, colCount);
	}

	@Override
	public int getAt(int row, int col) {
		int c, r;
		
		if(col < 0) {
			c = Objects.checkIndex(col, this.getColCount()-1+col);
		} else {
			c = Objects.checkIndex(col, this.getColCount());
		}
		
		if(row < 0) {
			r = Objects.checkIndex(row, this.getRowCount()-1+row);
		} else {
			r = Objects.checkIndex(row, this.getRowCount());
		}
		

		return getAt(r, c);
	}

}
