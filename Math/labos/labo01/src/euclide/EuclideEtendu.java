package euclide;

/**
 * Soient a et b deux entiers positifs (naturels).
 * 
 * L'algorithme d'Euclide étendu permet de caluler le PGCD de ces deux nombres,
 * 
 * mais aussi les entiers u et v, solution de l'équation :
 * 
 * a * u + b * v = pgcd(a, b) (équation de Bézout)
 * 
 * Lorsque a et b sont premiers entre eux, u est l'inverse modulaire de a modulo
 * b.
 * 
 */

public class EuclideEtendu {
	/**
	 * Algorithme d'Euclide étendu. Implémentation itérative.
	 * 
	 * @param a premier nombre naturel
	 * @param b deuxième nombre naturel
	 * @return PGCD(a, b) et u, v entiers relatifs tels que a * u + b * v = pgcd(a,
	 *         b)
	 * 
	 */
	public static int pgcdEuclideEtendu(int a, int b) {

		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("erreur : a ou b n'est pas un chiffre naturel");
		}

		int s = 1, t = 0, u = 0, uS, v = 1, vS, r, q;

		while (b != 0) {
			r = a % b;
			q = a / b;
			uS = s - (u * q);
			vS = t - (v * q);

			a = b;
			b = r;
			s = u;
			u = uS;
			t = v;
			v = vS;

		}

		return a;

	}

	public static int[] euclideEtendu(int a, int b) {

		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("erreur : a ou b n'est pas un chiffre naturel");
		}

		int s = 1, t = 0, u = 0, uS, v = 1, vS, r, q;

		while (b != 0) {
			r = a % b;
			q = a / b;
			uS = s - (u * q);
			vS = t - (v * q);

			a = b;
			b = r;
			s = u;
			u = uS;
			t = v;
			v = vS;
		}

		return new int[] { a, s, t };
	}
}
