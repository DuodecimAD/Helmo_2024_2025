package poo.lecon04;

public enum PEGIAge {
	PEGI_3(3, "#a5c400"), 
	PEGI_7(7, "#a5c400"), 
	PEGI_12(12, "#f5a200"), 
	PEGI_16(16, "#f5a200"), 
	PEGI_18(18, "#e2011a");

	private final int age;
	private final String hexColor;

	PEGIAge(int age, String hexColor) {
		this.age = age;
		this.hexColor = hexColor;
	}
	
	public boolean isAllowed(int givenAge) {
		return this.age <= givenAge;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getHexColor() {
		return this.hexColor;
	}
}
