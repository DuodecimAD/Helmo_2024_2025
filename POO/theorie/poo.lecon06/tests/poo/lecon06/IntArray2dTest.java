package poo.lecon06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntArray2dTest {

	@Test
	void initsAnArrayOfWithRandomRowAndCols() {
		var randomCol = (int)(1 + Math.random()*IntArray2d.MAX_INDEX);
		var randomRow = (int)(1 + Math.random()*IntArray2d.MAX_INDEX);
		
		//var array = new IntArray2d(randomRow, randomCol);
		var array = new BetterIntArray2d(randomRow, randomCol);
		
		assertEquals(randomRow, array.getRowCount());
		assertEquals(randomCol, array.getColCount());
	}
	
	@Test
	void rejectsEmptyArray() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			//new IntArray2d(0, 1);
			new IntArray2d(0, 1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			//new IntArray2d(1, 0);
			new IntArray2d(1, 0);
		});
	}
	
	@Test
	void rejectsTooBigArray() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			//new IntArray2d(IntArray2d.MAX_INDEX + 1, 1);
			new BetterIntArray2d(IntArray2d.MAX_INDEX + 1, 1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			//new IntArray2d(1, IntArray2d.MAX_INDEX + 1);
			new BetterIntArray2d(1, IntArray2d.MAX_INDEX + 1);
		});
	}
	
	@Test
	void setsArrayValue() {
		var array = new IntArray2d(IntArray2d.MAX_INDEX, IntArray2d.MAX_INDEX);
		var randomCol = (int)(Math.random()*IntArray2d.MAX_INDEX);
		var randomRow = (int)(Math.random()*IntArray2d.MAX_INDEX);
		
		array.setAt(randomRow, randomCol, 42);
		
		assertEquals(42, array.getAt(randomRow, randomCol));
	}
	
	@Test
	void rejectsSettingNegativeIndex() {
		var array = new IntArray2d(IntArray2d.MAX_INDEX, IntArray2d.MAX_INDEX);
		var randomIndex = (int)(Math.random()*IntArray2d.MAX_INDEX);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.setAt(-1, randomIndex, 42);
		});
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.setAt(randomIndex, -1, 42);
		});
	}
	
	@Test
	void SetsWithNegativeIndex() { // FIXME
		var array = new BetterIntArray2d(IntArray2d.MAX_INDEX, IntArray2d.MAX_INDEX);
		var randomIndex = (int)(Math.random()*IntArray2d.MAX_INDEX);
		
		array.setAt(-1, randomIndex, 42);
		array.setAt(randomIndex, -1, 42);
		
		assertEquals(42, array.getAt(array.getRowCount() -1, randomIndex));
		assertEquals(42, array.getAt(randomIndex, array.getColCount() -1));

	}
	
	@Test
	void rejectsGettingNegativeIndex() {
		var array = new IntArray2d(IntArray2d.MAX_INDEX, IntArray2d.MAX_INDEX);
		var randomIndex = (int)(Math.random()*IntArray2d.MAX_INDEX);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.getAt(-1, randomIndex);
		});
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.getAt(randomIndex, -1);
		});
	}
	
	@Test
	void GetsWithNegativeIndex() { // TODO
		var array = new BetterIntArray2d(IntArray2d.MAX_INDEX, IntArray2d.MAX_INDEX);
		var randomIndex = (int)(Math.random()*IntArray2d.MAX_INDEX);
		
		array.setAt(array.getRowCount()-1, array.getColCount()-1, 42);

		assertEquals(42, array.getAt(-1, -1));
		
	}

	@Test
	void rejectsSettingTooLargeIndex() {
		var array = new IntArray2d(IntArray2d.MAX_INDEX, IntArray2d.MAX_INDEX);
		var randomIndex = (int)(Math.random()*IntArray2d.MAX_INDEX);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.setAt(IntArray2d.MAX_INDEX, randomIndex, 42);
		});
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.setAt(randomIndex, IntArray2d.MAX_INDEX, 42);
		});
	}
	
	@Test
	void rejectsGettingTooLargeIndex() {
		var array = new IntArray2d(IntArray2d.MAX_INDEX, IntArray2d.MAX_INDEX);
		var randomIndex = (int)(Math.random()*IntArray2d.MAX_INDEX);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.getAt(IntArray2d.MAX_INDEX, randomIndex);
		});
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.getAt(randomIndex, IntArray2d.MAX_INDEX);
		});
	}
	
	@Test
	void overridesToString() {
		var array = new IntArray2d(2, 3);
		
		var actual = array.toString();
		var expected = 
"""
[
 [0,0,0]
 [0,0,0]
]				
""".strip();
		
		assertEquals(expected, actual);
	}
}
