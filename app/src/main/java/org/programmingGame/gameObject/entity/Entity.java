package org.programmingGame.gameObject.entity;

import org.programmingGame.Sprite;
import org.programmingGame.gameObject.GameObject;

public abstract class Entity extends GameObject {

	public Entity(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}
}
