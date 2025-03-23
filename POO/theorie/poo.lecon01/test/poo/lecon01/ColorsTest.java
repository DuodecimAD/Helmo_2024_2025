package poo.lecon01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorsTest {
    @Test
    public void lightnessForWhiteIs_100_Percent() {
        assertEquals(1.0f, Colors.getLightness(255,255,255), Colors.TOLERANCE);
    }

    @Test
    public void lightnessForBlackIs_0_Percent() {
        assertEquals(0.0f, Colors.getLightness(0,0,0), Colors.TOLERANCE);
    }

    @Test
    public void lightnessForGreyIs_50_Percent() {
        assertEquals(0.5f, Colors.getLightness(128, 128, 128), Colors.TOLERANCE);
    }

    @Test
    public void ligthnessForOliveIs_25_Percent() {
        assertEquals(0.25f, Colors.getLightness(128, 128, 0), Colors.TOLERANCE);
    }

    @Test
    public void hueForMarronIs_0_Degrees() {
        assertEquals(0.0f, Colors.getHue(128,0,0), Colors.TOLERANCE);
    }

    @Test
    public void hueForOliveIs_60_Degrees() {
        assertEquals(60.0f, Colors.getHue(128,128,0), Colors.TOLERANCE);
    }
    
    @Test
    public void SaturationIs_0() {
        assertEquals(0.0f, Colors.getSaturation(0, 0, 0), Colors.TOLERANCE);
        assertEquals(0.0f, Colors.getSaturation(255, 255, 255), Colors.TOLERANCE);
        assertEquals(0.0f, Colors.getSaturation(128, 128, 128), Colors.TOLERANCE);
    }
    
    @Test
    public void SaturationIs_100() {
        assertEquals(1f, Colors.getSaturation(128, 128, 0), Colors.TOLERANCE);
    }
    
    @Test
    public void SaturationIs_90() {
        assertEquals(0.904f, Colors.getSaturation(217, 11, 67), Colors.TOLERANCE);
    }
    
    @Test
    public void toHSL_test() {
    	assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, Colors.toHSL(0, 0, 0), Colors.TOLERANCE);
    	assertArrayEquals(new float[]{344.0f, 0.904f, 0.447f}, Colors.toHSL(217, 11, 67), Colors.TOLERANCE);
    	assertArrayEquals(new float[]{0.0f, 0.0f, 0.9999f}, Colors.toHSL(255, 255, 255), Colors.TOLERANCE);
    }
    
    @Test
    public void complementaryColor_test() {
    	
    	float[] test1 = new float[]{0.0f, 0.0f, 0.0f};
    	Colors.getComplementary(test1);
    	assertArrayEquals(new float[]{180.0f, 0.0f, 0.0f}, test1, Colors.TOLERANCE);
    	
    	float[] test2 = new float[]{180.0f, 0.0f, 0.0f};
    	Colors.getComplementary(test2);
    	assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, test2, Colors.TOLERANCE);
    	
    	float[] test3 = new float[]{344.0f, 0.904f, 0.447f};
    	Colors.getComplementary(test3);
    	assertArrayEquals(new float[]{164.0f, 0.904f, 0.447f}, test3, Colors.TOLERANCE);
    }
    
    @Test
    public void inRange_test() {
    	assertEquals(0, Colors.inRange(0));
    	assertEquals(0, Colors.inRange(-1));
    	assertEquals(0, Colors.inRange(Integer.MIN_VALUE));
    	assertEquals(125, Colors.inRange(125));
    	assertEquals(255, Colors.inRange(255));
    	assertEquals(255, Colors.inRange(256));
    	assertEquals(255, Colors.inRange(Integer.MAX_VALUE));
    }
}