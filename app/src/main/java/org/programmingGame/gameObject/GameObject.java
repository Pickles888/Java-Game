package org.programmingGame.gameObject;

import java.util.Optional;

import org.programmingGame.Coordinate;
import org.programmingGame.Sprite;

public class GameObject {
	private final Optional<Sprite> sprite;
	private final Coordinate coords;

	public GameObject(Sprite sprite, int x, int y) {
		this.sprite = Optional.of(sprite);
		this.coords = new Coordinate(x, y);
	}
}
