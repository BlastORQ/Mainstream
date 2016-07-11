package ua.pp.blastorq.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ua.pp.blastorq.Mainstream;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Mainstream";
		config.width = 320;
		config.height = 630;
		new LwjglApplication(new Mainstream(), config);
	}
}
