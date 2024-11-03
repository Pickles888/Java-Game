package org.programmingGame;

import java.awt.event.KeyEvent;

import org.programmingGame.gameObject.Sprite;
import org.programmingGame.gameObject.Sprite.Level;

public class Constants {
	public static final class Sprites {
		public static final String unknownPath = ""; // UPDATE PATHS
		public static final Sprite player = Sprite.makeSprite("", Level.MIDGROUND);
	}

	public static final class Input {
		public static final int up = KeyEvent.VK_UP;
		public static final int down = KeyEvent.VK_DOWN;
		public static final int left = KeyEvent.VK_LEFT;
		public static final int right = KeyEvent.VK_RIGHT;
	}
}
