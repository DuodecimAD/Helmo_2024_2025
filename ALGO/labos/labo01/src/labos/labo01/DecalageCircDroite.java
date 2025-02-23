package labos.labo01;

import java.util.Objects;

public class DecalageCircDroite {

	public static void main(String[] args) {
		

	}
	
	public static void decalageCircDroite(int[] valeurs) {
		Objects.requireNonNull(valeurs, "Le tableau ne doit pas être null");
		
		if(valeurs.length > 0) {
			int pos = valeurs.length-1;
			int tmp = valeurs[valeurs.length-1];
			
			while(pos > 0) {
				valeurs[pos] = valeurs[pos-1];
				pos--;
			}
			valeurs[0] = tmp;
		}
	}

}
