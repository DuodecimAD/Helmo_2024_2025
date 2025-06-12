package zanzibar.domains;

public interface GameFactory {

	void newGame(int playersCount);

	ZanzibarGame getLastGame();

}
