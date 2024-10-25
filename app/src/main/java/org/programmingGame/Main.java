package org.programmingGame;

import java.util.ArrayList;

public class Main {
	public static GameState startingGame() {
		return null;
	}

	public static void main(String[] args) {
		Game game = new Game(startingGame());

		game.run();
	}
}
