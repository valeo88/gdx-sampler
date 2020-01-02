package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class GdxModuleInfoSample  extends SampleBase {
	public static final SampleInfo SAMPLE_INFO = new SampleInfo(GdxModuleInfoSample.class);

	private final static Logger logger = new Logger(GdxModuleInfoSample.class.getName(), Logger.DEBUG);

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		logger.debug("app=" + Gdx.app);
		logger.debug("files=" + Gdx.files);
		logger.debug("input=" + Gdx.input);
		logger.debug("input=" + Gdx.input);
		logger.debug("audio=" + Gdx.audio);
		logger.debug("graphics=" + Gdx.graphics);
	}

	@Override
	public void resize(int i, int i1) {

	}

	@Override
	public void render() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
