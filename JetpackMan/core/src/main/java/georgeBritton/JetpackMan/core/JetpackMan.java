package georgeBritton.JetpackMan.core;

import static playn.core.PlayN.assetManager;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.keyboard;
import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Keyboard;
import playn.core.Keyboard.Listener;

public class JetpackMan implements Game, Listener {
	float x, y;
	float velocity, gravity, thrust, TG, rate;
	ImageLayer jetpackManLayer;
	boolean up, left, right;

	@Override
	public void init() {
		graphics().createCanvasLayer(800, 300);

		keyboard().setListener(this);

		Image jetpackMan = assetManager().getImage("images/person1.png");
		jetpackManLayer = graphics().createImageLayer(jetpackMan);
		graphics().rootLayer().add(jetpackManLayer);

		x = graphics().width() / 2;
		y = graphics().height() / 2;

		thrust = 0;
		gravity = 5;
		TG = 5;
	}

	@Override
	public void update(float delta) {
		if (up) {
			thrust += 1;
			gravity -= 1;
		} else {
			thrust -= 1;
			gravity += 1;
			if (gravity > TG) {
				gravity = TG;
			}
		}

		if (right) {
			x += 2;
		} else if (left) {
			x -= 1;
		}
		rate = thrust - gravity;
		y -= rate;

	}

	@Override
	public void paint(float alpha) {
		jetpackManLayer.setTranslation(x - jetpackManLayer.image().width() / 2,
				y - jetpackManLayer.image().height() / 2);

	}

	@Override
	public int updateRate() {
		return 25;
	}

	@Override
	public void onKeyDown(Keyboard.Event event) {
		switch (event.key()) {
		case UP:
			up = true;
			break;
		case LEFT:
			left = true;
			break;
		case RIGHT:
			right = true;
			break;
		}
	}

	@Override
	public void onKeyTyped(Keyboard.TypedEvent event) {
	}

	@Override
	public void onKeyUp(Keyboard.Event event) {
		switch (event.key()) {
		case UP:
			up = false;
			break;
		case LEFT:
			left = false;
			break;
		case RIGHT:
			right = false;
			break;
		}
	}
}