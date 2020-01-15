package com.sampler.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class AssetPacker {
    private static final boolean DRAW_DEBUG_OUTLINE = false;

    private static final String RAW_ASSETS_PATH = "desktop/assets-raw";
    private static final String ASSETS_PATH = "core/assets";

    public static void main(String[] args) {
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.debug = DRAW_DEBUG_OUTLINE;
        settings.maxWidth = 2048;
        settings.maxHeight = 2048;

        TexturePacker.process(settings,
                RAW_ASSETS_PATH + "/images",
                ASSETS_PATH + "/images",
                "atlasSample"
        );
    }
}
