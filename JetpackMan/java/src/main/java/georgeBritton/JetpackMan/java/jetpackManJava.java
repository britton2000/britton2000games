package georgeBritton.JetpackMan.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import georgeBritton.JetpackMan.core.jetpackMan;

public class jetpackManJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assetManager().setPathPrefix("georgeBritton/JetpackMan/resources");
    PlayN.run(new jetpackMan());
  }
}
