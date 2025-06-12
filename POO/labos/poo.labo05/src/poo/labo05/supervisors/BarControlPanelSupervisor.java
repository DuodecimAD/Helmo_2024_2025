package poo.labo05.supervisors;

import java.util.*;

import poo.labo05.domains.*;
import poo.labo05.views.SwingBarControlView;

/**
 * Provides its view with data by reading the stock and reacts to user requests by updating the stock.
 * */
public final class BarControlPanelSupervisor {
	
	private static final int ONE_BOTTLE = 1;
	private static final int ONE_GLASS = 1;
	private final Stock stock;
	private final Map<String, Wine> wineKeys;

	private SwingBarControlView view;

	/**
	 * Sets up a supervisor supervising the given {@code stock}.
	 * */
	public BarControlPanelSupervisor(Stock stock) {
		this.stock = Objects.requireNonNull(stock);
		this.wineKeys = new HashMap<>();
		for (Wine wine : stock) {
			wineKeys.put(wine.toString(), wine);
		}
	}

	/**
	 * Sets the view of this supervisor.
	 * 
	 * Provides the view with initial data to display.
	 */
	public void setView(SwingBarControlView view) {
		this.view = Objects.requireNonNull(view);

		List<String> sortedWineKeys = new ArrayList<>(wineKeys.keySet());
		Collections.sort(sortedWineKeys);

		view.setWines(sortedWineKeys);

		String[][] stockTable = buildStockTable();
		view.setStockTable(stockTable);
	}

	/**
	 * 
	 * @return
	 */
	private String[][] buildStockTable() {
		String[][] table = new String[stock.size()+2][3]; // the table has winesCount lines
		int row = 0;
		for (Wine wine : stock) {
			table[row][0] = wine.toString();
			table[row][1] = String.format("%d x %4.2f €",
					stock.countBottles(wine),
					stock.purchasePrice(wine));
			table[row][2] = String.format("%d", stock.countVolumeInMl(wine));
			++row;
		}
		
		addValeurStockToTable(table, row);
		++row;
		addChiffreAffaireToTable(table, row);

		return table;
	}

	private void addChiffreAffaireToTable(String[][] table, int row) {
		table[row][0] = "Chiffre d'affaire";
		table[row][1] = String.format("%4.1f €", stock.getTurnOver());
		table[row][2] = "";
	}

	private void addValeurStockToTable(String[][] table, int row) {
		table[row][0] = "Valeur du stock";
		table[row][1] = String.format("%4.1f €", stock.getStockValue());
		table[row][2] = "";
	}

	/**
	 * Called by the view when the user asks for a new bottle consumption.
	 * 
	 * Asks the stock to consume one bottle, then refresh the view data in consequence.
	 * */
	public void consumeBottle(String wineKey, int quantity) {
		Wine wineMatch = wineKeys.get(wineKey);

		if (wineMatch == null) {
			return;
		}
		
		int count = 1;
		while(count <= quantity) {
			// 1. Demander s'il existe une bouteille
			// 2. Si oui, la boire.
			if (stock.countBottles(wineMatch) >= ONE_BOTTLE) {
				stock.consumeBottle(wineMatch);
				++count;
			} else {
				view.showErrorMessage("La réserve est vide ou il n'y a plus de bouteilles pour ce vin");
				count = quantity + 1;
			}
		}
		
		String[][] stockTable = buildStockTable();
		view.setStockTable(stockTable);
	}

	
	/**
	 * Called by the view when the user asks for a new bottle consumption.
	 * 
	 * Asks the stock to consume one bottle, then refresh the view data in consequence.
	 * */
	public void consumeGlass(String wineKey, int quantity) {
		Wine wineMatch = wineKeys.get(wineKey);

		if (wineMatch == null) {
			return;
		}

		int count = 1;
		while(count <= quantity) {
			// 1. Si je peux boire un verre
			// 2. Alors je bois mon verre
			if (stock.countGlasses(wineMatch) >= ONE_GLASS) {
				stock.consumeGlass(wineMatch);
				count++;
			} else {
				view.showErrorMessage("La réserve est vide ou il n'y a plus de bouteilles pour ce vin");
				count = quantity + 1 ; // Pour sortir de la boucle;
			}
		}

		String[][] stockTable = buildStockTable();
		view.setStockTable(stockTable);
	}
}
