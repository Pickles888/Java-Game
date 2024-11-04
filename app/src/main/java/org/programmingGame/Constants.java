package org.programmingGame;

import java.awt.event.KeyEvent;

import org.programmingGame.gameObject.Sprite;
import org.programmingGame.gameObject.Sprite.Level;

public class Constants {
	public static final double moveBy = 5; // pixels to move by each tick

	public static final class Sprites {
		private static Sprite sprite(String spritePath, Level level) {
			return Sprite.make(Constants.class.getResource("../../../../../../assets/" + spritePath), level)
					.unwrap(ignore -> Sprite.unknown(level));
		}

		public static final String unknownPath = "";

		public static final Sprite player = sprite("", Level.MIDGROUND);

		public static final Sprite[] grassbg = new Sprite[] {
				sprite("", Level.BACKGROUND),
				sprite("", Level.BACKGROUND),
				sprite("", Level.BACKGROUND),
				sprite("", Level.BACKGROUND)
		};

		public static final Sprite[] grassmg = new Sprite[] {
				sprite("", Level.MIDGROUND),
				sprite("", Level.MIDGROUND),
				sprite("", Level.MIDGROUND),
				sprite("", Level.MIDGROUND)
		};
	}

	public static final class Input {
		public static final int up = KeyEvent.VK_UP;
		public static final int down = KeyEvent.VK_DOWN;
		public static final int left = KeyEvent.VK_LEFT;
		public static final int right = KeyEvent.VK_RIGHT;
	}
}
