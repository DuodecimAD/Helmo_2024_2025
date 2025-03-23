package poo.lecon06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class MaybeTest {

	@Test
	void ofCreatesDefinedOrUndefinedInstances() {
		Maybe<String> aString = Maybe.of("Coucou");
		Maybe<LocalDate> localDate = Maybe.of(null);
		
		assertTrue(aString.isDefined());
		assertFalse(localDate.isDefined());
//		fail("Décommente-moi");
	}
	
	@Test
	void emptyCreatesUndefinedInstances() {
		assertFalse(Maybe.empty().isDefined());
//		fail("Décommente-moi");
	}
	
	@Test
	void getsADefinedValue() {
		Maybe<String> aString = Maybe.of("Coucou");
		
		assertEquals("Coucou", aString.get());
//		fail("Décommente-moi");
	}
	
	@Test
	void throwAnExceptionWhenGettingAnUndefinedValue() {
		assertThrows(NoSuchElementException.class, () -> { 
			Maybe.empty().get();	
		});
		
		assertThrows(NoSuchElementException.class, () -> { 
			Maybe.of(null).get();	
		});
//		fail("Décommente-moi");
	}
	
	@Test
	void getsOrElseReturnsADefinedValue() {
		Maybe<LocalDate> localDate = Maybe.of(LocalDate.of(2025, 2, 14));
		Maybe<LocalDate> nullDate = Maybe.empty();
		
		assertEquals(LocalDate.of(2025, 2, 14), localDate.getOrElse(LocalDate.EPOCH));
		assertEquals(LocalDate.EPOCH, nullDate.getOrElse(LocalDate.EPOCH));
//		fail("Décommente-moi");
	}

}
