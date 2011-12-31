package georgeBritton.topDownGame.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import georgeBritton.topDownGame.core.topDownGame;

public class topDownGameHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assetManager().setPathPrefix("topDownGame/");
    PlayN.run(new topDownGame());
  }
}
