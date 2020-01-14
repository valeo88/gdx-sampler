package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;
import com.sampler.utils.GdxUtils;

public class AssetManagerSample extends SampleBase {
    private static final Logger log = new Logger(PoolingSample.class.getName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(AssetManagerSample.class);

    private static final float WORLD_WIDTH = 1080f; // world units
    private static final float WORLD_HEIGHT = 720f; // world units

    private static final String BG_BLUE = "raw/background-blue.png";
    private static final String CIRCLE_GREEN = "raw/circle-green.png";
    private static final String CIRCLE_RED = "raw/circle-red.png";
    private static final String FONT = "fonts/oswald-32.fnt";

    private AssetManager assetManager;
    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;

    private Texture backgroundBlue;
    private Texture greenCircle;
    private Texture redCircle;
    private BitmapFont font;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        assetManager = new AssetManager();
        assetManager.getLogger().setLevel(Logger.DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        batch = new SpriteBatch();

        // load assests
        assetManager.load(BG_BLUE, Texture.class);
        assetManager.load(CIRCLE_GREEN, Texture.class);
        assetManager.load(CIRCLE_RED, Texture.class);
        assetManager.load(FONT, BitmapFont.class);

        assetManager.finishLoading();

        backgroundBlue = assetManager.get(BG_BLUE);
        greenCircle = assetManager.get(CIRCLE_GREEN);
        redCircle = assetManager.get(CIRCLE_RED);
        font = assetManager.get(FONT);
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.draw(backgroundBlue, 0, 0);
        batch.draw(greenCircle, 10, 10);
        batch.draw(redCircle, 100, 100);
        font.draw(batch, "HELLO", 50, 50);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        assetManager.dispose();
    }
}
