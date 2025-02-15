package poo.lecon02;

import java.util.Objects;

import static java.lang.Math.*;

/**
 * Represents a color in RGB or HSL spaces without alpha channel.
 * 
 * Objects from this class are immutable.
 * 
 * @author Nicolas Hendrikx
 * @version 1.0
 * */
public final class Color {
	/**
	 * Error tolerance applied during computation
	 * */
	public static final float TOLERANCE = 0.001f;
	
	private int r;
	private int g;
	private int b;

	/**
	 * Inits a constructed color with (r,g,b) components
	 * 
	 * Any argument outside [0;255] is replaced by the closest value in range.
	 * 
	 * @param r the red component in [0; 255]
	 * @param g the green component in [0; 255]
	 * @param b the blue component in [0; 255]
	 * */
	public Color(int r, int g, int b) {
		this.r = max(min(r, 255), 0);
		this.g = max(min(g, 255), 0);
		this.b = max(min(b, 255), 0);
	}
	
	/**
	 * Returns a new color built from (r,g,b) components
	 * 
	 * Any argument outside [0;255] is replaced by the closest value in range.
	 * 
	 * @param r the red component in [0; 255]
	 * @param g the green component in [0; 255]
	 * @param b the blue component in [0; 255]
	 * */
	public static Color fromRGB(int r, int g, int b) {
		return new Color(r, g, b);
	}

	/**
	 * Returns a new color built from HTML hex color code (e.g. : #00ff00).
	 * 
	 * Returns {@code null} when the argument does not match the expected format.
	 * 
	 * @param htmlColor the HTML hex formatted (r, g, b) components
	 * */
	public static Color fromHTML(String htmlColor) {
		if (!htmlColor.matches("\\#([0-9a-fA-F]){6}")) {
			return null;
		}

		int r = Integer.valueOf(htmlColor.substring(1, 3), 16);
		int g = Integer.valueOf(htmlColor.substring(3, 5), 16);
		int b = Integer.valueOf(htmlColor.substring(5, 7), 16);
		
		return new Color(r, g,b);
	}

	/**
	 * Returns a new color built from (h, s, l) components.
	 * 
	 * @param h the hue components expressed in degrees
	 * @param s the saturation component in [0; 1]
	 * @param l the lightness component in [0; 1]
	 * */
	public static Color fromHSL(float h, float s, float l) {
		h = max(0, min(h, 359));
		s = max(0.0f, min(s, 1.0f));
		l = max(0.0f, min(l, 1.0f));
		
		float c = (1 - Math.abs(2 * l - 1)) * s;
		float x = c * (1 - Math.abs((h / 60) % 2 - 1));
		float m = l - c * 0.5f;

		final float[] rawRGB = Color.computeRawFrom(c, x, h);
		
		int r = Math.round((rawRGB[0] + m)*255);
		int g = Math.round((rawRGB[1] + m)*255);
		int b = Math.round((rawRGB[2] + m)*255);
		
		return new Color(r, g, b);
	}

	private static float[] computeRawFrom(float c, float x, float h) {
		if (h < 60) {
			return new float[] { c, x, 0 };
		} else if (h < 120) {
			return new float[] { x, c, 0 };
		} else if (h < 180) {
			return new float[] { 0, c, x };
		} else if(h < 240) {
			return new float[] { 0, x, c };
		} else if(h < 300) {
			return new float[] { x, 0, c };
		} else {
			return new float[] {c, 0, x};
		}
	}

	/**
	 * Returns the lightness component of this color.
	 * */
	public float getLightness() {
		final int maxComponent = Math.max(r, Math.max(g, b));
		final int minComponent = Math.min(r, Math.min(g, b));

		return (maxComponent + minComponent) / (2.0f * 255.0f);
	}
	/**
	 * Returns the hue component of this color.
	 * */
	public float getHue() {
		final int maxComponent = Math.max(r, Math.max(g, b));
		final int minComponent = Math.min(r, Math.min(g, b));
		final float delta = maxComponent - minComponent;
		if (isTooClose(delta, 0.0f)) {
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

	/**
	 * Returns the saturation component of this color.
	 * */
	public float getSaturation() {
		final int cMax = Math.max(Math.max(r, g), b);
		final int cMin = Math.min(Math.min(r, g), b);
		final float delta = (cMax - cMin) / 255.0f;
		final float lightness = this.getLightness();

		if (isTooClose(delta, 0.0f) || isTooClose(lightness, 0.0f)) {
			return 0.0f;
		} else {
			return delta / (1 - Math.abs(2 * lightness - 1));
		}
	}
	
	private boolean isTooClose(float expected, float actual) {
		float d = Math.abs(expected - actual);
		return d <= TOLERANCE;
	}

	/**
	 * Returns the red component of this color.
	 * */
	public int getRed() {
		return this.r;
	}
	
	/**
	 * Returns the green component of this color.
	 * */
	public int getGreen() {
		return this.g;
	}

	/**
	 * Returns the blue component of this color.
	 * */
	public int getBlue() {
		return this.b;
	}	

	/**
	 * Returns a new color resulting of this color with hue rotated with an angle of {@code angleInDegrees}.
	 * 
	 * @param angleInDegrees clock-wise angle of rotation.
	 * */
	public Color rotate(float angleInDegrees) {
    	return Color.fromHSL((int)(getHue()+180)%360, getSaturation(), getLightness());
    }
	

	/**
	 * Returns the complementary color of this color.
	 * 
	 * The complementary color is this color rotated by an angle of 180 degrees.
	 * */
	public Color getComplementary() {
		return rotate(180);
	}
	
	/**
	 * Returns a new color resulting of this color with lightness replaced by {@code newLightness}.
	 * 
	 * @param newSaturation the saturation to set to the new color.
	 * */
	public Color withSaturation(float newSaturation) {
		return Color.fromHSL(getHue(), newSaturation, getSaturation());
	}
	
	/**
	 * Returns a new color resulting of this color with lightness replaced by {@code newLightness}.
	 * 
	 * @param newLightness the lightness to set to the new color.
	 * */
	public Color withLigthness(float newLightness) {
		return Color.fromHSL(getHue(), getSaturation(), newLightness);
	}
	
	/**
	 * {@inheritDoc}
	 * */
	@Override
	public int hashCode() {
		return Objects.hash(b, g, r);
	}


	/**
	 * {@inheritDoc}
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Color))
			return false;
		Color that = (Color) obj;
		return b == that.b && g == that.g && r == that.r;
	}


}