package org.programmingGame.gameObject;

import java.util.List;

import org.programmingGame.utils.Coordinate;
import org.programmingGame.Constants;
import org.programmingGame.Constants.Sprites;
import org.programmingGame.Game;
import org.programmingGame.Keyboard.GameInput;
import org.programmingGame.utils.Vector2d;

public class Player extends GameObject {
	public Player(double x, double y) {

		super(Sprites.player, x, y);
	}

	public GameObject update(Game game) {
		Coordinate newCoords = inputsToMovement(game.keyboard.getInputs()).moveCoordinate(this.coord);
		Player newPlayer = new Player(newCoords.x, newCoords.y);

		List<GameObject> overlapping = game.getCurrentState().getOverlapping(newPlayer);

		/*
		 * 
		 * for when I implement enemies later
		 * 
		 * List<GameObject> overlappingEntities = overlapping.stream().filter(a -> a
		 * instanceof Entity).toList();
		 * 
		 * if (!overlappingEntities.isEmpty()) {
		 * 
		 * }
		 */

		if (!overlapping.isEmpty())
			return this;
		else
			return newPlayer;
	}

	private Vector2d inputsToMovement(List<GameInput> gameInputs) {
		Vector2d fold = new Vector2d(0, 0);

		gameInputs.stream().distinct().map(Player::inputToVector)
				.forEach(a -> fold.add(
						a.dot(new Vector2d(Constants.moveBy, Constants.moveBy)) // scales vector by moveBy
				));

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
