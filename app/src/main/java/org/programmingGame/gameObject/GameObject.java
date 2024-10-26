package org.programmingGame.gameObject;

import java.util.Optional;

import org.programmingGame.utils.Coordinate;

public class GameObject {
	protected final Optional<Sprite> sprite;
	protected final Coordinate coord;

	public GameObject(Sprite sprite, int x, int y) {
		this.sprite = Optional.of(sprite);
		this.coord = new Coordinate(x, y);
	}
}
