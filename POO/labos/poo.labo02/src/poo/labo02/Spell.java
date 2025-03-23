package poo.labo02;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Spell {
	private final static String NO_INCANTATION = "NO INCANTATION";
	private final static String SPELL_REGEX = " ";
	private final static String SPELL_SEPARATOR = ".";
	private final static String SPELL_CASTING = " !";
	private final static Pattern SPELL_PATTERN = Pattern.compile(SPELL_REGEX);

	private String incantation;

	public Spell(String givenIncantation) {

		incantation = Objects.requireNonNullElse(givenIncantation, NO_INCANTATION);

		if (incantation.isBlank()) {
			incantation = NO_INCANTATION;
		}

	}

	public String getIncantation() {
		return this.incantation.toString().toUpperCase();
	}

	public String cast(int elapsedTime) {
		if (elapsedTime <= 0) {
			elapsedTime = 1;
		}
		StringJoiner arrayJoiner = new StringJoiner(SPELL_SEPARATOR.repeat(elapsedTime), "", SPELL_CASTING);

		// String[] splitIncant = getIncantation().split(SPELL_REGEX);
		String[] splitIncant = SPELL_PATTERN.split(getIncantation());

		for (int i = 0; i < splitIncant.length; i++) {
			arrayJoiner.add(splitIncant[i]);
		}

		return arrayJoiner.toString();
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(incantation);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Spell toSpell)) {
			return false;
		}

		return this.incantation == toSpell.incantation;
	}

	@Override
	public String toString() {
		return "Spell(incantation: " + this.getIncantation() + ")";
	}
	

}
