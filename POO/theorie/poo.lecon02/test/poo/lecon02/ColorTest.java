package poo.lecon02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ColorTest {
	@Test
	public void declaringAColorTypeVariable() {
		Color nullColor = null;

		assertNull(nullColor);
	}
	
	@Test
	public void createsAColorWithConstructor() {
		Color slateBlue = new Color(128,128,255);
		
		assertNotNull(slateBlue);
		
		assertEquals(240, slateBlue.getHue(), Color.TOLERANCE);
		assertEquals(1.0f, slateBlue.getSaturation(), Color.TOLERANCE);
		assertEquals(0.751f, slateBlue.getLightness(), Color.TOLERANCE);
	}
	

	@Test
	public void createsAColorWithRgbComponents() {
		Color teal = Color.fromRGB(0,128,128);
		
		assertNotNull(teal);
		
		assertEquals(180, teal.getHue(), Color.TOLERANCE);
		assertEquals(1.0f, teal.getSaturation(), Color.TOLERANCE);
		assertEquals(0.25f, teal.getLightness(), Color.TOLERANCE);
	}
	
	@Test
	public void createsAColorFromHTMLHexFormat() {
		Color white = Color.fromHTML("#ffffff");
		
		assertNotNull(white);

		assertEquals(0.0f, white.getHue(), Color.TOLERANCE);
		assertEquals(0.0f, white.getSaturation(), Color.TOLERANCE);
		assertEquals(1.0f, white.getLightness(), Color.TOLERANCE);
	}
	
	@Test
	public void rejectsColorCreationFromHTMLWhenBadlyFormatted() {
		Color notAColor = Color.fromHTML("ffffff");
		
		assertNull(notAColor);
	}
	
	@Test
	public void createsAColorVariableFromHSL() {
		Color skyBlue = Color.fromHSL(196, 1.0f, 0.64f );
	
		assertEquals(71, skyBlue.getRed());
		assertEquals(206, skyBlue.getGreen());
		assertEquals(255, skyBlue.getBlue());
	}
	
	@Test
	public void relatesHueToRgb() {
		Color red = Color.fromHSL(0, 1, 1);
		Color yellow = Color.fromHSL(60, 1, 1);
		Color green = Color.fromHSL(120, 1, 1);
		Color cyan = Color.fromHSL(180, 1, 1);
		Color blue = Color.fromHSL(240, 1, 1);
		Color magenta = Color.fromHSL(300, 1, 1);
		
		assertEquals(255, red.getRed());
		
		assertEquals(255, yellow.getRed());
		assertEquals(255, yellow.getGreen());
		
		assertEquals(255, green.getGreen());
		
		assertEquals(255, cyan.getGreen());
		assertEquals(255, cyan.getBlue());
		
		
		assertEquals(255, blue.getBlue());
		

		assertEquals(255, magenta.getBlue());
		assertEquals(255, magenta.getRed());
	}
	
	@Test
	public void callingStateQueryMethods() {
		Color helmo = Color.fromRGB(217, 11, 67);
		
		assertEquals(217, helmo.getRed());
		assertEquals(11, helmo.getGreen());
		assertEquals(67, helmo.getBlue());
		assertEquals(344.0f, helmo.getHue(), Color.TOLERANCE);
		assertEquals(0.904f, helmo.getSaturation(), Color.TOLERANCE);
		assertEquals(0.447f, helmo.getLightness(), Color.TOLERANCE);
	}
	
	@Test
	public void equatesOtherColors() {
		Color helmo = Color.fromRGB(217, 11, 67);
		Color clone = Color.fromRGB(217, 11, 67);
		Color other = helmo.rotate(180);
		
		assertEquals(helmo, helmo);
		assertEquals(helmo, clone);
		assertEquals(clone, helmo);
		
		assertNotEquals(helmo, other);
		assertNotEquals(other, clone);
		assertNotEquals(helmo, null);
	}
	
	@Test
	public void relatesHashCodeToEquals() {
		Color helmo = Color.fromRGB(217, 11, 67);
		Color clone = Color.fromRGB(217, 11, 67);
		
		assertEquals(helmo.hashCode(), clone.hashCode());
	}
	
	@Test
	public void helmoColorCreation() {
		Color helmoColor = new Color(217,11,67);
		
		assertNotNull(helmoColor);
		
		Color complementary = helmoColor.getComplementary();
		
		assertEquals(164, complementary.getHue(), Color.TOLERANCE);
		assertEquals(0.904f, complementary.getSaturation(), Color.TOLERANCE);
		assertEquals(0.447f, complementary.getLightness(), Color.TOLERANCE);
	}
	
	@Test
	public void doubleObjetSameOrNot() {
		Color helmo1 = new Color(217,11,67);
		Color helmo2 = helmo1;
		
		// références au même objet
		assertTrue(helmo1 == helmo2);
//		assertFalse(helmo1 == helmo2);
		assertEquals(helmo1, helmo2);
//		assertNotEquals(helmo1, helmo2);
		
		// distincts mais equivalents
		Color helmo4 = new Color(217,11,67);
		
//		assertTrue(helmo1 == helmo4);
		assertFalse(helmo1 == helmo4);
		assertEquals(helmo1, helmo4);
//		assertNotEquals(helmo1, helmo4);
		
		// distincts et différents
		Color helmo3 = new Color(230,15,87);
		
//		assertTrue(helmo1 == helmo3);
		assertFalse(helmo1 == helmo3);
//		assertEquals(helmo1, helmo3);
		assertNotEquals(helmo1, helmo3);
		

	}
}
