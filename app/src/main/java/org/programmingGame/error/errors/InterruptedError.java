package org.programmingGame.error.errors;

import org.programmingGame.error.GameError;

public class InterruptedError extends GameError {
	private final InterruptedException javaError;

	public InterruptedError(InterruptedException javaError) {
		this.javaError = javaError;
	}

	public String show() {
		return "Game was interrupted!\nJava Error: " + javaError;
	}
}
