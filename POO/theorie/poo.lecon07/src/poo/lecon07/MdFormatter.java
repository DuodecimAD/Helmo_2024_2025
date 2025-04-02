package poo.lecon07;

import java.util.List;

public class MdFormatter extends BaseFormatter {
	
	public MdFormatter() {
		super(List.of("markdown", "md"));
	}
	
	@Override
	public String format(String sectionName, List<String> sectionParagraph) {
		StringBuilder result = new StringBuilder();
		
		result.append(String.format("# %s\n", sectionName));
		for(String p : sectionParagraph) {
			result.append(String.format("%s\n", p));
		}
		
		return result.toString();
	}
}
