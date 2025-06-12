package zanzibar.domains;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void update_its_score_when_roll_is_called() {
		var player = new Player();
		var dices = new FakeDices(List.of(
				List.of(1, 4, 2),
				List.of(2, 6, 2)
		));
		
		player.roll(dices); // premier lancer
		player.roll(dices); // second lancer
		
		assertEquals(170, player.getScore());
	}

}
