package org.programmingGame.gameObject.entity;

import org.programmingGame.Coordinate;

public class Vector2d {
	public final int x;
	public final int y;

	public Vector2d(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Vector2d fromCoordinates(Coordinate a, Coordinate b) {
		return new Vector2d(b.x - a.x, b.y - a.y);
	}

	public int length() {
		return ((int) Math.floor(Math.sqrt(
				Math.pow(this.x, 2) + Math.pow(this.y, 2))));
	}
}
