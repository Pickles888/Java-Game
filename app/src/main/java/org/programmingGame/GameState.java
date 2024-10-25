package org.programmingGame;

import java.util.ArrayList;
import java.util.List;

import org.programmingGame.errors.GameError;

public class GameState {
	public final boolean isRunning;
	public final List<GameError> errors;

	public GameState() {
		isRunning = true;
		errors = new ArrayList<GameError>();
	}
}
