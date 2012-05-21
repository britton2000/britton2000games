package georgeBritton.dinostory.core;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;

public class Menu {
	ImageLayer startLayer, helpLayer, nameLayer, logoLayer;
	Image start, logo, startSelected, help, helpSelected, name, button3;
	GroupLayer menu;
	boolean visible = false;

	public static int buttonNum = 2;

	public Menu(int canvaswidth, int canvasheight, final GroupLayer parentLayer) {

		menu = graphics().createGroupLayer();

		start = assets().getImage("images/Start.png");
		startSelected = assets().getImage("images/StartSelected.png");
		startLayer = graphics().createImageLayer(start);
		startLayer.setScale(DinoMain.imageSize, DinoMain.imageSize);
		startLayer.setTranslation((canvaswidth / 2)
				- (start.width() * (DinoMain.imageSize / 2)),
				(canvasheight / 2) - (start.height() * 2));

		help = assets().getImage("images/Help.png");
		helpSelected = assets().getImage("images/HelpSelected.png");
		helpLayer = graphics().createImageLayer(help);
		helpLayer.setScale(DinoMain.imageSize, DinoMain.imageSize);
		helpLayer.setTranslation((canvaswidth / 2)
				- (help.width() * (DinoMain.imageSize / 2)),
				(canvasheight * 2 / 3) - help.height()
						* (DinoMain.imageSize / 2));

		name = assets().getImage("images/orbiterLogo.png");
		nameLayer = graphics().createImageLayer(name);
		nameLayer.setScale(DinoMain.imageSize, DinoMain.imageSize);
		nameLayer.setTranslation((canvaswidth / 2)
				- (name.width() * (DinoMain.imageSize / 2)),
				(canvasheight * 1 / 3) - name.height()
						* (DinoMain.imageSize / 2));

		// logo = assets().getImage("images/SkyVaultLogo.png");
		// logoLayer = graphics().createImageLayer(logo);
		// logoLayer.setScale(OrbiterMain.imageSize, OrbiterMain.imageSize);
		// logoLayer.setTranslation((canvaswidth / 2)
		// - (logo.width() * (OrbiterMain.imageSize / 2)),
		// (canvasheight * 1 / 6) - logo.height()
		// * (OrbiterMain.imageSize / 2));

		menu.add(helpLayer);
		menu.add(startLayer);
		menu.add(nameLayer);
		// menu.add(logoLayer);
		graphics().rootLayer().add(menu);
	}

	public void render(float alpha) {
	}

	public void update(float delta) {

		if (DinoMain.level == 1) {
			menu.setVisible(visible);
		}
	}

	public void paint(float alpha) {
	}
}
