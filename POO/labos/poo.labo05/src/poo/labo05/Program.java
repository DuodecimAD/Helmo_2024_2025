package poo.labo05;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import poo.labo05.domains.*;
import poo.labo05.supervisors.BarControlPanelSupervisor;
import poo.labo05.views.SwingBarControlView;

/**
 * This program handles a wine bottles stock.
 * */
public class Program {
    public static void main(String[] args) {
        List<WineBottle> bottles = new ArrayList<>();

        // putting wine bottles in the stock
        putInStock(bottles, new Wine("Château Margaux", "France", 2015, "Cabernet Sauvignon, Merlot"), 1950.0, 1);
        putInStock(bottles, new Wine("Barolo", "Italie", 2012, "Nebbiolo"), 120.0, 2);
        putInStock(bottles, new Wine("Châteauneuf-du-Pape", "France", 2018, "Grenache, Syrah, Mourvèdre"), 80.0, 3);
        putInStock(bottles, new Wine("Brunello di Montalcino", "Italie", 2016, "Sangiovese"), 150.0, 2);
        putInStock(bottles, new Wine("Rioja Reserva", "Espagne", 2014, "Tempranillo"), 50.0, 4);
        putInStock(bottles, new Wine("Pinot Noir", "France", 2017, "Pinot Noir"), 70.0, 3);
        putInStock(bottles, new Wine("Sancerre", "France", 2019, "Sauvignon Blanc"), 40.0, 4);
        putInStock(bottles, new Wine("Amarone della Valpolicella", "Italie", 2013, "Corvina, Rondinella"), 90.0, 3);
        putInStock(bottles, new Wine("Saint Felicien Malbec", "Argentine", 2020, "Malbec"), 25.0, 4);
        putInStock(bottles, new Wine("Chardonnay", "États-Unis", 2018, "Chardonnay"), 35.0, 4);
        
        SwingUtilities.invokeLater(()-> {
        	var frame = new JFrame("Poo - Labo 05 - wines");
        	var supervisor = new BarControlPanelSupervisor(new Stock(bottles));
        	var panel = new SwingBarControlView(supervisor);
        	
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setContentPane(panel);
        	frame.pack();
        	frame.setVisible(true);
        });
    }
    
    public static void putInStock(List<WineBottle> stock, 
    		Wine wine, double purchasePrice, int bottlesCount) {
  
    	for(int i=0; i < bottlesCount; ++i) {
    		stock.add(new WineBottle(wine, purchasePrice));
    	}
    }
}
