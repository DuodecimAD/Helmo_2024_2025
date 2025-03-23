package lecon09.requests;

import io.Console;

public class RequestsDemo {

	private static final String MENU = """
			Que souhaitez-vous faire ?
			1 – Encoder une demande
			2 – Obtenir les informations sur la prochaine demande à traiter
			3 – Valider la demande comme effectuée.
			4 – Annuler dernière demande
			* – Quitter
			> """;

	private static final String AU_REVOIR = "Au revoir.";

	public static void main(String[] args) {
		RequestList rl = new RequestList();

		boolean quitter = false;
		do {
			switch(Console.lireInt(MENU)) {
			case 1 -> {
				encoderDemande(rl);
			}
			case 2 -> {
				imprimerInformations(rl);
			}
			case 3 -> {
				valider(rl);
			}
			case 4 -> {
				annulerDerniere(rl);
			}
			default -> {
				auRevoir();
				quitter = true;
			}
			}
		}while(!quitter);
	}

	private static void annulerDerniere(RequestList rl) {
		rl.cancelLast();
	}

	private static void valider(RequestList rl) {
		rl.markRequestAsDone();
	}

	private static void encoderDemande(RequestList rl) {
		rl.makeNewRequest(Console.lireString("Quel est votre nom ?"),
				Console.lireString("Quel est le motif de votre demande ?"));
	}

	private static void imprimerInformations(RequestList rl) {
		System.out.printf("Nom : %s\n", rl.getNextName());
		System.out.printf("Motif : %s\n\n", rl.getNextDescription());
	}

	private static void auRevoir() {
		System.out.println(AU_REVOIR);
	}
}
