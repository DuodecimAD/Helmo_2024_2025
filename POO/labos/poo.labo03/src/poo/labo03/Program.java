package poo.labo03;
import javax.swing.JFrame;

import poo.labo03.views.SwingHouseCupView;

public class Program {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }

			private void createAndShowGUI() {
				var mainWindow = new JFrame("Poo.Labo03 - HELSo houses cup");
				mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainWindow.setContentPane(new SwingHouseCupView(new HousesCup()));
				mainWindow.setSize(new java.awt.Dimension(640, 720));
				mainWindow.setMinimumSize(new java.awt.Dimension(640, 600));
				
				mainWindow.setVisible(true);
				
			}
        });

	}

}