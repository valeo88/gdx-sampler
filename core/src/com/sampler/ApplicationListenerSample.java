package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.sampler.common.SampleBase;
import com.sampler.common.SampleInfo;

public class ApplicationListenerSample extends SampleBase {
    public static final SampleInfo SAMPLE_INFO = new SampleInfo(ApplicationListenerSample.class);

    private static final Logger log = new Logger(ApplicationListenerSample.class.getName(), Logger.DEBUG);

    private boolean renderInterrupted = true;

    @Override
    public void create() {
        // used to init game and load resources
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        log.debug("create()");
    }

    @Override
    public void resize(int i, int i1) {
        // used to handle settings of new screen size
        log.debug(String.format("resize(%d, %d)", i, i1));
    }

    @Override
    public void render() {
        // used to update and render, called 60tps
        if (renderInterrupted) {
            log.debug("render()");
            renderInterrupted = false;
        }
    }

    @Override
    public void pause() {
        // save game state when looses focus
        log.debug("pause()");
        renderInterrupted = true;
    }

    @Override
    public void resume() {
        // coming back from paused state
        log.debug("resume()");
        renderInterrupted = true;
    }

    @Override
    public void dispose() {
        // free resources and cleanup game
        log.debug("dispose()");
    }
}

