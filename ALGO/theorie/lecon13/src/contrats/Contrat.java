package contrats;

public final class Contrat {
	private Contrat () {}
	
	public static void assureValeurEntre(int min, int valeur, int max) {
		if (valeur < min || valeur > max)
			throw new IllegalArgumentException("%d doit être dans [%d..%d]".formatted(valeur, min, max));
	}
}
