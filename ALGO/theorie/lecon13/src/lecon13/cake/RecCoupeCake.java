package lecon13.cake;

import java.util.List;
import java.util.Objects;

import contrats.Contrat;

public class RecCoupeCake implements CoupeCake {
	
	private final List<Integer> prix; 
	
	public RecCoupeCake(List<Integer> prix) {
		this.prix = List.copyOf(Objects.requireNonNull(prix));
	}

	@Override
	public int coupe(int longueur) {
		// Vrai canard vole et fait coin-coin 🦆
		Contrat.assureValeurEntre(1, longueur, tailleMax());
		
		int prixMax = prix.get(longueur);
		
		for(int part = 1; part <= longueur / 2; part++) {
			int essai = coupe(part) + coupe(longueur - part);
			if (essai > prixMax) {
				prixMax = essai;
			}
		}
		
		return prixMax;
	}

	@Override
	public int tailleMax() {
		return prix.size() - 1;
	}

	@Override
	public String descriptionMethode() {
		return "Diviser pour régner avec récursion";
	}
}
