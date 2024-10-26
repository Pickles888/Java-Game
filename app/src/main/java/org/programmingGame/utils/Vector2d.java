package org.programmingGame.utils;

public class Vector2d {
	public final double x;
	public final double y;

	public Vector2d(double x, double y) {
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

	public Coordinate moveCoordinate(Coordinate a) {
		return new Coordinate(this.x + a.x, this.y + a.y);
	}
}
