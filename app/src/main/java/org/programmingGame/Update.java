package org.programmingGame;

import java.util.ArrayList;
import java.util.List;

import org.programmingGame.errors.GameError;
import org.programmingGame.errors.panics.GamePanic;

public class Update {
	public final List<GamePanic> panics = new ArrayList<>();
	public final List<GameError> errors = new ArrayList<>();
	public final GameState gameUpdated; // updated game
	public final GameState gameOriginal; // game to be updated

	public Update(GameState game) {
		this.gameOriginal = game;

		// make a new updated game

		this.gameUpdated = null;
	}

	public GameState getUpdated() {
		return gameUpdated;
	}
}
