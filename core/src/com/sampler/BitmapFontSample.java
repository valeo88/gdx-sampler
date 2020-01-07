package com.sampler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class BitmapFontSample extends SampleBase {
    public static final SampleInfo SAMPLE_INFO = new SampleInfo(BitmapFontSample.class);

    private static final float WORLD_WIDTH = 1080f;
    private static final float WORLD_HEIGHT = 720f;

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont effectFont;
    private BitmapFont uiFont;
    private GlyphLayout glyphLayout;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        batch = new SpriteBatch();
        glyphLayout = new GlyphLayout();
        effectFont = new BitmapFont(Gdx.files.internal("fonts/cambria-gradient-32.fnt"));
        uiFont = new BitmapFont(Gdx.files.internal("fonts/arial-32.fnt"));
        uiFont.getData().markupEnabled = true;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();
    }

    private void draw() {
        String text1 = "Using bitmap font";
        effectFont.draw(batch, text1, 20, WORLD_HEIGHT - 20, 100, 0, true);

        String text2 = "[#FF1001]Bitmap [GREEN]fonts [BLUE]are [YELLOW]cool!";
        glyphLayout.setText(uiFont, text2);
        uiFont.draw(batch, text2,
                (WORLD_WIDTH - glyphLayout.width) / 2f,
                (WORLD_HEIGHT - glyphLayout.height) / 2f);
    }

    @Override
    public void dispose() {
        batch.dispose();
        effectFont.dispose();
        uiFont.dispose();
    }
}
