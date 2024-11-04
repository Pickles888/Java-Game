package org.programmingGame.gameObject.stationary;

import org.programmingGame.Game;
import org.programmingGame.gameObject.GameObject;
import org.programmingGame.gameObject.Sprite;

public abstract class Stationary extends GameObject {
	public Stationary(Sprite sprite, double x, double y) {
		super(sprite, x, y);
	}

	public Stationary(Sprite[] sprite, double x, double y) {
		super(sprite, x, y);
	}

	public GameObject update(Game ignored) {
		return this;
	}
}
