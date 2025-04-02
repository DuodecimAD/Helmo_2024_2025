package poo.labo05.domains;

/**
 * Describes wine metadata such as its name, region, grape varieties, and so on.
 * 
 * This class is immutable.
 * */
public record Wine (String name, String region, int year, String grapeVarieties)
{

	@Override
	public String toString() {
		return String.format("%s - %s (%d)", region(), name(), year());
	}
	
	
}
