package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		// config
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Inferno");
		config.setWindowedMode(2560, 1440);

		// initialize the game
		new Lwjgl3Application(new MyGdxGame(), config);
	}
}
