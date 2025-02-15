package poo.lecon03;

public class Color {
	//TODO: exercice 05
	
	int r;
	int g;
	int b;
	
	public Color(int red, int green, int blue) {
		if(red >= 0 && red <= 255) {
			r = red;
			// r = Math.min(Math.max(r,0), 255);
		} else if (red < 0){
			r = 0;
		} else {
			r = 255;
		}
		
		if(green >= 0 && green <= 255) {
			g = green;
		} else if (green < 0) {
			g = 0;
		} else {
			g = 255;
		}
		
		if(blue >= 0 && red <= 255) {
			b = blue;
		} else if (blue < 0) {
			b = 0;
		} else {
			b = 255;
		}
	}
	
	public int getRed() {
		return r;
	}
	
	public int getGreen() {
		return g;
	}
	
	public int getBlue() {
		return b;
	}
	
	public float getLightness() {
		int max = Math.max(Math.max(g, b), r);
		int min = Math.min(Math.min(g, b), r);
		return ((max + min) * 0.5f) / 255;
	}
	
	public String toString() {
		int red = getRed();
		String redString;
		
		if(red < 10) {
			redString = "00" + red;
		} else if(red < 100) {
			redString = "0" + red;
		} else {
			redString = Integer.toString(red);
		}
		
		int green = getGreen();
		String greenString;
		
		if(green < 10) {
			greenString = "00" + green;
		} else if(green < 100) {
			greenString = "0" + green;
		} else {
			greenString = Integer.toString(green);
		}
		
		int blue = getBlue();
		String blueString;
		
		if(blue < 10) {
			blueString = "00" + blue;
		} else if(blue < 100) {
			blueString = "0" + blue;
		} else {
			blueString = Integer.toString(blue);
		}
		
		return "Color(r: "+ redString +", g: "+ greenString +", b: "+ blueString +")";
	}
	
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
        if(!(o instanceof Color toColor)) {
			return false;
		}
		
		return r == toColor.r && g == toColor.g && b == toColor.b;
	}
}
