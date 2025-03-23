package poo.lecon01;

public class Colors {
	public static float TOLERANCE = 0.01f;
	
    /**
     * Retourne la luminosité d'une couleur exprimée en rgb.
     * La luminosité est notamment utile pour convertir une image couleur en noir et blanc.
     *
     * @param r le composant rouge de la couleur dans l'intervalle [0, 256[
     * @param g le composant vert de la couleur dans l'intervalle [0, 256[
     * @param b le composant bleu de la couleur dans l'intervalle [0, 256[
     * 
     * @return un flottant L tel que L in [0.0f, 1.0f[ ET L == (max(r',g',b') - min(r',g',b'))/2.0f 
     * où r',g',b' sont les conversions de r,g,b dans l'intervalle [0, 1[
     * */
	public static float getLightness(int r, int g, int b) {
		int maxComponent = Math.max(r, Math.max(g, b));
		int minComponent = Math.min(r, Math.min(g, b));

		return (maxComponent + minComponent)*0.5f / 255.0f;
	}
	
    /**
     * Retourne la teinte d'une couleur exprimée en rgb.
     * La teinte correspond à un angle identifiant une gamme teinte sur la roue des couleurs.
     * 
     * @param r le composant rouge de la couleur dans l'intervalle [0, 256[
     * @param g le composant vert de la couleur dans l'intervalle [0, 256[
     * @param b le composant bleu de la couleur dans l'intervalle [0, 256[
     * 
     * @return un flottant H tel que H in [0.0f, 1.0f[ ET 
     * cMax = max(r,g,b), cMin = min(r,g,b), delta = cMax - cMin,
     * H = 60*| (g - b)/delta     si cMax = r && g >= b
     *        | (g - b)/delta + 6 si cMax = r && g < b
     *        | (b - r)/delta + 2 si cMax = g
     *        | (r - g)/delta + 4 si cMax = v
     * */
	public static float getHue(int r, int g, int b) {
		int maxComponent = Math.max(r, Math.max(g, b));
		int minComponent = Math.min(r, Math.min(g, b));
		float delta = maxComponent - minComponent;
		if (Math.abs(delta) < TOLERANCE) {
			return 0;
		}

		float hue = 0.0f;
		if (maxComponent == r) {
			hue = ((g - b) / delta) + (g < b ? 6 : 0);
		} else if (maxComponent == g) {
			hue = ((b - r) / delta) + 2;
		} else {
			hue = ((r - g) / delta) + 4;
		}
		return Math.round(60 * hue);
	}

	public static float getSaturation(int r, int g, int b) {
		
	    int cMax = Math.max(Math.max(r, g), b);
	    int cMin = Math.min(Math.min(r, g), b);
	    float delta = (cMax - cMin)/256.0f;
		float lightness = Colors.getLightness(r,g,b);

		if(Math.abs(delta) < TOLERANCE || Math.abs(lightness) == 0) {
			return 0.0f;
		} else {
			return (float) (delta/(1 - Math.abs(2*lightness-1)));
		}
		
	}

    /**
     * Retourne la représentation HSL d'une couleur exprimée en RGB.
     * 
     * @param r le composant rouge de la couleur dans l'intervalle [0, 256[
     * @param g le composant vert de la couleur dans l'intervalle [0, 256[
     * @param b le composant bleu de la couleur dans l'intervalle [0, 256[
     * 
     * @return un tableau de 3 flottants {H, S, L}.
     * */
    public static float[] toHSL(int r, int g, int b) {
    	r = inRange(r);
    	g = inRange(g);
    	b = inRange(b);
    	
        return new float[] {
                getHue(r,g,b),
                getSaturation(r, g, b),
                getLightness(r,g,b),
        };
    }
    
    public static float[] toHSL(int[] rgb) {
        return toHSL(rgb[0], rgb[1], rgb[2]);
    }
    
 
    public static void getComplementary(float[] tableau) {
    	tableau[0] = (float) (tableau[0] + 180.0) % 360;
    
    }
    
    public static int inRange(int component) {
    	
//    	if(component < 0) {
//    		return 0;
//    	} else if(component > 255) {
//    		return 255;
//    	} else {
//    		return component;
//    	}
    	
    	return (component < 0) ? 0 : (component > 255) ? 255 : component;
    	// Utiliser Math.min & Math.max ?
    }
}
