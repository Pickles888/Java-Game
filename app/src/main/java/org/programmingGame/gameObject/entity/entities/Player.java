package org.programmingGame.gameObject.entity.entities;

import java.util.Optional;

import org.programmingGame.Constants;
import org.programmingGame.GameState;
import org.programmingGame.Keyboard.GameInput;
import org.programmingGame.gameObject.GameObject;
import org.programmingGame.gameObject.Sprite;
import org.programmingGame.gameObject.Sprite.Level;
import org.programmingGame.gameObject.entity.Entity;
import org.programmingGame.utils.Vector2d;

public class Player extends Entity {
	public Player(double x, double y) {
		super(new Sprite("player", Constants.Sprites.playerPath, Level.MIDGROUND), x, y);
	}

	public GameObject update(GameState game) {
	}

	public Optional<Vector2d> getNextMovement(GameState game) {
	}
}
