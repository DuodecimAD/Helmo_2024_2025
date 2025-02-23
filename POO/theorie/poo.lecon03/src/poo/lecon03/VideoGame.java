package poo.lecon03;

public class VideoGame {
	//DONE exercice 17
	private String nom;
	private PEGIAge age;
	
	VideoGame(String n, PEGIAge a){
		this.nom = n;
		this.age = a;
	}

	public String getName() {
		return nom;
	}

	public PEGIAge getPegiAge() {
		return age;
	}
	
	public void setPEGIAge(PEGIAge age) {
		if(age != null) {
			this.age = age;
		}
		
	}

	public boolean isAllowed(int a) {
		return age.isAllowed(a);
	}
	
	public String toString() {
		return "VideoGame(name: " + this.nom + ", PEGI: " + this.age +")";
	}
	
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
        if(!(o instanceof VideoGame toVideoGame)) {
			return false;
		}
		
		return nom.equals(toVideoGame.nom);
	}
}
