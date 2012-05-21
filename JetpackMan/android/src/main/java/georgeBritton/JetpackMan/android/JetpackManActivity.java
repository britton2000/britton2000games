package georgeBritton.JetpackMan.android;

import georgeBritton.JetpackMan.core.JetpackMan;
import playn.android.GameActivity;
import playn.core.PlayN;

public class JetpackManActivity extends GameActivity {

	@Override
	public void main() {
		platform().assetManager().setPathPrefix(
				"georgeBritton/JetpackMan/resources");
		PlayN.run(new JetpackMan());
	}
}
