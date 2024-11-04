package org.programmingGame.gameObject;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.programmingGame.Update;
import org.programmingGame.gameObject.Sprite.Level;
import org.programmingGame.utils.Coordinate;

public abstract class GameObject implements Update<GameObject> {
	protected final List<Sprite> sprites; // multiple sprites will be chosen at random
	public final Coordinate coord;

	public GameObject(Sprite[] sprite, double x, double y) {
		this.sprites = Arrays.asList(sprite);
		this.coord = new Coordinate(x, y);
	}

	public GameObject(Sprite sprite, double x, double y) {
		this.sprites = List.of(sprite);
		this.coord = new Coordinate(x, y);
	}

	public Level getLevel() {
		if (!sprites.isEmpty()) {
			return sprites.get(0).level; // fricked
		} else
			return Level.BACKGROUND; // just puts it in the background because who cares
	}

	public void paint(Graphics g) {
		if (!sprites.isEmpty()) {// draws sprite if it exists
			if (sprites.size() == 1) // if the sprite is not a list draw the singleton
				g.drawImage(sprites.get(1).getImage(), ((int) Math.floor(this.coord.x)),
						((int) Math.floor(this.coord.y)),
						null);
			else // if the sprite is a list then draw one at random
				g.drawImage(
						sprites.get(new Random().nextInt(sprites.size())).getImage(),
						((int) Math.floor(this.coord.x)),
						((int) Math.floor(this.coord.y)),
						null);
		}
	}
}
