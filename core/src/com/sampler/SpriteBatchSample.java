package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;
import com.sampler.utils.GdxUtils;

public class SpriteBatchSample extends SampleBase {
    public static final SampleInfo SAMPLE_INFO = new SampleInfo(SpriteBatchSample.class);

    private static final Logger logger = new Logger(SpriteBatchSample.class.getName(), Logger.DEBUG);

    private static final float WORLD_WIDTH = 10.8f; // world units
    private static final float WORLD_HEIGHT = 7.2f; // world units

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;

    private Texture texture;
    private Color oldColor;

    private int width = 1; // world units
    private int height = 1; // world units

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        batch = new SpriteBatch();

        texture = new Texture(Gdx.files.internal("raw/character.png"));
        oldColor = new Color();
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
        batch.draw(texture,
                0,0,
                width / 2f, height / 2f,
                width, height,
                1.f, 1.f,
                0.f,
                0, 0,
                texture.getWidth(), texture.getHeight(),
                false, false);

        batch.draw(texture,
                4,2,
                width / 2f, height / 2f,
                width, height,
                2.f, 1.f,
                0.f,
                0, 0,
                texture.getWidth(), texture.getHeight(),
                false, true);

        oldColor.set(batch.getColor());

        batch.setColor(Color.CHARTREUSE);
        batch.draw(texture,
                8,1,
                width / 2f, height / 2f,
                width, height,
                1.f, 1.f,
                0.f,
                0, 0,
                texture.getWidth(), texture.getHeight(),
                false, false);
        batch.setColor(oldColor);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
