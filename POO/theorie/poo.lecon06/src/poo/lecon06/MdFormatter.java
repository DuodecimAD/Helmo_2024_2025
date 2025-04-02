package poo.lecon06;

import java.util.List;

public class MdFormatter extends BaseFormatter {
	
	@Override
	public boolean canHandle(String format) {
		return "mardown".equalsIgnoreCase(format) || "md".equalsIgnoreCase(format);
	}
	
	@Override
	public String format(String sectionName, List<String> sectionParagraph) {
		var builder = new StringBuilder();
		
		builder.append("<section>\n");
		builder.append(String.format("# %s\n", sectionName));

		for(String p : sectionParagraph) {
			builder.append(String.format("%s\n", p));
		}
         
		return builder.toString();
	}
}
