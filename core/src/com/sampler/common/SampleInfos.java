package com.sampler.common;

import com.sampler.ApplicationListenerSample;
import com.sampler.AssetManagerSample;
import com.sampler.BitmapFontSample;
import com.sampler.GdxGeneratedSample;
import com.sampler.GdxModuleInfoSample;
import com.sampler.GdxReflectionSample;
import com.sampler.InputListeningSample;
import com.sampler.InputPollingSample;
import com.sampler.OrthographicCameraSample;
import com.sampler.PoolingSample;
import com.sampler.ShapeRendererSample;
import com.sampler.SpriteBatchSample;
import com.sampler.ViewportSample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SampleInfos {

    private static final List<SampleInfo> ALL = Arrays.asList(
            ApplicationListenerSample.SAMPLE_INFO,
            GdxModuleInfoSample.SAMPLE_INFO,
            GdxReflectionSample.SAMPLE_INFO,
            InputListeningSample.SAMPLE_INFO,
            InputPollingSample.SAMPLE_INFO,
            OrthographicCameraSample.SAMPLE_INFO,
            ViewportSample.SAMPLE_INFO,
            SpriteBatchSample.SAMPLE_INFO,
            GdxGeneratedSample.SAMPLE_INFO,
            ShapeRendererSample.SAMPLE_INFO,
            BitmapFontSample.SAMPLE_INFO,
            PoolingSample.SAMPLE_INFO,
            AssetManagerSample.SAMPLE_INFO
    );

    public static List<String> getSampleNames() {
        return ALL.stream().map(SampleInfo::getName).sorted().collect(Collectors.toList());
    }

    public static SampleInfo find(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name is required");

        return ALL.stream().filter(info -> name.equals(info.getName())).findAny()
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    private SampleInfos() {}
}
