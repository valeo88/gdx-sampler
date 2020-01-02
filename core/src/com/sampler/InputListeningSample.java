package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.utils.GdxUtils;

public class InputListeningSample implements ApplicationListener, InputProcessor {

	private static final Logger logger = new Logger(InputListeningSample.class.getName(), Logger.DEBUG);

	private static final int MAX_MESSAGES_CNT = 15;
	private static final Array<String> messages = new Array<>();

	private OrthographicCamera camera;
	private Viewport viewport;
	private SpriteBatch batch;
	private BitmapFont font;

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		camera = new OrthographicCamera();
		viewport = new FitViewport(1080, 720, camera);
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));

		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void resize(int i, int i1) {
		viewport.update(i, i1, true);
	}

	@Override
	public void render() {
		GdxUtils.clearScreen();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		draw();

		batch.end();
	}

	private void draw() {
		for (int i = 0; i < messages.size; i++) {
			font.draw(batch, messages.get(i),
					20.0f,
					720 - 40.0f * (i + 1));
		}
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	private void addMessage(String message) {
		messages.add(message);

		if (messages.size > MAX_MESSAGES_CNT) {
			messages.removeIndex(0);
		}
	}

	@Override
	public boolean keyDown(int i) {
		String message = "keyDown= " + i;
		logger.debug(message);
		addMessage(message);
		return true;
	}

	@Override
	public boolean keyUp(int i) {
		String message = "keyUp= " + i;
		logger.debug(message);
		addMessage(message);
		return true;
	}

	@Override
	public boolean keyTyped(char c) {
		String message = "keyTyped= " + c;
		logger.debug(message);
		addMessage(message);
		return true;
	}

	@Override
	public boolean touchDown(int i, int i1, int i2, int i3) {
		String message = "touchDown screenX=" + i + " screenY=" + i1;
		logger.debug(message);
		addMessage(message);
		return true;
	}

	@Override
	public boolean touchUp(int i, int i1, int i2, int i3) {
		String message = "touchUp screenX=" + i + " screenY=" + i1;
		logger.debug(message);
		addMessage(message);
		return true;
	}

	@Override
	public boolean touchDragged(int i, int i1, int i2) {
		String message = "touchDragged screenX=" + i + " screenY=" + i1;
		logger.debug(message);
		addMessage(message);
		return true;
	}

	@Override
	public boolean mouseMoved(int i, int i1) {
		String message = "mouseMoved screenX=" + i + " screenY=" + i1;
		logger.debug(message);
		addMessage(message);
		return true;
	}

	@Override
	public boolean scrolled(int i) {
		String message = "scrolled= " + i;
		logger.debug(message);
		addMessage(message);
		return true;
	}
}
