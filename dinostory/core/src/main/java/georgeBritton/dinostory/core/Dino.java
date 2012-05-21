package georgeBritton.dinostory.core;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.log;
import georgeBritton.dinostory.elements.Bullet;
import georgeBritton.dinostory.elements.Element;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.ResourceCallback;

public class Dino extends Element {

	ImageLayer layer;
	Image upMan, downMan, leftMan, rightMan;
	Image image2;

	float frameSwitch;
	public static int y;
	public static int x;
	public int y2;
	public int x2;
	public int width, height, gunType = 1;
	private final Gun mainGun = new Gun(this);
	private final Gun machineGun = new Gun(this);
	// private final Gun sideGunLeft = new Gun(this);
	// private final Gun sideGunRight = new Gun(this);
	private final boolean fireLeft = false;

	public Dino(int canvasWidth, int canvasHeight, final GroupLayer parentLayer) {
		upMan = assets().getImage("images/people/ManUp1.png");
		downMan = assets().getImage("images/people/ManDown1.png");
		rightMan = assets().getImage("images/people/ManLeft1.png");
		leftMan = assets().getImage("images/people/ManRight1.png");
		layer = graphics().createImageLayer(upMan);

		width = upMan.width();
		height = upMan.height();
		upMan.addCallback(new ResourceCallback<Image>() {
			@Override
			public void done(Image image) {
				parentLayer.add(layer);
			}

			@Override
			public void error(Throwable err) {
				log().error("Error loading image!", err);
			}
		});

		layer.setScale(DinoMain.imageSize, DinoMain.imageSize);
		x = (canvasWidth / 2);
		y = (canvasHeight / 2);
	}

	@Override
	public void render(float alpha) {
		if (frameSwitch > 10f) {
			// if (layer.image() == image) {
			// layer.setImage(image2);
			// } else {
			// layer.setImage(image);
			// }
			frameSwitch = 0;
			if (DinoMain.w) {
				layer.setImage(upMan);
			} else if (DinoMain.s) {
				layer.setImage(downMan);
			} else if (DinoMain.a) {
				layer.setImage(rightMan);
			} else if (DinoMain.d) {
				layer.setImage(leftMan);
			}
			layer.setTranslation(x, y);
		}
		// if (DinoMain.up) {
		// layer.setImage(upMan);
		// } else if (DinoMain.down) {
		// layer.setImage(downMan);
		// } else if (DinoMain.right) {
		// layer.setImage(rightMan);
		// } else if (DinoMain.left) {
		// layer.setImage(leftMan);
		// }

	}

	@Override
	public void update(float delta) {
		x2 = x + (width * DinoMain.imageSize);
		y2 = y + (height * DinoMain.imageSize);
		frameSwitch += delta;
		if (DinoMain.d) {
			if (x2 < DinoMain.canvasWidth) {
				x += 5;
			}
		} else if (DinoMain.a) {
			if (x > 0) {
				x -= 5;
			}
		}
		if (DinoMain.w) {
			if (y > 0) {
				y -= 5;
			}
		} else if (DinoMain.s) {
			if (y2 < DinoMain.canvasHeight) {
				y += 5;
			}
		}
	}

	public Bullet fireGun() {
		Bullet b = null;
		if (gunType == 1) {
			b = fireMainGun();
		}
		if (gunType == 2) {
			b = machineGun();
		}
		// if (gunType == 3 || gunType == 4 || gunType == 5) {
		// b = fireSideGuns();
		// }

		return b;

	}

	int a = 0;

	public Bullet fireMainGun() {
		int by = y;

		// @todo fix bullet width
		int bx = x + width * DinoMain.imageSize / 2
				- (2 * DinoMain.imageSize / 2);
		if (DinoMain.up && DinoMain.left) {
			a = 4;
		} else if (DinoMain.up && DinoMain.right) {
			a = 5;
		} else if (DinoMain.down && DinoMain.left) {
			a = 6;
		} else if (DinoMain.down && DinoMain.right) {
			a = 7;
		} else if (DinoMain.up) {
			a = 0;
		} else if (DinoMain.down) {
			a = 1;
		} else if (DinoMain.right) {
			a = 3;
		} else if (DinoMain.left) {
			a = 2;
		}

		return mainGun.fireBullet(bx, by, a, gunType);
	}

	public Bullet machineGun() {
		int by = y;

		// @todo fix bullet width
		int bx = x + width * DinoMain.imageSize / 2
				- (2 * DinoMain.imageSize / 2);
		if (DinoMain.up && DinoMain.left) {
			a = 4;
		} else if (DinoMain.up && DinoMain.right) {
			a = 5;
		} else if (DinoMain.down && DinoMain.left) {
			a = 6;
		} else if (DinoMain.down && DinoMain.right) {
			a = 7;
		} else if (DinoMain.up) {
			a = 0;
		} else if (DinoMain.down) {
			a = 1;
		} else if (DinoMain.right) {
			a = 3;
		} else if (DinoMain.left) {
			a = 2;
		}

		return mainGun.fireBullet(bx, by, a, gunType);
	}
	// public Bullet fireSideGuns() {
	// int by = y + (height * 2);
	// int bx = x;
	//
	// Bullet b = null;
	// if (!fireLeft) {
	// b = sideGunLeft.fireBullet(bx
	// + (width * DinoMain.imageSize * 2 / 7), by, true, gunType);
	// } else {
	// b = sideGunRight.fireBullet(bx
	// + (width * DinoMain.imageSize * 4 / 7), by, true, gunType);
	// }
	// if (b != null) {
	// fireLeft = !fireLeft;
	// }
	//
	// return b;
	// }
}
