package zanzibar.views;

import java.util.Objects;
import java.util.function.Consumer;

import javax.swing.JPanel;

public abstract class SwingView extends JPanel {
	private static final long serialVersionUID = -6538228632045268260L;
	
	private Consumer<String> router;
	
	public void setRouter(Consumer<String> router) {
		this.router = Objects.requireNonNull(router);
	}

	public void onLeave(String screenTitle) {
		
	}

	public void onEnter(String simpleName) {
		
	}
	
	public final void goTo(String viewName) {
		Objects.requireNonNull(router);
		Objects.requireNonNull(viewName);
		this.router.accept(viewName);
	}

}
