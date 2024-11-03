package org.programmingGame.gameObject;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.FileSystems;

import javax.imageio.ImageIO;

import org.programmingGame.error.errors.SpriteLoadError;
import org.programmingGame.error.result.Result;

public class Sprite {
	public enum Level {
		FOREGROUND,
		MIDGROUND,
		BACKGROUND,
	}

	public final String spritePath;
	public final Level level;

	private BufferedImage image;

	private Sprite(String spritePath, BufferedImage image, Level level) {
		this.spritePath = spritePath;
		this.level = level;
		this.image = image;
	}

	private static Result<BufferedImage> makeImage(String spritePath) {
		Result<BufferedImage> result;

		try {
			result = new Result<>(ImageIO.read(FileSystems.getDefault().getPath(spritePath).toFile()));
		} catch (IOException e) {
			result = new Result<>(new SpriteLoadError(spritePath));
		}

		return result;
	}

	public static Result<Sprite> makeSprite(String spritePath, Level level) {
		return makeImage(spritePath).map(a -> new Sprite(spritePath, a, level)); // gets image and maps the result to sprite
	}

	public BufferedImage getImage() {
		return image;
	}
}
