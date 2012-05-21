package georgeBritton.JetpackMan.java;

import georgeBritton.JetpackMan.core.JetpackMan;
import playn.core.PlayN;
import playn.java.JavaPlatform;

public class JetpackManJava {

	public static void main(String[] args) {
		JavaPlatform platform = JavaPlatform.register();
		platform.assetManager().setPathPrefix(
				"georgeBritton/JetpackMan/resources");
		PlayN.run(new JetpackMan());
	}
}
