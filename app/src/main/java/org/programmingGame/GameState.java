package org.programmingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.programmingGame.Keyboard.GameInput;
import org.programmingGame.error.GameError;
import org.programmingGame.gameObject.GameObject;
import org.programmingGame.gameObject.entity.entities.Player;

public class GameState {
	public final boolean isRunning;
	public final List<GameError> errors;

	public final Player player;
	public final List<GameObject> gameObjects;

	private Supplier<List<GameInput>> gameInputs;

	public GameState() {
		isRunning = true;
		errors = new ArrayList<GameError>();
		player = new Player(0, 0);
		gameObjects = new ArrayList<>();
	}

	public GameState(List<Error> errors, List<GameObject> gameObjects, Player player) {
		this.errors = errors;
		this.gameObjects = gameObjects;
		this.player = player;

		isRunning = true;
	}

	public void setInputStream(Supplier<List<GameInput>> inputStream) {
		gameInputs = inputStream;
	}
}
