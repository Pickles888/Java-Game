package org.programmingGame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import org.programmingGame.error.GameError;
import org.programmingGame.error.errors.InterruptedError;
import org.programmingGame.error.panic.GamePanic;

public class Game extends Canvas implements Runnable, KeyListener {
	private static final int WIDTH = 640;
	private static final int HEIGHT = 360;

	public final List<GameError> gameErrors = new ArrayList<>();
	public final GameState startingState;

	public final Keyboard keyboard;

	public Game(GameState startingState) {
		JFrame frame = new JFrame("2D Game");
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		keyboard = new Keyboard();

		this.startingState = startingState;
	}

	public GameState gameLoop(List<GameState> game) {
		GameState currentGame = game.getLast(); // gets the currently displayed game
		GameState gameUpdated = currentGame.update(); // updates the current game to a new one
		boolean panicked = !gameUpdated.errors.stream().filter(a -> a instanceof GamePanic).isEmpty(); // checks if there are any panics

		gameErrors.addAll(gameUpdated.errors);

		if (currentGame.isRunning && !panicked) {
			game.add(gameUpdated.getUpdated());
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				gameErrors.add(new InterruptedError(e));
			d}

			repaint();
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

		boolean restarting = false;

		GameState gameResult = gameLoop(Arrays.asList(this.startingState));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// draw sprites and stuff :/
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyboard.setKeycode(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyboard.setKeycode(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
