package poo.labo05.domains;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Un stock de bouteille de vin.
 * Responsabilités :
 * - Permet de consommer un verre.
 * - Permet de consommer une bouteille.
 * - Permet de consulter l'état du stock.
 */
public class Stock implements Iterable<Wine> {
	
	private static final List<WineBottle> NO_BOTTLE = List.of(); 
	
	private final Map<Wine, List<WineBottle>> bottlesPerWine;	
	
	/**
	 * Construit un stock sur base d'une collection de bouteilles.
	 * @param bottles
	 */
	public Stock(Collection<WineBottle> bottles) {
		bottlesPerWine = new HashMap<>();
		for(var bottle : bottles) {
			if(bottle != null) {
				bottlesPerWine.putIfAbsent(bottle.getWine(), new ArrayList<>()); // Très satisfaisant.	
				bottlesPerWine.get(bottle.getWine()).add(bottle);
			}
		}
	}

	/*
	 * J'aime pas passer une collection. Surtout si le but est de juste itérer
	 * dessus => Iterator<Wine> est emplement suffisant.	
	 * Collection<Wine> getWines()
	 * Sinon, c'est pas graven on implémentera getWines...
	 */
//	public Collection<Wine> getWine() {
//		return Collections.unmodifiableCollection(bottlesPerWine.keySet());
//	}
	
	/**
	 * Obtenir la taille du stock
	 * @return la taille du stock (nombre différents de vins)
	 */
	public int size() {
		return bottlesPerWine.size();
	}
	
	/**
	 * @param w un vin particulier
	 * @return le nombre de bouteille de ce vin dans le stock.
	 */
	public int countBottles(Wine w) {
		int fullBottlesCount = 0;
		for(var bottle : bottlesPerWine.getOrDefault(w, NO_BOTTLE)) {
			if(bottle.getVolumeInMl() == WineBottle.BOTTLE_VOL_ML) {
				++fullBottlesCount;
			}
		}
		return fullBottlesCount;
	}
	
	/**
	 * @param w un vin du stock
	 * @return le nombre de verre entier de ce vin dans le stock.
	 */
	public int countGlasses(Wine w) {
		int countGlasses = 0;
		for(var bottle : bottlesPerWine.getOrDefault(w, NO_BOTTLE)) {
			countGlasses += bottle.getVolumeInMl() / WineBottle.GLASS_VOL_ML;
		}
		return countGlasses;
	}
	
	/**
	 * @param w un vin particulier
	 * @return le volumen en ml de ce vin dans le stock.
	 */
	public int countVolumeInMl(Wine w) {
		int totalVolumne = 0;
		for(var bottle : bottlesPerWine.getOrDefault(w, NO_BOTTLE)) {
			totalVolumne += bottle.getVolumeInMl();
		}
		return  totalVolumne;
	}
	
	/**
	 * Consomme un verre d'un vin w.
	 * @param w le vin à consommer.
	 */
	public void consumeGlass(Wine w) {
		var bottles = bottlesPerWine.getOrDefault(w, NO_BOTTLE);
		WineBottle bottleMatch = null;
		
		for(var bottle :  bottles) {
			if(bottle.hasEnoughVolume(WineBottle.GLASS_VOL_ML)) {
				bottleMatch = bottle;
			}
		}
		if (bottleMatch != null) {
			bottleMatch.drink(WineBottle.GLASS_VOL_ML);
		}
	}
	
	/**
	 * Consomme une boutielle d'un vin w.
	 * @param w le vin à consommer.
	 */
	public void consumeBottle(Wine w) {
		var bottles = bottlesPerWine.getOrDefault(w, NO_BOTTLE);
	
		WineBottle bottleMatch = null;

		for(var bottle :  bottles) {
			if(bottle.getVolumeInMl() == WineBottle.BOTTLE_VOL_ML) {
				bottleMatch = bottle;
			}
		}
		if(bottleMatch != null) {
			bottleMatch.volumeInMl = 0;
		}
	}

	@Override
	public Iterator<Wine> iterator() {
		return Collections.unmodifiableSet(bottlesPerWine.keySet()).iterator();
	}

	/**
	 * @param wine un vin
	 * @return le prix d'achat d'un vin en €. 0 s'il n'est pas en stock.
	 */
	public double purchasePrice(Wine wine) {
		var bottles = bottlesPerWine.getOrDefault(wine, NO_BOTTLE);
		return (bottles.size() > 0) ? bottles.getFirst().getPurchasePrice() : 0.0;
	}
}
