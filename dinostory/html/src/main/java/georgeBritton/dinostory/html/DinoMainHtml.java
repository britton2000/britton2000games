package georgeBritton.dinostory.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import georgeBritton.dinostory.core.DinoMain;

public class DinoMainHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assets().setPathPrefix("dinostory/");
    PlayN.run(new DinoMain());
  }
}
