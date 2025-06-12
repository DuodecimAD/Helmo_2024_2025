package lecon09.requests;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class RequestList {

	//private static final int FIRST = 0;
	Deque<Form> requests = new ArrayDeque<>();
	
	public String getNextName() {
		if (requests.size() > 0)
			return requests.element().getName(); // getFirst() existe en Java 21
		else
			return Form.NO_NAME;
	}
	
	public String getNextDescription() {
		if (requests.size() > 0)
			return requests.element().getDescription(); 
		else
			return Form.NO_DESCRIPTION;
	}
	
	public void markRequestAsDone() {
		if (requests.size() > 0)
			requests.remove(); // removeFirst() existe en Java 21
	}
	
	public void cancelLast() {
		requests.removeLast();
	}
	
	public void makeNewRequest(String name, String description) {
		requests.add(new Form(Objects.requireNonNull(name), Objects.requireNonNull(description)));
	}
}
