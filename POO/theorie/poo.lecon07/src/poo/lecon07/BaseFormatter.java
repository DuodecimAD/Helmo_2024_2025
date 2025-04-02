package poo.lecon07;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class BaseFormatter {
	
	private final Set<String> formats;
	
//	public BaseFormatter(String...extensions) {
//		this.extensions = new HashSet<>(Arrays.asList(extensions));
//	}
	
	public BaseFormatter(Collection<String> extensions) {
		this.formats = new HashSet<>(extensions);
	}
	
	public boolean canHandle(String format) {
		return formats.contains(format.toLowerCase());
	}
	
	public abstract String format(String sectionTitle, List<String> sectionParagraph);
}
