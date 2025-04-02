package poo.lecon07;

import java.util.*;

public class SmartPrinter {
	private final List<BaseFormatter> formats = new ArrayList<>();
	
	public void register(BaseFormatter format) {
		Objects.requireNonNull(format);
		formats.add(format);
	}
	
	public void printSection(String sectionName, List<String> sectionParagraph, String formatKind) {
		boolean formatFound = false;
		for(var fmt : formats) {
			if(fmt.canHandle(formatKind)) {
				System.out.println(fmt.format(sectionName, sectionParagraph));
				formatFound = true;
				break;
			}
		}
		
		if(!formatFound) {
			throw new IllegalArgumentException("Illegal format");
		}
	}
}
