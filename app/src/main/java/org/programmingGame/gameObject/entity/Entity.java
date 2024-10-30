package org.programmingGame.gameObject.entity;

import java.util.Optional;

import org.programmingGame.gameObject.GameObject;
import org.programmingGame.gameObject.Sprite;
import org.programmingGame.utils.Vector2d;
import org.programmingGame.GameState;

public abstract class Entity extends GameObject {
	public final Optional<Vector2d> nextMovement;

	public Entity(Sprite sprite, double x, double y) {
		super(sprite, x, y);
		nextMovement = Optional.empty();
	}

	public Entity(Sprite sprite, double x, double y, Optional<Vector2d> nextMovement) {
		super(sprite, x, y);
		this.nextMovement = nextMovement;
	}

	public abstract Optional<Vector2d> getNextMovement(GameState game);
}
