package org.programmingGame.gameObject;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.programmingGame.utils.Coordinate;

public abstract class GameObject implements Update {
	protected final Optional<List<Sprite>> sprite; // multiple sprites will be chosen at random
	protected final Coordinate coord;

	public GameObject(Sprite[] sprite, double x, double y) {
		this.sprite = Optional.of(Arrays.asList(sprite));
		this.coord = new Coordinate(x, y);
	}

	public GameObject(Sprite sprite, double x, double y) {
		this.sprite = Optional.of(List.of(sprite));
		this.coord = new Coordinate(x, y);
	}

	public GameObject(double x, double y) {
		this.sprite = Optional.empty();
		this.coord = new Coordinate(x, y);
	}
}
