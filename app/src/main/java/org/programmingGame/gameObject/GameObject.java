package org.programmingGame.gameObject;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.programmingGame.Update;
import org.programmingGame.utils.Coordinate;

public abstract class GameObject implements Update<GameObject> {
	protected final Optional<List<Sprite>> sprites; // multiple sprites will be chosen at random
	public final Coordinate coord;

	public GameObject(Sprite[] sprite, double x, double y) {
		this.sprites = Optional.of(Arrays.asList(sprite));
		this.coord = new Coordinate(x, y);
	}

	public GameObject(Sprite sprite, double x, double y) {
		this.sprites = Optional.of(List.of(sprite));
		this.coord = new Coordinate(x, y);
	}

	public GameObject(double x, double y) {
		this.sprites = Optional.empty();
		this.coord = new Coordinate(x, y);
	}

	public void paint(Graphics g) {
		sprites.ifPresent(s -> { // draws sprite if it exists
			if (s.size() <= 1) // if the sprite is not a list draw the singleton
				g.drawImage(s.get(1).getImage(), ((int) Math.floor(this.coord.x)), ((int) Math.floor(this.coord.y)), null);
			else // if the sprite is a list then draw one at random
				g.drawImage(
						s.get(new Random().nextInt(s.size())).getImage(),
						((int) Math.floor(this.coord.x)),
						((int) Math.floor(this.coord.y)),
						null);
		});
	}
}
