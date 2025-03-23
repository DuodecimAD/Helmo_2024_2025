package poo.labo04.starwars;
import javax.swing.JFrame;

import poo.labo04.starwars.views.SwingMeleeView;

/**
 * Point d'entrée du programme.
 * 
 * @author Nicolas Hendrikx
 * */
public class Program {

	/**
	 * Méthode principale.
	 * 
	 * Crée un objet mélée et une vue sur cette mélée.
	 * */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
				var mainWindow = new JFrame("Poo.Labo04 - Star wars Melee");
				mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainWindow.setContentPane(new SwingMeleeView(new Melee()));
				mainWindow.setSize(new java.awt.Dimension(640, 720));
				mainWindow.setMinimumSize(new java.awt.Dimension(640, 600));
				
				mainWindow.setVisible(true);						
        });
	}

}