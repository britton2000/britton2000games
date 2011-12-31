package georgeBritton.topDownGame.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import georgeBritton.topDownGame.core.topDownGame;

public class topDownGameActivity extends GameActivity {

  @Override
  public void main(){
    platform().assetManager().setPathPrefix("georgeBritton/topDownGame/resources");
    PlayN.run(new topDownGame());
  }
}
