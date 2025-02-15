package poo.labo01.colors;

import javax.swing.JFrame;

import poo.labo01.colors.views.SwingColorPaletteChooser;

public class Program {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }

			private void createAndShowGUI() {
				var mainWindow = new JFrame("Poo.Labo01 - Générateur de palettes");
				mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainWindow.setContentPane(new SwingColorPaletteChooser(new ColorPaletteGenerator()));
				mainWindow.setSize(640, 480);
				
				mainWindow.setVisible(true);
				
			}
        });
	}
}
