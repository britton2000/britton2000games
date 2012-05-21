package georgeBritton.dinostory.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import georgeBritton.dinostory.core.DinoMain;

public class DinoMainJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assets().setPathPrefix("georgeBritton/dinostory/resources");
    PlayN.run(new DinoMain());
  }
}
