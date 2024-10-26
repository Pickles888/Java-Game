package org.programmingGame.error.handleable.handleables;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.programmingGame.error.handleable.HandleableError;
import org.programmingGame.gameObject.Sprite;
import org.programmingGame.Constants;

public class SpriteLoadError extends HandleableError {
	public final Sprite sprite; // sprite that produced the error
	public final IOException javaError; // error produced by java

	public SpriteLoadError(Sprite sprite, IOException javaError) {
		this.sprite = sprite;
		this.javaError = javaError;
	}

	public String handle() {
		BufferedImage unknownSprite = null;

		try {
			unknownSprite = ImageIO.read(getClass().getResource(Constants.unknownTexturePath));
		} catch (IOException e) {
			System.out.println("Failed to load unknown texture :/");
			e.printStackTrace();
		}

		sprite.sprite = unknownSprite; // change to unknown sprite path

		return "Changed sprite: " + sprite.name + " to: " + Constants.unknownTexturePath;
	}

	public String show() {
		return "Sprite: " + sprite.name + " threw an error: " + javaError;
	}
}
