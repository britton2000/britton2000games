package georgeBritton.JetpackMan.html;

import georgeBritton.JetpackMan.core.JetpackMan;
import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

public class JetpackManHtml extends HtmlGame {

	@Override
	public void start() {
		HtmlPlatform platform = HtmlPlatform.register();
		platform.assetManager().setPathPrefix("JetpackMan/");
		PlayN.run(new JetpackMan());
	}
}
