package poo.labo02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellTest {

	@Test
	void getIncantation_NormalTest () {
		Spell spell = new Spell("wingardium leviosa");
		assertEquals("WINGARDIUM LEVIOSA", spell.getIncantation());
	}
	
	@Test
	void getIncantation_NullTest () {
		Spell spell = new Spell(null);
		assertEquals("NO INCANTATION", spell.getIncantation());
	}
	
	@Test
	void getIncantation_BlankTest () {
		Spell spell = new Spell(" \n \t");
		assertEquals("NO INCANTATION", spell.getIncantation());
	}
	
	@Test
	void cast_castsWingardiumLeviosaPositiveTest () {
		Spell spell = new Spell("wingardium leviosa");
		int elapsedTime = 3;
		assertEquals("WINGARDIUM...LEVIOSA !", spell.cast(elapsedTime));
	}
	
	@Test
	void cast_castsWingardiumLeviosa_ZeroTest () {
		Spell spell = new Spell("wingardium leviosa");
		int elapsedTime = 0;
		assertEquals("WINGARDIUM.LEVIOSA !", spell.cast(elapsedTime));
	}
	
	@Test
	void cast_castsWingardiumLeviosa_NegativeTest () {
		Spell spell = new Spell("wingardium leviosa");
		int elapsedTime = -5;
		assertEquals("WINGARDIUM.LEVIOSA !", spell.cast(elapsedTime));
	}
	
	@Test
	void casts_NullTest () {
		Spell spell = new Spell(null);
		int elapsedTime = 5;
		assertEquals("NO.....INCANTATION !", spell.cast(elapsedTime));
	}
	
	@Test
	void castsStupefy_PositiveTest () {
		Spell spell = new Spell("Stupefy");
		int elapsedTime = 5;
		assertEquals("STUPEFY !", spell.cast(elapsedTime));
	}
	
	@Test
	void castsStupefy_NegativeTest () {
		Spell spell = new Spell("Stupefy");
		int elapsedTime = -1;
		assertEquals("STUPEFY !", spell.cast(elapsedTime));
	}
	
	@Test
	void cast_3WordsTest () {
		Spell spell = new Spell("Mucus ad nuseum");
		int elapsedTime = 2;
		assertEquals("MUCUS..AD..NUSEUM !", spell.cast(elapsedTime));
	}
	
	@Test
	void equals_reflexivite () {
		Spell s = new Spell("Mucus ad nuseum");
		assertTrue(s.equals(s));
	}
	
	@Test
	void equals_Null () {
		Spell s = new Spell("Mucus ad nuseum");
		assertFalse(s.equals(null));
	}
	
	@Test
	void equals_Echec () {
		Spell s = new Spell("Mucus ad nuseum");
		String string = "???";
		assertFalse(s.equals(string));
	}
	
	@Test
	void equals_Symetrie_True () {
		Spell s = new Spell("Mucus ad nuseum");
		Spell s2 = new Spell("Mucus ad nuseum");
		assertTrue(s.equals(s2));
	}
	
	@Test
	void equals_Symetrie_False () {
		Spell s = new Spell("Mucus ad nuseum");
		Spell s2 = new Spell("Stupefy");
		assertFalse(s.equals(s2));
	}
	
	@Test
	void equals_Transivite_True () {
		Spell s1 = new Spell("Mucus ad nuseum");
		Spell s2 = new Spell("Mucus ad nuseum");
		Spell s3 = new Spell("Mucus ad nuseum");
		
		assertEquals(true, s1.equals(s2));
		assertTrue(s2.equals(s3));
		assertTrue(s3.equals(s1));
	}
	
	@Test
	void equals_Transivite_False () {
		Spell s1 = new Spell("Mucus ad nuseum");
		Spell s2 = new Spell("Stupefy");
		Spell s3 = new Spell("wingardium leviosa");
		
		assertEquals(false, s1.equals(s2));
		assertFalse(s2.equals(s3));
		assertFalse(s3.equals(s1));
	}

}
