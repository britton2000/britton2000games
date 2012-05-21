package georgeBritton.dinostory.core;

import static playn.core.PlayN.graphics;
import static playn.core.PlayN.keyboard;
import georgeBritton.dinostory.elements.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import playn.core.Game;
import playn.core.ImageLayer;
import playn.core.Keyboard;

public class DinoMain implements Game, Keyboard.Listener {
	ImageLayer bglayer;
	ImageLayer bglayer2;

	float frameSwitch;
	static boolean right, left, up, down, g, a, s, w, d;
	boolean space, f, startpos, fireBullet, launchAsteroid, fire, smokeon;
	public final static int canvasWidth = 1280, canvasHeight = 720;
	private Dino dino;
	private Background background;
	private GUI gui;
	// private Menu buttons;
	private final ArrayList<Element> elements = new ArrayList<Element>();
	public static Stack<Element> elementSpawnQueue = new Stack<Element>();
	boolean b;
	int launchRate, smokeRate, gemRate, enemyRate, toggleRate;
	public static int imageSize = 5;
	static int level = 1;

	@Override
	public void init() {
		level = 1;
		keyboard().setListener(this);
		graphics().setSize(canvasWidth, canvasHeight);
		background = new Background(canvasWidth, canvasHeight, graphics()
				.rootLayer());
		if (level == 1) {
			dino = new Dino(canvasWidth, canvasHeight, graphics().rootLayer());

		}
		// if (level == 0) {
		// buttons = new Menu(canvasWidth, canvasHeight, graphics()
		// .rootLayer());
		// }

		gui = new GUI(graphics().rootLayer());
	}

	@Override
	public void update(float delta) {
		if (level == 1) {
			dino.update(delta);
			if (up == true || down == true || left == true || right == true) {
				fireBullet(true);
			}
			// launchRate += 1;
			// if (launchRate > 150) {
			// launchAsteroid(true);
			// launchRate = 0;
			// }
			// gemRate += 1;
			// if (gemRate > 250) {
			// launchGem(true);
			// gemRate = 0;
			// }
			// smokeRate = 0;
			// if (smokeon == true) {
			// if (smokeRate == 0) {
			// smoke(true);
			// smokeRate = 0;
			// }
			// }
			//
			// enemyRate += 1;
			// if (enemyRate > 500) {
			// launchEnemy(true);
			// enemyRate = 0;
			// }
			toggleRate += 1;
			if (f && toggleRate > 5) {
				toggleRate = 0;
				if (smokeon == false) {
					smokeon = true;
				} else if (smokeon == true) {
					smokeon = false;
				}
			}
			if (g && toggleRate > 5) {
				toggleRate = 0;
				dino.gunType += 1;
				if (dino.gunType > 2) {
					dino.gunType = 1;
				}
			}
			gui.numGun = -1 + dino.gunType;
			processElements(delta);
			background.update(delta);
		}
	}

	@Override
	public void paint(float alpha) {
		if (1 == level) {

			dino.render(alpha);
			paintElements(alpha);
		}
		background.render(alpha);
		gui.render(alpha);
	}

	private void processElements(float delta) {
		if (elements != null) {
			for (Iterator<Element> it = elements.iterator(); it.hasNext();) {
				Element e = it.next();
				e.update(delta);
				if (e.getY2() < 0 || e.getY() > canvasHeight) {
					e.clear();
					it.remove();
				} else {
					if (checkCollisions(e)) {
						boolean bb = true;
						// fire explosion
					}
				}

			}
		}

		while (!DinoMain.elementSpawnQueue.isEmpty()) {
			elements.add(DinoMain.elementSpawnQueue.pop());
		}
	}

	private boolean checkCollisions(Element element) {
		boolean collide = false;
		if (elements != null) {
			for (Element e : elements) {
				collide = element.hasCollision(e);
			}
		}
		if (dino != null) {
			// collide = element.hasCollision(ship);
		}

		return collide;
	}

	@Override
	public int updateRate() {
		return 25;
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
		case UP:
			up = true;
			break;
		case DOWN:
			down = true;
			break;
		case SPACE:
			space = true;
			break;
		case F:
			f = true;
			break;
		case G:
			g = true;
			break;
		case A:
			a = true;
			break;
		case S:
			s = true;
			break;
		case W:
			w = true;
			break;
		case D:
			d = true;
			break;
		}

	}

	@Override
	public void onKeyTyped(Keyboard.TypedEvent event) {
		// ...
	}

	@Override
	public void onKeyUp(Keyboard.Event event) {

		switch (event.key()) {
		case LEFT:
			left = false;
			break;
		case RIGHT:
			right = false;
			break;
		case UP:
			up = false;
			break;
		case DOWN:
			down = false;
			break;
		case SPACE:
			space = false;
			break;
		case F:
			f = false;
			break;
		case G:
			g = false;
			break;
		case A:
			a = false;
			break;
		case S:
			s = false;
			break;
		case W:
			w = false;
			break;
		case D:
			d = false;
			break;
		}
	}

	private void fireBullet(boolean r) {
		addElement(dino.fireGun());
	}

	public void addElement(Element e) {
		if (e != null) {
			elements.add(e);
		}
	}

	private void paintElements(float alpha) {
		if (elements != null) {
			for (Element a : elements) {
				a.paint(alpha);
			}
		}
	}

	// private void launchAsteroid(boolean r) {
	// Asteroid a = new Asteroid(canvasWidth, canvasHeight, graphics()
	// .rootLayer());
	//
	// a.setPosition((int) Math.round((Math.random() * canvasWidth)),
	// (int) (0 - a.layer.scaledHeight()));
	// elements.add(a);
	// }
	//
	// private void launchGem(boolean r) {
	// Gem g = new Gem(canvasWidth, canvasHeight, graphics().rootLayer());
	//
	// g.setPosition((int) Math.round((Math.random() * canvasWidth)),
	// (int) (0 - g.layer.scaledHeight()));
	// elements.add(g);
	// }
	//
	// private void smoke(boolean r) {
	// ShipSmoke s = new ShipSmoke(ship, graphics().rootLayer());
	// elements.add(s);
	// }
	//
	// private void launchEnemy(boolean r) {
	// EnemyShip e = null;
	// Random aar = new Random();
	// if (aar.nextBoolean()) {
	// e = new EnemyBeastShip(graphics().rootLayer());
	// } else {
	// e = new EnemyShip(graphics().rootLayer());
	// }
	//
	// e.setPosition(
	// (int) Math.round((Math.random() * OrbiterMain.canvasWidth)),
	// (int) (0 - e.layer.scaledHeight()));
	// elements.add(e);
	// }
}
