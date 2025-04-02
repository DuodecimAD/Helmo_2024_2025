package poo.labo05.domains;

import java.util.Objects;

/**
 * Represents a bottle of a given wine.
 * 
 * A bottle has a volume in milliliters, a purchase price and refers to a {@link poo.labo05.domains.Wine}.
 * */
public class WineBottle {
	public static final int BOTTLE_VOL_ML = 750;
	public static final int GLASS_VOL_ML = 125;
	
	private final Wine wine;
	private final double purchasePrice;
	private int volumeInMl;


	/**
	 * Sets up a full bottle of {@link poo.labo05.domains.Wine}
	 * 
	 * @throws NullPointerException when {@code wine} is null
	 * */
    public WineBottle(Wine wine, double purchasePrice) {
        this.wine = Objects.requireNonNull(wine);
        this.purchasePrice = Math.max(0, purchasePrice);
        this.volumeInMl = BOTTLE_VOL_ML; 
    }


	public Wine getWine() {
		return wine;
	}


	public double getPurchasePrice() {
		return purchasePrice;
	}


	public int getVolumeInMl() {
		return volumeInMl;
	}


	private boolean hasEnoughVolume(int glassVolMl) {
		return this.volumeInMl >= glassVolMl;
	}

	/**
	 * 
	 * @param glassVolMl
	 */
	public void drink(int glassVolMl) {
		if(hasEnoughVolume(glassVolMl)) {
			this.volumeInMl -= glassVolMl;
		}
		
	}
    
    
    
}