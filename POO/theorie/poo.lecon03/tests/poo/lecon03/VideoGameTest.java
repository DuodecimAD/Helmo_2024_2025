package poo.lecon03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VideoGameTest {
	@Test
	public void knowsItsNameAndPegiLabel() {
		VideoGame original = new VideoGame("GTA", PEGIAge.PEGI_18);
		
		assertEquals("GTA", original.getName());
		assertEquals(PEGIAge.PEGI_18, original.getPegiAge());
//		fail("Décommente-moi");
	}
	
	@Test
	public void knowsIfItIsAllowedToGivenAge() {
		VideoGame original = new VideoGame("GTA", PEGIAge.PEGI_18);
		
		assertTrue(original.isAllowed(18));
		assertFalse(original.isAllowed(17));
//		fail("Décommente-moi");
	}
	
	@Test
	public void updatesItPegiAge() {
		VideoGame original = new VideoGame("GTA", PEGIAge.PEGI_18);
		original.setPEGIAge(PEGIAge.PEGI_12);
		
		assertTrue(original.isAllowed(18));
		assertTrue(original.isAllowed(17));
		assertFalse(original.isAllowed(11));
//		fail("Décommente-moi");
	}
	
	@Test
	public void hasAStringRepresentation() {
		VideoGame original = new VideoGame("GTA", PEGIAge.PEGI_18);
		
		assertEquals("VideoGame(name: GTA, PEGI: PEGI_18)", original.toString());
//		fail("Décommente-moi");
	}
	
	@Test
	public void overridesEquality() {
		VideoGame vg1 = new VideoGame("GTA", PEGIAge.PEGI_18);
		VideoGame vg2 = new VideoGame("GTA", PEGIAge.PEGI_12);
		VideoGame vg3 = new VideoGame("Mario Gore", PEGIAge.PEGI_18);
		
		assertEquals(vg1, vg1);
		assertNotEquals(vg1, null);
		
		assertEquals(vg1, vg2);
		assertEquals(vg2, vg1);
		
		assertNotEquals(vg1, vg3);
		assertNotEquals(vg3, vg2);
//		fail("Décommente-moi");
	}
	
	
}
