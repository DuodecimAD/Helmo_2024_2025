package poo.labo01.colors.views;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;

import poo.labo01.colors.ColorPaletteGenerator;

public class SwingColorPaletteChooser extends JPanel {	
	private static final long serialVersionUID = -1369870794799178969L;
	
	private final ColorPaletteGenerator updater;
	private final JPanel colorsPalette;
	
	public SwingColorPaletteChooser(ColorPaletteGenerator updater) {
		super(new  GridBagLayout());
		
		this.updater = updater;
		
		var constraint = new GridBagConstraints();
		constraint.insets = new Insets(4, 4, 4, 4);
		
		var colorLabel = new JLabel("Génère une palette à partir d'une couleur.");
		constraint.fill = GridBagConstraints.HORIZONTAL;		
		constraint.gridwidth = 4;
		constraint.gridx = 0;
		constraint.gridy = 0;
		
		add(colorLabel, constraint);
		
		var colorChooser = new JButton("Choisir une couleur...");
		colorChooser.addActionListener(this::onColorChooserPressed);
		constraint.gridx = 0;
		constraint.gridy = 1;
		add(colorChooser, constraint);
		
		colorsPalette = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 0;
		constraint.gridy = 2;
		add(colorsPalette, constraint);
		
		showPalette(new java.awt.Color(211, 11, 27));
	}
	
	private void onColorChooserPressed(ActionEvent evt) {
		var color = JColorChooser.showDialog(this, "Choisissez une couleur", new java.awt.Color(211, 11, 27));
		if(color != null) {
			showPalette(color);
		}
	}

	private void showPalette(Color color) {
		var hexColors = updater.updatePalette(color.getRed(), color.getGreen(), color.getBlue());
		if(hexColors == null) {
			showErrorMessage("La palette retournée vaut null");
			return;
		}
		
		if(hexColors.length < 2) {
			showErrorMessage("Au moins deux couleurs sont attendus");
			return;
		}
		
		for(int colorIndex=0; colorIndex < hexColors.length; ++colorIndex) {
			if(hexColors[colorIndex] == null) {
				showErrorMessage(
						String.format("La couleur %i vaut null", colorIndex));
				return;
			}
			if(!hexColors[colorIndex].matches("\\#([0-9a-fA-F]){6}")) {
				showErrorMessage(
						String.format("La couleur %i ne respecte pas le format #rrggbb. Reçu : %s", 
						colorIndex, hexColors[colorIndex]));
				return;
			}
		}
		
		colorsPalette.removeAll();
		var foregroundColor = java.awt.Color.decode(hexColors[hexColors.length-1]);
		
		for(int i=0; i < hexColors.length-1; ++i) {
			colorsPalette.add(new ColorSample(
					java.awt.Color.decode(hexColors[i]), foregroundColor));
		}
		
		this.updateUI();
	}

	private void showErrorMessage(String msgContent) {
		JOptionPane.showMessageDialog(this, 
				msgContent, 
				"Impossible d'afficher la palette", 
				JOptionPane.ERROR_MESSAGE);
	}
}
