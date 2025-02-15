package poo.labo01.colors;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ColorPaletteGeneratorTest {

	@Test
	void updatePalette_test() {
		ColorPaletteGenerator cg = new ColorPaletteGenerator();
		
		assertArrayEquals(new String[]{"#D90B43", "#D9CB0B", "#0BD926", "#0B94D9", "#790BD9", "#000000"}, cg.updatePalette(217, 11, 67));
	}

}
