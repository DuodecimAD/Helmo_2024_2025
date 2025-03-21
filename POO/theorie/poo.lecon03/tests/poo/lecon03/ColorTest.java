package poo.lecon03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ColorTest {
	@Test
	public void initsWithValidRGB() {
		Color color = new Color(0,128,255);
//		color.init(0,128,255);
		
		assertEquals(0, color.getR());
		assertEquals(128, color.getG());
		assertEquals(255, color.getB());
//		fail("Décommente-moi");
	}
	
	@Test
	public void initsWithNegativesRGB() {
		Color color = new Color(-1, -1, -1);
//		color.init(-1, -1, -1);
		
		assertEquals(0, color.getR());
		assertEquals(0, color.getG());
		assertEquals(0, color.getB());
//		fail("Décommente-moi");
	}
	
	@Test
	public void initsWithrOverflowedRGB() {
		Color color = new Color(256, 256, 256);
//		color.init(256, 256, 256);
		
		assertEquals(255, color.getR());
		assertEquals(255, color.getG());
		assertEquals(255, color.getB());
//		fail("Décommente-moi");
	}
	
	@Test
	public void interpolatesColors() {
		Color color = new Color(25,10,80);
//		color.init(25,10,80);
			
		assertEquals(0.176f, color.getLightness(), 0.01f);
//		fail("Décommente-moi");
	}

}
