package poo.lecon06;

import java.util.List;

/**
 * classe mère dont heriteront toutes les classes filles
 * 
 * cette classe ne devrait jamais être instanciée
 */
public class BaseFormatter {
	
	public boolean canHandle(String format) {
		return false;
	}
	
	public String format(String sectionName, List<String> sectionParagraph) {
		return "";
	}
}
