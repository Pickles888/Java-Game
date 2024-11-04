package org.programmingGame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JFrame;

import org.programmingGame.error.GameError;
import org.programmingGame.error.panic.GamePanic;
import org.programmingGame.gameObject.GameObject;
import org.programmingGame.gameObject.Sprite.Level;
import org.programmingGame.utils.Utils;

public class Game extends Canvas implements Runnable, KeyListener {
	private static final int WIDTH = 640;
	private static final int HEIGHT = 360;

	public final List<GameError> gameErrors = new ArrayList<>();

	private GameState currentState;

	public final Keyboard keyboard = new Keyboard();

	public Game(GameState startingState) {
		JFrame frame = new JFrame("2D Game");
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		this.currentState = startingState;
		repaint();
	}

	public GameState gameLoop(List<GameState> game) {
		GameState currentState = game.getLast(); // gets the currently displayed game
		GameState gameUpdated = currentState.getUpdated(this); // updates the current game to a new one
		boolean panicked = gameUpdated.errors
				.stream()
				.anyMatch(a -> a instanceof GamePanic);

		gameErrors.addAll(gameUpdated.errors);

		if (currentState.isRunning && !panicked) {
			game.add(gameUpdated);

			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				System.err.println("Interrupted!!");
				e.printStackTrace(); // not adding it to errors, not multithreaded so should never happen i think
			}

			this.currentState = currentState;
			repaint();

			return gameLoop(Utils.truncateList(game, 20));
		} else if (panicked) {
			System.err.println("Game Panicked!");
			return currentState;
		} else {
			return currentState;
		}
	}

	public void run() {
		System.out.println("--- Running Game ---");

		GameState gameResult = gameLoop(Arrays.asList(this.currentState));

		gameResult.errors.stream().forEach(a -> System.out.println(a.show()));
	}

	public GameState getCurrentState() {
		return currentState;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Stream<GameObject> objStream = currentState.gameObjects.stream();

		objStream.filter(a -> a.getLevel() == Level.BACKGROUND).forEach(a -> a.paint(g));
		objStream.filter(a -> a.getLevel() == Level.MIDGROUND).forEach(a -> a.paint(g));
		objStream.filter(a -> a.getLevel() == Level.FOREGROUND).forEach(a -> a.paint(g));
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
