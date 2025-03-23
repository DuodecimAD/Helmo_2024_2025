package poo.labo04.starwars;

import java.util.*;

/**
 * Fais combattre des utilisateurs de la Force.
 * Le vainqueur est le dernier combattant vivant.
 * */
public class Melee {

	private static final String SITH = "Sith";
	private static final String JEDI = "Jedi";
	private String message = "";
	private List<ForceUser> fighters = new ArrayList<>();

	/**
	 * Retourne les types de combattants qu’on peut créer.
	 * 
	 * A priori, on peut créer des Jedi et des Sith. 
	 * */
	public String[] getFightersKind() {
		return new String[] { JEDI, SITH };
	}
	
	/**
	 * Retourne les combattants vivants sous forme de tableaux. 
	 * 
	 * Pour chaque combattant, la méthode retourne son nom, sa classe concrète, ses points de vie et ses points de dégâts. 
	 * */
	public String[][] getFightersArray() {
		String[][] array = new String[fighters.size()][4];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = new String[] {fighters.get(i).getName(), fighters.get(i).getClass().getSimpleName(), "HP: " + String.valueOf(fighters.get(i).getHP()), "DP: " + String.valueOf(fighters.get(i).getDamagePoints())};
		}
		return array;
	}

	/**
	 * Retourne le nombre de combattant vivants. 
	 * */
	public int getAlivesCount() {
		
		return fighters.size();
	}
	
	/**
	 * Retourne les informations relatives à la dernière action valable exécutée. 
	 * */
	public String getLastMessage() {
		return message + "\n";
	}
	
	/**
	 * Crée un utilisateur de la Force correspondant à la requête. 
	 * 
	 * Le paramètre args contient les données nécessaires à la création : le type de combattant souhaité, 
	 * son nom, ses points de vie et de dégâts. 
	 * */
	public void addFighter(AddFighterRequest args) {	
		if(JEDI.equals(args.getKind())) {
			fighters.add(new Jedi(args.getName(), args.getHitPoints(), args.getDamagePoints()));
		} else {
			fighters.add(new Sith(args.getName(), args.getHitPoints(), args.getDamagePoints()));
		}
	}
	
	/**
	 * Choisit un attaquant et une cible aléatoirement puis demande à l’attaquant d’utiliser la Force sur la cible. 
	 * 
	 * La méthode met à jour le dernier message :
	 * <ul>
	 * <li>Le dernier message commence par le résultat de l’utilisation de la Force ;
	 * <li>Si la cible décède, la méthode ajoute le message « … est mort ! » ;
	 * <li>Si il reste un seul combattant vivant, la méthode ajoute le message « Le vainqueur est … ! ».
	 * </ul>
	 * */
	public void makeNextAction() {	
		
		if(getAlivesCount() > 1) {

			Random rand = new Random();
			int firstPickIndex = rand.nextInt(fighters.size());
			while(fighters.get(firstPickIndex).getHP() <= 0) {
				firstPickIndex = rand.nextInt(fighters.size());
			}
			
			if(fighters.get(firstPickIndex) instanceof Jedi) {
				ifAttackerIsJedi(rand, firstPickIndex);

			} else if (fighters.get(firstPickIndex) instanceof Sith) {
				ifAttackerIsSith(rand, firstPickIndex);
			}
			
			ifOneAlive();
		}

	}

	private void ifOneAlive() {
		if(getAlivesCount() <= 1) {
			message += " Le vainqueur est " + getFightersArray()[0][0] + " !";
		}
	}

	private void ifAttackerIsSith(Random rand, int firstPickIndex) {
		Sith attacker = (Sith) fighters.get(firstPickIndex);
		
		int secondPick = rand.nextInt(fighters.size());
		while(fighters.get(secondPick).equals(attacker) || fighters.get(secondPick) instanceof Sith) {
			secondPick = rand.nextInt(fighters.size());
		}
		Jedi target = (Jedi) fighters.get(secondPick);
		message = attacker.useForceOn(target);
		
		if(target.getHP() <= 0) {
			message += target.getName() + " est mort !";
			fighters.remove(target);
		}
	}

	private void ifAttackerIsJedi(Random rand, int firstPickIndex) {
		Jedi attacker = (Jedi) fighters.get(firstPickIndex);
		
		int secondPick = rand.nextInt(fighters.size());
		while(fighters.get(secondPick).equals(attacker) || fighters.get(secondPick) instanceof Jedi) {
			secondPick = rand.nextInt(fighters.size());
		}
		Sith target = (Sith) fighters.get(secondPick);
		message = attacker.useForceOn(target);
		
		if(target.getHP() <= 0) {
			message += target.getName() + " est mort !";
			fighters.remove(target);
		}
	}


}
