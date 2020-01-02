package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Field;
import com.badlogic.gdx.utils.reflect.Method;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

import java.util.Arrays;

public class GdxReflectionSample  extends SampleBase {
	public static final SampleInfo SAMPLE_INFO = new SampleInfo(GdxReflectionSample.class);

	private final static Logger logger = new Logger(GdxReflectionSample.class.getName(), Logger.DEBUG);

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

		debugReflection(this.getClass());
	}

	@Override
	public void resize(int i, int i1) {
		viewport.update(i, i1, true);
	}

	@Override
	public void render() {

	}

	private void draw() {
		// mouse / touch x
		int mouseX = Gdx.input.getX();
		int mouseY = Gdx.input.getY();

		// buttons
		boolean leftButtonPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
		boolean rightButtonPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT);

		font.draw(batch, String.format("Mouse/Touch: x=%d, y=%d", mouseX, mouseY), 20f, 720-20f);
		font.draw(batch, leftButtonPressed ? "LB pressed" : "LB not pressed", 20f, 720-50f);
		font.draw(batch, rightButtonPressed ? "RB pressed" : "RB not pressed", 20f, 720-80f);

		// keys
		boolean wPressed = Gdx.input.isKeyPressed(Input.Keys.W);
		boolean sPressed = Gdx.input.isKeyPressed(Input.Keys.S);

		font.draw(batch, wPressed ? "W pressed" : "W not pressed", 20f, 720-110f);
		font.draw(batch, sPressed ? "S pressed" : "S not pressed", 20f, 720-140f);
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

	private static void debugReflection(Class<?> clazz) {
		Field[] fields = ClassReflection.getDeclaredFields(clazz);
		Method[] methods = ClassReflection.getDeclaredMethods(clazz);

		logger.debug("== debug reflections == " + clazz);
		logger.debug("fields: ");
		for(Field field : fields) {
			logger.debug("name=" + field.getName() + " type=" + field.getType());
		}
		logger.debug("methods: ");
		for(Method method : methods) {
			logger.debug("name=" + method.getName() + " type=" + Arrays.asList(method.getParameterTypes()));
		}
		logger.debug("==========");
	}
}
