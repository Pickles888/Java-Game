package org.programmingGame.gameObject.entity;

import java.util.Optional;

import org.programmingGame.gameObject.GameObject;
import org.programmingGame.gameObject.Sprite;
import org.programmingGame.utils.Vector2d;
import org.programmingGame.Game;

public abstract class Entity extends GameObject {
	public Entity(Sprite sprite, double x, double y) {
		super(sprite, x, y);
	}

	public abstract Optional<Vector2d> getNextMovement(Game game);

}
