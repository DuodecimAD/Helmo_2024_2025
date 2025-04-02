package poo.lecon06;

import java.util.List;

public class HtmlFormatter extends BaseFormatter {
	
	@Override
	public boolean canHandle(String format) {
		return "html".equalsIgnoreCase(format);
	}
	
	@Override
	public String format(String sectionName, List<String> sectionParagraph) {
		var builder = new StringBuilder();
		
		builder.append("<section>\n");
		builder.append(String.format("<h1>%s</h1>\n", sectionName));

		for(String p : sectionParagraph) {
			builder.append(String.format("<p>%s</p>\n", p));
		}

        builder.append("</section>");
         
		return builder.toString();
	}

}
