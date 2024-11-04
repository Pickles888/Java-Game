package org.programmingGame.gameObject;

import java.util.List;

import org.programmingGame.GameState;
import org.programmingGame.Constants.Sprites;
import org.programmingGame.Keyboard.GameInput;
import org.programmingGame.utils.Vector2d;

public class Player extends GameObject {
	public Player(double x, double y) {

		super(Sprites.player, x, y);
	}

	public GameObject update(GameState game) {
		return null;
	}

	public Vector2d inputsToMovement(List<GameInput> gameInputs) {
		Vector2d fold = new Vector2d(0, 0);

		gameInputs.stream().distinct().map(Player::inputToVector).forEach(a -> fold.add(a));

		return fold;
	}

	private static Vector2d inputToVector(GameInput gameInput) {
		switch (gameInput) {
			case MOVEDOWN:
				return new Vector2d(0, -1);
			case MOVELEFT:
				return new Vector2d(-1, 0);
			case MOVERIGHT:
				return new Vector2d(1, 0);
			case MOVEUP:
				return new Vector2d(0, 1);
			default:
				return new Vector2d(0, 0);
		}
	}
}
