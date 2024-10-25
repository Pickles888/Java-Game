package org.programmingGame;

public class Sprite {
	public enum Level {
		FOREGROUND,
		MIDGROUND,
		BACKGROUND,
	}

	public final String spritePath;
	public final Level level;

	public Sprite(String spritePath, Level level) {
		this.spritePath = spritePath;
		this.level = level;
	}
}
