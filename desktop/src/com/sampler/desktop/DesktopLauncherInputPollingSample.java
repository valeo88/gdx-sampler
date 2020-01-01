package com.sampler.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sampler.InputPollingSample;

public class DesktopLauncherInputPollingSample {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		setupInitialPosition(config);
		new LwjglApplication(new InputPollingSample(), config);
	}

	private static void setupInitialPosition(LwjglApplicationConfiguration config) {
		config.x = 100;
		config.y = 100;
	}
}
