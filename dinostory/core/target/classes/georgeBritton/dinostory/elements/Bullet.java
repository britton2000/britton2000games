package georgeBritton.dinostory.elements;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.log;
import georgeBritton.dinostory.core.DinoMain;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ResourceCallback;

public class Bullet extends Element {

	Image image;

	int bulletDirection;

	private final String imageName = "images/Bullet.png";

	public Bullet(final GroupLayer parentLayer, Element creator, int direction) {
		bulletDirection = direction;
		image = assets().getImage("images/image2.jpeg");
		layer = graphics().createImageLayer(image);
		layer.setScale(DinoMain.imageSize, DinoMain.imageSize);
		height = image.height();
		width = image.width();
		this.creator = creator;
		image.addCallback(new ResourceCallback<Image>() {
			@Override
			public void done(Image image) {
				parentLayer.add(layer);
			}

			@Override
			public void error(Throwable err) {
				log().error("Error loading image!", err);
			}
		});
	}

	@Override
	public void update(float delta) {
		if (bulletDirection == 0) {
			y -= 15;
		} else if (bulletDirection == 1) {
			y += 15;
		} else if (bulletDirection == 2) {
			x -= 15;
		} else if (bulletDirection == 3) {
			x += 15;
		} else if (bulletDirection == 4) {
			x -= 15;
			y -= 15;
		} else if (bulletDirection == 5) {
			x += 15;
			y -= 15;
		} else if (bulletDirection == 6) {
			x -= 15;
			y += 15;
		} else if (bulletDirection == 7) {
			x += 15;
			y += 25;
		}
	}

	@Override
	public String getImage() {
		return imageName;
	}

}