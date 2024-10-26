package org.programmingGame.gameObject;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.programmingGame.error.handleable.handleables.SpriteLoadError;

public class Sprite {
	public enum Level {
		FOREGROUND,
		MIDGROUND,
		BACKGROUND,
	}

	public final String name;
	public final Level level;

	public BufferedImage sprite;

	public Sprite(String name, String spritePath, Level level) {
		this.name = name;
		this.level = level;

		try {
			sprite = ImageIO.read(getClass().getResource(spritePath));
		} catch (IOException e) {
			var error = new SpriteLoadError(this, e);

			System.out.println(error.show());
			System.out.println(error.handle());
		}
	}
}
