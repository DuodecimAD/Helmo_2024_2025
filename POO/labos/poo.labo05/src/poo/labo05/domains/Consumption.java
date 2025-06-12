package poo.labo05.domains;

/**
 * 
 */
public enum Consumption {
	BOTTLE {
		@Override
		public double computePurchasePrice(double bottlePrice) {
			
			return bottlePrice * BOTTLE_PRICE_FACTOR;
		}
	}, 
	GLASS {
		@Override
		public double computePurchasePrice(double bottlePrice) {
			double priceOfGlass = 0.0;
			
			if(bottlePrice < PRICE_50) {
				priceOfGlass = (bottlePrice / GLASS_TO_BOTTLE_RATIO) * 1.56;
			} else if (bottlePrice < PRICE_100) {
				priceOfGlass = (bottlePrice / GLASS_TO_BOTTLE_RATIO) * 1.66;
			} else if (bottlePrice < PRICE_1000) {
				priceOfGlass = (bottlePrice / GLASS_TO_BOTTLE_RATIO) * 1.99;
			}
			
			return round(priceOfGlass);
		}
	};
	
	private static final int PRICE_1000 = 1000;
	private static final int PRICE_100 = 100;
	private static final int PRICE_50 = 50;
	private static final double BOTTLE_PRICE_FACTOR = 1.2;
	private static final double GLASS_TO_BOTTLE_RATIO = 6;

	public abstract double computePurchasePrice(double bottlePrice);
	
	private static double round(double price) {
		return Math.ceil(price * 10) / 10;
	}
	

}
