package poo.lecon03;

public class VideoGame {
	//TODO exercice 17
	private String nom;
	private PEGIAge age;
	
	VideoGame(String n, PEGIAge a){
		this.nom = n;
		this.age = a;
	}

	public String getNom() {
		return nom;
	}

	public PEGIAge getAge() {
		return age;
	}
	
	public boolean isAgePEGI(int a) {
		return age.isAllowed(a);
	}
	
	public String toString() {
		return "nom : " + this.nom + ", age : " + this.age;
	}
	
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
        if(!(o instanceof VideoGame toVideoGame)) {
			return false;
		}
		
		return nom == toVideoGame.nom && age == toVideoGame.age;
	}
}
