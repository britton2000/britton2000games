package georgeBritton.JetpackMan.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import georgeBritton.JetpackMan.core.jetpackMan;

public class jetpackManHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assetManager().setPathPrefix("JetpackMan/");
    PlayN.run(new jetpackMan());
  }
}
