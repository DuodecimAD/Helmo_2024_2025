package zanzibar;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.*;

public class FakeObject {

	private Set<String> methodCalls = new HashSet<>();

	protected void addCall(String methodCall) {
		methodCalls.add(methodCall);
	}

	public void received(String methodCall) {
		if(!methodCalls.contains(methodCall)) {
			final String msg = String.format("Expected call [%s] to be received.", methodCall);
			fail(msg);
		}
	}
	
	public void didNotReceive(String methodCall) {
		if(methodCalls.contains(methodCall)) {
			final String msg = String.format("Expected call [%s] not to be received.", methodCall);
			fail(msg);
		}
	}

}