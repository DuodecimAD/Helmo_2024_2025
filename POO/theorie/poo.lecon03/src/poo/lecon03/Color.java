package poo.lecon03;

public class Color {
	//DONE exercice 05
	//DONE exercice 12.3
//	private int r;
//	private int g;
//	private int b;
	private int packed;
	
	public Color(int red, int green, int blue) {
		int r,g,b;
		if(red >= 0 && red <= 255) {
			r = red;
		} else if (red < 0){
			r = 0;
		} else {
			r = 255;
		}
		// r = Math.min(Math.max(r,0), 255);
		
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
		//DONE exercice 13
		packed = (r << 16) | (g << 8) | b;
	}
	
	public int getR() {
		return (packed >> 16) & 0xFF;
	}

	public void setR(int r) {
		this.packed = packed << 16 & 0xFF;
	}

	public int getG() {
		return (packed >> 8) & 0xFF;
	}

	public void setG(int g) {
		this.packed = packed << 8 & 0xFF;
	}

	public int getB() {
		return packed & 0xFF;
	}

	public void setB(int b) {
		this.packed  = packed & 0xFF;
	}

	public float getLightness() {
		int max = Math.max(Math.max(getG(), getB()), getR());
		int min = Math.min(Math.min(getG(), getB()), getR());
		return ((max + min) * 0.5f) / 255;
	}
	
	//DONE exercice 08
	public String toString() {
		int red = getR();
		String redString;
		
		if(red < 10) {
			redString = "00" + red;
		} else if(red < 100) {
			redString = "0" + red;
		} else {
			redString = Integer.toString(red);
		}
		
		int green = getG();
		String greenString;
		
		if(green < 10) {
			greenString = "00" + green;
		} else if(green < 100) {
			greenString = "0" + green;
		} else {
			greenString = Integer.toString(green);
		}
		
		int blue = getB();
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
	
	//DONE exercice 09
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
        if(!(o instanceof Color toColor)) {
			return false;
		}
		
		return getR() == toColor.getR() && getG() == toColor.getG() && getB() == toColor.getB();
	}
}
