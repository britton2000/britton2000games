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
	ImageLayer worldLayer;
	ImageLayer merchantLayer;

	float px, py;
	float x, y;
	float stamina, pSpeed;
	float staminaPotion;
	boolean right;
	boolean left;
	boolean up;
	boolean down;
	boolean sprint;
	public boolean e;
	public boolean one, two, three;

	@Override
	public void init() {
		graphics().createCanvasLayer(800, 600);

		keyboard().setListener(this);

		// create and add background image layer
		Image img = assetManager().getImage("images/person1.png");
		layer = graphics().createImageLayer(img);
		graphics().rootLayer().add(layer);
		Image world = assetManager().getImage("world/world.png");
		worldLayer = graphics().createImageLayer(world);
		graphics().rootLayer().add(worldLayer);
		Image merchant = assetManager().getImage("images/person1.png");
		merchantLayer = graphics().createImageLayer(merchant);
		graphics().rootLayer().add(merchantLayer);

		x = graphics().width() / 2;
		y = graphics().height() / 2;
		stamina = 100;
		sprint = false;
		// merchantX = graphics().width() / 2;
		// merchantY = graphics().height() / 2;

	}

	@Override
	public void update(float delta) {
		px = x;
		py = y;

		if (stamina >= 0) {
			pSpeed = 5;
		}

		if (stamina > 90 && sprint) {
			pSpeed = 20;
		}
		if (stamina > 60 && stamina < 90 && sprint) {
			pSpeed = 18;
		}
		if (stamina > 60 && stamina < 90 && sprint) {
			pSpeed = 16;
		}
		if (stamina > 30 && stamina < 60 && sprint) {
			pSpeed = 14;
		}
		if (stamina > 0 && stamina < 30 && sprint) {
			pSpeed = 12;
		}
		if (sprint) {
			stamina -= 1;
		} else if (sprint = false) {
			stamina += 1;
		}
		if (stamina <= 0) {
			pSpeed = 5;
		}

		if (right) {
			x += pSpeed;
		} else if (left) {
			x -= pSpeed;
		}

		if (up) {
			y -= pSpeed;
		} else if (down) {
			y += pSpeed;
		}
	}

	@Override
	public void paint(float alpha) {

		float x = (this.x * alpha) + (px * (1f - alpha));
		float y = (this.y * alpha) + (py * (1f - alpha));

		worldLayer.setTranslation(x - worldLayer.image().width() / 2, y
				- worldLayer.image().height() / 2);
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
		case F:
			stamina = 100;
			break;
		case D:
			sprint = true;
			break;
		case E:
			e = true;
			break;
		case K1:
			one = true;
			break;
		case K2:
			two = true;
			break;
		case K3:
			three = true;
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
		case D:
			sprint = false;
			break;
		case E:
			e = false;
			break;
		case K1:
			one = false;
			break;
		case K2:
			two = false;
			break;
		case K3:
			three = false;
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

