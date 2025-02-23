package poo.labo01.colors;

public class ColorPaletteGenerator {
	
	public final int NB_CHOICE = 5;
	
	public final String WHITE = "#FFFFFF";
	public final String BLACK = "#000000";
	public final float BG_TRESH = 0.3f;
	
	public String[] updatePalette(int chosenRed, int chosenGreen, int chosenBlue) {
		return updatePalette(chosenRed, chosenGreen, chosenBlue, NB_CHOICE);
	}
	
	public String[] updatePalette(int chosenRed, int chosenGreen, int chosenBlue, int nbr) {
		
		String[] couleurs = new String[nbr+1];
		
		Color c = new Color(chosenRed, chosenGreen, chosenBlue);
		
		couleurs[0] = c.toHTMLHex();
		float angle = 360.0f/nbr;
		
		for (int i = 1; i < couleurs.length-1; i++) {		
			couleurs[i] = c.rotate(angle*i).toHTMLHex();
		}
		
		if(c.getLightness() < BG_TRESH) {
			couleurs[nbr] = WHITE;
		} else {
			couleurs[nbr] = BLACK;
		}
		
		return couleurs;
	}

}
