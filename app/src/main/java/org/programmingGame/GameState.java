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

	public final List<GameInput> gameInputs;

	public GameState() {
		isRunning = true;
		errors = new ArrayList<GameError>();
		player = new Player(0, 0);
		gameObjects = new ArrayList<>();
		gameInputs = new ArrayList<>();
	}

	public GameState(List<GameError> errors, List<GameObject> gameObjects, Player player) {
		this.errors = errors;
		this.gameObjects = gameObjects;
		this.player = player;

		gameInputs = new ArrayList<>();

		isRunning = true;
	}

	public GameState(List<GameError> errors, List<GameObject> gameObjects, List<GameInput> gameInputs, Player player) {
		this.errors = errors;
		this.gameObjects = gameObjects;
		this.player = player;

		this.gameInputs = gameInputs;

		isRunning = true;
	}

	public GameState getUpdated(Game game) {
		return null;
	}
}
