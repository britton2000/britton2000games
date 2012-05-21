package georgeBritton.dinostory.core;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;

public class Background {
	ImageLayer bglayer, bglayer2;
	Image bgimage, bgimage2;

	float bgx, bgy, bgx2, bgy2;

	public static int buttonNum = 2;

	public Background(int canvaswidth, int canvasheight,
			final GroupLayer parentLayer) {
		Image bgimage = assets().getImage("images/bg.png");
		bglayer2 = graphics().createImageLayer(bgimage);
		graphics().rootLayer().add(bglayer2);

		bgx = 0;
		bgy = -DinoMain.canvasHeight;

		Image bgimage2 = assets().getImage("images/bg.png");
		bglayer = graphics().createImageLayer(bgimage2);
		graphics().rootLayer().add(bglayer);

		bgx2 = 0;
		bgy2 = 0;
	}

	public void render(float alpha) {
		paint(alpha);
	}

	public void update(float delta) {

	}

	public void paint(float alpha) {
		bglayer.setTranslation(bgx, bgy);
		bglayer2.setTranslation(bgx2, bgy2);
	}
}
