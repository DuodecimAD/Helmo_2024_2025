package poo.lecon01;

public class ColorsProgram {
	public static void main(String[] args) {
		int r = 217;
		int g = 11;
		int b = 67;

		System.out.printf("Black : Luminance=%5.2f %%,Hue=%3.0f°\n", Colors.getLightness(0, 0, 0) * 100, Colors.getHue(0, 0, 0));
		System.out.printf("White : Luminance=%5.2f %%,Hue=%3.0f°\n", Colors.getLightness(255, 255, 255) * 100, Colors.getHue(255, 255, 255));
		System.out.printf("HELMo : Luminance=%5.2f %%,Hue=%3.0f°\n", Colors.getLightness(r, g, b) * 100, Colors.getHue(r, g, b));
		System.out.println(Colors.getLightness(128, 128, 0));
	}
}