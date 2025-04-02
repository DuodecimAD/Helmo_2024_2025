package lecon13.cake;

import java.util.List;
import java.util.Objects;

import contrats.Contrat;

public class DPCoupeCake implements CoupeCake {

	private final List<Integer> prix;
	// FIXME: ajoute ici une strucure de données
	
	public DPCoupeCake(List<Integer> prix) {
		this.prix = List.copyOf(Objects.requireNonNull(prix));
	}
	
	@Override
	public int coupe(int longueur) {
		// Vrai canard vole et fait coin-coin 🦆
		Contrat.assureValeurEntre(1, longueur, tailleMax());
		
		// FIXME: Implémente ici la stratégie de programmation dynamique
		
		return 0;
	}

	@Override
	public int tailleMax() {
		return prix.size() - 1;
	}

	@Override
	public String descriptionMethode() {
		return "Programmation dynamique";
	}

}
