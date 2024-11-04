package org.programmingGame;

public class Main {
	public static GameState startingGame() {
		return new GameState();
	}

	public static void main(String[] args) {
		Game game = new Game(startingGame());

		game.run();
	}
}
