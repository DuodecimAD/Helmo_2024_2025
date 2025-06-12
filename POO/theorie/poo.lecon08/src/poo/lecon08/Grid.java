package poo.lecon08;

import java.util.Objects;

public class Grid {
	private final Checker[] cells;

    public Grid() {
    	cells = new Checker[getRowsCount()*getColsCount()];
    	
    	// après le new, toutes les valeurs valent null
    			
        for (int row = 0; row < getRowsCount(); row++){
            for (int col = 0; col < getColsCount(); col++){
                setValueAt(row, col, Checker.NONE);
            }
        }
    }
    
    public int getRowsCount() {
    	return 6;
    }
    
    public int getColsCount() {
    	return 7;
    }
    
    
	private Checker getValueAt(int row, int col) {
		Objects.checkIndex(row, getRowsCount());
		Objects.checkIndex(col, getColsCount());
		return cells[row*7+col];
	}
	
	private void setValueAt(int row, int col, Checker value) {
		Objects.checkIndex(row, getRowsCount());
		Objects.checkIndex(col, getColsCount());
		Objects.requireNonNull(value);
		cells[row*7+col] = value;
	}
	
	public boolean validate(int column){
        //valid column?
        if (column < 0 || column > this.getColsCount()){
            return false;
        }

        //full column?
        if (this.getValueAt(0,column) != Checker.NONE){
            return false;
        }

        return true;
    }
	

	public boolean isWinner(Checker player){
        //check for 4 across
		if(checkFor4Across(player)) {
        	return true;
        }
        //check for 4 up and down
		if(checkFor4UpAndDown(player)) {
        	return true;
        }
        //check upward diagonal
		if(checkFor4UpwardDiagonal(player)) {
        	return true;
        }

        if(checkFor4UpwardDiagonalRight(player)) {
        	return true;
        }
        return false;
    }

	private boolean checkFor4UpwardDiagonalRight(Checker player) {
		for(int row = 0; row < getRowsCount() - 3; row++){
            for(int col = 0; col < getRowsCount() - 3; col++){
                if (getValueAt(row, col) == player   &&
                		getValueAt(row+1, col+1) == player &&
        				getValueAt(row+2, col+2) == player &&
						getValueAt(row+3, col+3) == player){
                    return true;
                }
            }
        }
		return false;
	}

	private boolean checkFor4UpwardDiagonal(Checker player) {
		for(int row = 3; row < getRowsCount(); row++){
            for(int col = 0; col < getColsCount() - 3; col++){
                if (getValueAt(row, col) == player   &&
                		getValueAt(row-1, col+1) == player &&
        				getValueAt(row-2, col+2) == player &&
						getValueAt(row-3, col+3) == player){
                    return true;
                }
            }
        }
		return false;
	}

	private boolean checkFor4UpAndDown(Checker player) {
		for(int row = 0; row < getRowsCount() - 3; row++){
            for(int col = 0; col < getColsCount(); col++){
                if (getValueAt(row, col) == player   &&
                		getValueAt(row+1, col) == player &&
        				getValueAt(row+2, col) == player &&
						getValueAt(row+3, col) == player){
                    return true;
                }
            }
        }
		return false;
	}

	private boolean checkFor4Across(Checker player) {
		for(int row = 0; row< getRowsCount(); row++){
            for (int col = 0;col < getColsCount() - 3;col++){
                if (getValueAt(row, col) == player   &&
                        getValueAt(row, col+1) == player &&
                        getValueAt(row, col+2) == player &&
                        getValueAt(row, col+3) == player){
                    return true;
                }
            }
        }
		return false;
	}
	
	public void dropTheChecker(Checker player, int play) {
		Objects.requireNonNull(player);
		for (int row = getRowsCount()-1; row >= 0; row--){
		    if(getValueAt(row, play) == Checker.NONE){
		        setValueAt(row, play, player);
		        break;
		    }
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 0 1 2 3 4 5 6\n");
		builder.append("---------------\n");
        for (int row = 0; row < getRowsCount(); row++){
        	builder.append("|");
            for (int col = 0; col < getColsCount(); col++){
            	builder.append(getValueAt(row, col));
            	builder.append("|");
            }
            builder.append("\n");
            builder.append("---------------\n");
        }
        builder.append(" 0 1 2 3 4 5 6\n");
        builder.append("\n");
        
		return builder.toString();
	}

}
