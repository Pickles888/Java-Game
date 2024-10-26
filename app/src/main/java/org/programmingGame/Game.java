package org.programmingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.programmingGame.errors.GameError;

public class Game {
	public final List<GameError> gameErrors = new ArrayList<>();
	public final GameState startingState;

	public Game(GameState startingState) {
		this.startingState = startingState;
	}

	public GameState gameLoop(List<GameState> game) {
		GameState currentGame = game.getLast(); // gets the currently displayed game
		Update gameUpdate = new Update(currentGame); // updates the current game to a new one
		boolean panicked = !gameUpdate.panics.isEmpty(); // checks if there are any panics

		if (currentGame.isRunning && !panicked) {
			game.add(gameUpdate.getUpdated());
			return gameLoop(game);
		} else if (panicked) {
			System.err.println("Game Panicked!");
			return currentGame;
		} else {
			return currentGame;
		}
	}

	public void run() {
		System.out.println("--- Running Game ---");

		List<GameState> gameStates = new ArrayList<>();

		boolean restarting = false;

		while (restarting) {
			GameState gameResult = gameLoop(Arrays.asList(this.startingState));

			gameStates.add(gameResult);

			// check if you are restarting
		}

		List<GameError> errors = new ArrayList<>();

		gameStates.stream().map(a -> a.errors).toList().forEach(errors::addAll); // concentrate errors

		gameErrors.addAll(errors);
	}
}
