package poo.lecon05;

public class Money {

	private int integer;
	private int cents;
	private String unit;

	public Money(int givenInteger, int givenCents, String givenUnit) {
		integer = givenInteger + givenCents/100;
		cents = givenCents % 100;
		unit = givenUnit;
	}

	public String format(String format) {
		return format
				.replace(":i", Integer.toString(integer))
				.replace(":c", Integer.toString(cents))
				.replace(":u", unit);
	}

	public Money plus(Money term) {
		if(term == null) {
			term = new Money(0, 0, unit);
		}
		
		int report = cents + term.cents;
		return new Money(integer + term.integer + report/100, report%100, unit);
	}

}
