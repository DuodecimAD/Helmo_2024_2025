package poo.lecon06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SmartPrinter {
	private List<BaseFormatter> formatters = new ArrayList<>();

		public void register(BaseFormatter formatter) {
			Objects.requireNonNull(formatter);
			formatters.add(formatter);
		}

	    public void printSection(String sectionName, List<String> sectionParagraph, String formatKind) {
	    	boolean found = false;
	    	for(var formatter : this.formatters) {
	    		if(formatter.canHandle(formatKind)) {
	    			System.out.println(formatter.format(sectionName, sectionParagraph));
	    		}
	    	}
	    	
	    	if(found == false) {
	    		throw new IllegalArgumentException("Illegal format");
	    	}

	    }


}
