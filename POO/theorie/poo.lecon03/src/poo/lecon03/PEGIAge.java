package poo.lecon03;

public enum PEGIAge {
	
	PEGI_3(3,"#a5c400"), 
	PEGI_7(7,"#a5c400"), 
	PEGI_12(12,"#f5a200"), 
	PEGI_16(16,"#f5a200"), 
	PEGI_18(18,"#e2011a");
	
	private final int age;
	private final String couleur;
	
	
	PEGIAge(int a, String s) {
		this.age = a;
		this.couleur = s;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public boolean isAllowed(int ageTest) {
		return this.age <= ageTest;
	}
	
	public String getHexColor() {
		return this.couleur;
	}
	
}
