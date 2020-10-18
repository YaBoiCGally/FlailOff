package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import io.galjcam.flailoff.FlailOff;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.width = 852;
                config.height = 480;
                config.title = "Flail Off";
		new LwjglApplication(new FlailOff(), config);
	}
}
