package org.programmingGame.error.handleable;

import org.programmingGame.error.GameError;

public abstract class HandleableError extends GameError {
	public abstract String handle();
}
