package georgeBritton.JetpackMan.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import georgeBritton.JetpackMan.core.jetpackMan;

public class jetpackManActivity extends GameActivity {

  @Override
  public void main(){
    platform().assetManager().setPathPrefix("georgeBritton/JetpackMan/resources");
    PlayN.run(new jetpackMan());
  }
}
