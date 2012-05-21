package georgeBritton.dinostory.core;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;

public class GUI {
	public int numGun = 0;
	int MAX_numGun = 2;
	ImageLayer guiLayer, nameLayer;
	Image[] gunGui = new Image[MAX_numGun];
	Image name;
	GroupLayer guiGroup;

	public static int buttonNum = 2;

	public GUI(final GroupLayer parentLayer) {

		guiGroup = graphics().createGroupLayer();

		gunGui[0] = assets().getImage("images/Pistol.Png");
		gunGui[1] = assets().getImage("images/image2.jpeg");
		// gunGui[2] = assets().getImage("images/NyanCat/nyanCat3.jpeg");
		// gunGui[3] = assets().getImage("images/NyanCat/nyanCat4.jpeg");
		// gunGui[4] = assets().getImage("images/NyanCat/nyanCat5.jpeg");
		// gunGui[5] = assets().getImage("images/NyanCat/nyanCat6.jpeg");

		// Image gungui = assets().getImage("images/GUI.png");
		guiLayer = graphics().createImageLayer(gunGui[0]);
		graphics().rootLayer().add(guiLayer);
		guiLayer.setScale(DinoMain.imageSize, DinoMain.imageSize);
		guiLayer.setTranslation(0, 0);

		// Image name = assets().getImage("images/name.png");
		// nameLayer = graphics().createImageLayer(name);
		// graphics().rootLayer().add(nameLayer);
		// nameLayer.setScale(DinoMain.imageSize, DinoMain.imageSize);
		// nameLayer.setTranslation(0, 0);
	}

	public void render(float alpha) {
		guiLayer.setImage(gunGui[numGun]);
		paint(alpha);
	}

	public void update(float delta) {

		// if (OrbiterMain.level == 1) {
		// guiGroup.setVisible(visible);
		// }
	}

	public void paint(float alpha) {
		guiLayer.setTranslation(0, 0);
		// nameLayer.setTranslation(0, 0);
	}
}
