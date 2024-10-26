package org.programmingGame.gameObject.stationary;

import org.programmingGame.gameObject.GameObject;
import org.programmingGame.gameObject.Sprite;

public abstract class Stationary extends GameObject {
	public Stationary(Sprite sprite, double x, double y) {
		super(sprite, x, y);
	}
}
