package poo.lecon07;

import java.util.List;

public class HtmlFormatter extends BaseFormatter {
	
	public HtmlFormatter() {
		super(List.of("html"));
	}
	
	@Override
	public String format(String sectionName, List<String> sectionParagraph) {
		StringBuilder result = new StringBuilder();
		result.append("<section>\n");
		result.append(String.format("<h1>%s</h1>\n", sectionName));
		for(String p : sectionParagraph) {
			result.append(String.format("<p>%s</p>\n", p));
		}
		result.append("</section>\n");
		
		return result.toString();
	}
}
