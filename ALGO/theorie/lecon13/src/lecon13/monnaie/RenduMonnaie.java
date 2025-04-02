package lecon13.monnaie;

import java.util.List;

import io.Console;

public class RenduMonnaie {

	private static final List<Integer> COUPURES = List.of(500, 200, 100, 50, 20, 10, 5, 2, 1);

	public static void main(String[] args) {

		int montant = Console.lireInt("Montant ? ");
		for(int coupure : COUPURES) {
			int nombre = montant / coupure;
			if (nombre != 0) {
				System.out.print(nombre + " x " + coupure);
				montant -= coupure * nombre; // Avec un seul opérateur ?
				System.out.print((montant == 0) ? "\n" : " + ");
			}
		}
	}
}
