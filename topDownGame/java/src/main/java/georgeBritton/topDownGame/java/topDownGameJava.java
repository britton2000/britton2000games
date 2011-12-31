package georgeBritton.topDownGame.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import georgeBritton.topDownGame.core.topDownGame;

public class topDownGameJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assetManager().setPathPrefix("georgeBritton/topDownGame/resources");
    PlayN.run(new topDownGame());
  }
}
