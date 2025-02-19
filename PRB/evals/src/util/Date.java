package util;

import java.time.LocalDateTime;

/**
 * Cette classe propose différentes fonctions permettant de réaliser des
 * opérations relatives aux dates.
 *
 * @author Arnaud Comblin
 * @version 1.2
 */
public class Date {

	/**
	 * Renvoie la date du jour.
	 *
	 * @return un tableau de la forme [jour, mois, annee] contenant la date du jour.
	 */
	public static int[] aujourdhui() {
		LocalDateTime lDT = LocalDateTime.now();
		return new int[] { lDT.getDayOfMonth(), lDT.getMonthValue(), lDT.getYear() };
	}

	/**
	 * Renvoie le numéro du jour actuel.
	 *
	 * @return un entier compris entre 1 et 31 correspondant au numéro du jour
	 *         actuel.
	 */
	public static int jourAuj() {
		return LocalDateTime.now().getDayOfMonth();
	}

	/**
	 * Renvoie le numéro du mois actuel.
	 *
	 * @return un entier compris entre 1 et 12 correspondant au numéro du mois
	 *         actuel.
	 */
	public static int moisAuj() {
		return LocalDateTime.now().getMonthValue();
	}

	/**
	 * Renvoie la valeur de l'année actuelle.
	 *
	 * @return un entier correspondant à la valeur de l'année actuelle exprimée en 4
	 *         chiffres.
	 */
	public static int anneeAuj() {
		return LocalDateTime.now().getYear();
	}

	/**
	 * Renvoie le nom d'un mois sur base de son numéro.
	 *
	 * @param numero le numéro du mois de l'année, de 1 (janvier) à 12 (décembre).
	 * @return le nom du mois si le numéro est valide, null dans le cas contraire.
	 */
	public static String nomDuMois(int numero) {
		final String[] NOMS_MOIS = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août",
				"Septembre", "Octobre", "Novembre", "Décembre" };
		return (numero >= 1 && numero <= NOMS_MOIS.length) ? NOMS_MOIS[numero - 1] : null;
	}

	/**
	 * Renvoie le numéro du jour de l'année pour la date actuelle.
	 *
	 * @return un entier compris entre 1 et 365, ou 366 en cas d'année bissextile.
	 */
	public static int numeroJour() {
		return LocalDateTime.now().getDayOfYear();
	}

	/**
	 * Renvoie le numéro du jour de l'année pour la date spécifiée.
	 *
	 * @param jour  Le numéro du jour du mois, de 1 à 31.
	 * @param mois  Le numéro du mois de l'année, de 1 (janvier) à 12 (décembre).
	 * @param annee L'année exprimée en 4 chiffres.
	 * @return un entier compris entre 1 et 365, ou 366 en cas d'année bissextile.
	 */
	public static int numeroJour(int jour, int mois, int annee) {
		return LocalDateTime.of(annee, mois, jour, 0, 0).getDayOfYear();
	}

}
