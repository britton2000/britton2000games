package georgeBritton.topDownGame.core;

import static playn.core.PlayN.graphics;

public class canvasSizeChanger {

	boolean canvasSetting;

	public void canvasSizeSetting(boolean canvasSetting) {
		if (canvasSetting = true) {
			graphics().setSize(800, 600);
		} else {
			graphics().setSize(1000, 800);
		}
	}

}
