package poo.lecon03;

public enum PEGIAge {
	//TODO exercice 16
	
	PEGI_3(3,"#a5c400"), PEGI_7(7,"#a5c400"), PEGI_12(12,"#f5a200"), PEGI_16(16,"#f5a200"), PEGI_18(18,"#e2011a");
	
	private final int age;
	private final String couleur;
	
	
	PEGIAge(int a, String s) {
		age = a;
		couleur = s;
	}
	
	public boolean isAllowed(int ageTest) {
		return ageTest >= this.age;
	}
	
	public String getColorHex() {
		return this.couleur;
	}
	
}
