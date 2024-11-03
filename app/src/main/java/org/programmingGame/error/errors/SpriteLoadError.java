package org.programmingGame.error.errors;

import org.programmingGame.error.GameError;

public class SpriteLoadError extends GameError {
	private final String path;

	public SpriteLoadError(String path) {
		this.path = path;
	}

	public String show() {
		return "Failed to load `" + path + "``";
	}
}
