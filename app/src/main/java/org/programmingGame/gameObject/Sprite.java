package org.programmingGame.gameObject;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;

import javax.imageio.ImageIO;

import org.programmingGame.error.errors.SpriteLoadError;
import org.programmingGame.Constants.Sprites;
import org.programmingGame.error.Result;

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

	private static Result<BufferedImage> makeImage(URL url) {
		Result<BufferedImage> result;

		try {
			result = new Result<>(ImageIO.read(url));
		} catch (IOException e) {
			result = new Result<>(new SpriteLoadError(url.toString()));
		}

		return result;
	}

	public static Result<Sprite> make(String spritePath, Level level) {
		return makeImage(spritePath).map(a -> new Sprite(spritePath, a, level)); // gets image
	}

	public static Result<Sprite> make(URL url, Level level) {
		return makeImage(url).map(a -> new Sprite(url.toString(), a, level)); // gets image
	}

	public BufferedImage getImage() {
		return image;
	}

	public static Sprite unknown(Level level) {
		return Sprite.make(Sprites.unknownPath, level).unwrap(a -> {
			System.err.println("Failed to load unknown sprite (bruh)");
			System.exit(1);
			return null; // unreachable code
		});
	}
}
