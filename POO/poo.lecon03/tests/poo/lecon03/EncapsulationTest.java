package poo.lecon03;

import org.junit.jupiter.api.Test;

import poo.lecon03.utils.ReflectionAssertions;

public class EncapsulationTest {
	@Test
	public void DiceIsProperlyEncapsulated() {
		ReflectionAssertions.assertAllFieldsPrivate(Dice.class);
		ReflectionAssertions.assertAllConstructorPublic(Dice.class);
		ReflectionAssertions.assertAllMethodsPublic(Dice.class);
	}
	
	@Test
	public void DominoIsProperlyEncapsulated() {
		ReflectionAssertions.assertAllFieldsPrivate(Domino.class);
		ReflectionAssertions.assertAllConstructorPublic(Domino.class);
		ReflectionAssertions.assertAllMethodsPublic(Domino.class);
	}
	
	@Test
	public void ColorIsProperlyEncapsulated() {
		ReflectionAssertions.assertAllFieldsPrivate(Color.class);
		ReflectionAssertions.assertAllConstructorPublic(Color.class);
		ReflectionAssertions.assertAllMethodsPublic(Color.class);
	}
}
