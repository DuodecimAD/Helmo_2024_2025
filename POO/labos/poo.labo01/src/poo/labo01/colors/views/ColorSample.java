package poo.labo01.colors.views;

import java.awt.*;

import javax.swing.*;

public class ColorSample extends JPanel {
	private static final long serialVersionUID = -6814949194864507506L;

	public ColorSample(java.awt.Color backgroundColor, java.awt.Color foregroundColor) {
		super(new GridBagLayout());
		
		var constraint = new GridBagConstraints();
		constraint.insets = new Insets(32, 12, 32, 12);
		
		setBackground(backgroundColor);
		
		JLabel colorLabel = new  JLabel(format(backgroundColor));
		colorLabel.setForeground(foregroundColor);
		
		colorLabel.setSize(128,128);
		
		add(colorLabel, constraint);
	}

	private String format(java.awt.Color color) {
		String redAsString = String.format("%02X", color.getRed());
		String greenAsString = String.format("%02X", color.getGreen());
		String blueAsString = String.format("%02X", color.getBlue());
		
		return "#"+redAsString+greenAsString+blueAsString;
	}

}
