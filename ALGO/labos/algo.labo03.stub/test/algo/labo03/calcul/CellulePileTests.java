package algo.labo03.calcul;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CellulePileTests {
	
	@Test
	void CellulePileStockeOperateur() {
		CellulePile cell = CellulePile.pourOperateur('r');
		
		assertEquals('r', cell.getOperateur());
		assertEquals(CelluleType.OPERATEUR, cell.getType());
		assertTrue(cell.isOperateur());
		assertThrows(IllegalStateException.class, () -> {cell.getValeur();});
		assertThrows(IllegalStateException.class, () -> {cell.getVariable();});
	}
	
	@Test
	void CellulePileStockeDouble() {
		CellulePile cell = CellulePile.deValeur(Math.PI);
		
		assertEquals(Math.PI, cell.getValeur());
		assertEquals(CelluleType.VALEUR, cell.getType());
		assertTrue(cell.isValeur());
		assertThrows(IllegalStateException.class, () -> {cell.getOperateur();});
		assertThrows(IllegalStateException.class, () -> {cell.getVariable();});
	}
	
	@Test
	void CellulePileStockeVariable() {
		CellulePile cell = CellulePile.pourVariable("liesi");
		
		assertEquals("liesi", cell.getVariable());
		assertEquals(CelluleType.VARIABLE, cell.getType());
		assertTrue(cell.isVariable());
		assertThrows(IllegalStateException.class, () -> {cell.getOperateur();});
		assertThrows(IllegalStateException.class, () -> {cell.getValeur();});
	}
}
