package georgeBritton.dinostory.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import georgeBritton.dinostory.core.DinoMain;

public class DinoMainActivity extends GameActivity {

  @Override
  public void main(){
    platform().assets().setPathPrefix("georgeBritton/dinostory/resources");
    PlayN.run(new DinoMain());
  }
}
