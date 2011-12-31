package georgeBritton.topDownGame.core;

import static playn.core.PlayN.assetManager;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.keyboard;
import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Keyboard;

public class topDownGame implements Game, Keyboard.Listener {
	ImageLayer layer;

	float px, py;
	float x, y;
	boolean right;
	boolean left;
	boolean up;
	boolean down;
	boolean healthloss;
	int health;

	// float vx, vy;
	// float ax, ay;

	@Override
	public void init() {
		graphics().createCanvasLayer(800, 600);

		keyboard().setListener(this);

		// create and add background image layer
		Image img = assetManager().getImage("images/person1.png");
		layer = graphics().createImageLayer(img);
		graphics().rootLayer().add(layer);
		x = graphics().width() / 2;
		y = graphics().height() / 2;

	}

	@Override
	public void update(float delta) {
		px = x;
		py = y;

		if (right) {
			x += 10;
		} else if (left) {
			x -= 10;
		}

		if (up) {
			y += 10;
		} else if (down) {
			y -= 10;
		}

	}

	@Override
	public void paint(float alpha) {

		float x = (this.x * alpha) + (px * (1f - alpha));
		float y = (this.y * alpha) + (py * (1f - alpha));

		layer.setTranslation(x - layer.image().width() / 2, y
				- layer.image().height() / 2);
	}

	@Override
	public int updateRate() {
		return 50;
	}

	@Override
	public void onKeyDown(Keyboard.Event event) {
		switch (event.key()) {
		case LEFT:
			left = true;
			break;
		case RIGHT:
			right = true;
			break;
		case DOWN:
			down = true;
			break;
		case UP:
			up = true;
			break;
		}

	}

	@Override
	public void onKeyTyped(Keyboard.TypedEvent event) {
		// nada
	}

	@Override
	public void onKeyUp(Keyboard.Event event) {
		switch (event.key()) {
		case LEFT:
			left = false;
			break;
		case UP:
			up = false;
			break;
		case RIGHT:
			right = false;
			break;
		case DOWN:
			down = false;
			break;
		}
	}
}
// public void health(boolean healthloss) {
// if (true) {
// 1 -= health;
// } else {
// if (health < 10) {
// 1 += health;
// } else {
// 0 += health;
// }
// }
// }

// public void damage(boolean damageTaken) {
// healthloss = true;
// }

