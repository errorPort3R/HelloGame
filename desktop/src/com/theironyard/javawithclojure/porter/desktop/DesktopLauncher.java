package com.theironyard.javawithclojure.porter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.theironyard.javawithclojure.porter.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 1000;
		config.width = 800;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
