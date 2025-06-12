package zanzibar.views;

import java.awt.Color;
import java.util.*;
import javax.swing.*;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = -6290074367045611835L;
	
	private final Map<String, SwingView> views = new HashMap<>();
	private SwingView current = null;
	
	public MainWindow(String title, Collection<SwingView> views) {
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480, 640);
		setResizable(false);
		setBackground(Color.white);
		
		Objects.requireNonNull(views,"You must provide a non-empty list of views");
		for(var view : views) {
			Objects.requireNonNull(view,"You must provide defined view");
			this.views.put(view.getClass().getSimpleName(), view);
			view.setRouter(this::goTo);
		}
	}
	
	public void goTo(String viewName) {
		var found = getView(viewName);
		
		if(current != null) {
			current.onLeave(viewName);
			current.setVisible(false);
			found.onEnter(current.getClass().getSimpleName());
		} else {
			found.onEnter("");
		}
		
		this.current = found;		
		this.setContentPane(current);
		current.setVisible(true);
	}
	
	private SwingView getView(String screenName) {
		if(!views.containsKey(screenName)) {
			throw new IllegalArgumentException("screenName["+screenName+"] does not match any registered screen name.");
		}
		return views.get(screenName);
	}
}
