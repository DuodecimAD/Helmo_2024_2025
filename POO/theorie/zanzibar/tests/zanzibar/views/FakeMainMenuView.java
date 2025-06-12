package zanzibar.views;

import zanzibar.FakeObject;
import zanzibar.supervisors.MainMenuView;

public class FakeMainMenuView extends FakeObject implements MainMenuView {
	@Override
	public void exitConfirmed() {
		addCall("exitConfirmed()");
	}

	@Override
	public void goTo(String viewName) {
		addCall("goTo("+viewName+")");
	}

}
