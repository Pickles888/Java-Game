package org.programmingGame.gameObject.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.programmingGame.Sprite;
import org.programmingGame.gameObject.GameObject;
import org.programmingGame.utils.Coordinate;
import org.programmingGame.utils.Vector2d;

public class Entity extends GameObject {
	private final List<Vector2d> movementHistory = new ArrayList<>();
	private Optional<Vector2d> nextMovement = Optional.empty();

	public Entity(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	public Coordinate move(Vector2d vec) {
		nextMovement = Optional.of(vec);

		return vec.moveCoordinate(coord);
	}

	public Optional<Vector2d> getNextMovement() {
		return nextMovement;
	}
}
