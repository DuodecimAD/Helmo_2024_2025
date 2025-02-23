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
	void cast_casts_NullTest () {
		Spell spell = new Spell(null);
		int elapsedTime = 5;
		assertEquals("NO.....INCANTATION !", spell.cast(elapsedTime));
	}
	
	@Test
	void cast_castsStupefy_PositiveTest () {
		Spell spell = new Spell("Stupefy");
		int elapsedTime = 5;
		assertEquals("STUPEFY !", spell.cast(elapsedTime));
	}
	
	@Test
	void cast_castsStupefy_NegativeTest () {
		Spell spell = new Spell("Stupefy");
		int elapsedTime = -1;
		assertEquals("STUPEFY !", spell.cast(elapsedTime));
	}
	
	@Test
	void cast_cast_3WordsTest () {
		Spell spell = new Spell("Mucus ad nuseum");
		int elapsedTime = 2;
		assertEquals("MUCUS..AD..NUSEUM !", spell.cast(elapsedTime));
	}

}
