package poo.labo01.colors;

public class ColorPaletteGenerator {
	
	public final String WHITE = "#FFFFFF";
	public final String BLACK = "#000000";
	
	public String[] updatePalette(int chosenRed, int chosenGreen, int chosenBlue) {
		return updatePalette(chosenRed, chosenGreen, chosenBlue, 6);
	}
	
	public String[] updatePalette(int chosenRed, int chosenGreen, int chosenBlue, int nbr) {
		
		String[] couleurs = new String[nbr];
		
		Color c = new Color(chosenRed, chosenGreen, chosenBlue);
		
		couleurs[0] = c.toHTMLHex();
		
		for (int i = 1; i < couleurs.length-1; i++) {		
			couleurs[i] = c.rotate((360/(nbr-1))*i).toHTMLHex();
		}
		
		if(c.getLightness() < 0.3f) {
			couleurs[nbr-1] = WHITE;
		} else {
			couleurs[nbr-1] = BLACK;
		}
		
		return couleurs;
	}

}
