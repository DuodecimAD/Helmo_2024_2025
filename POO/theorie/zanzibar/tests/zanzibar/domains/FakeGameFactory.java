package zanzibar.domains;

import zanzibar.FakeObject;

public class FakeGameFactory extends FakeObject implements GameFactory {

	@Override
	public void newGame(int playersCount) {
		addCall("newGame("+playersCount+")");
		
	}

	@Override
	public ZanzibarGame getLastGame() {
		// TODO Auto-generated method stub
		return null;
	}

}
