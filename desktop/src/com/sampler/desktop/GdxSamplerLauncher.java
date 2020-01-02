package com.sampler.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GdxSamplerLauncher extends JFrame {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    private LwjglAWTCanvas lwjglAWTCanvas;

    public GdxSamplerLauncher() throws HeadlessException {
        setTitle(GdxSamplerLauncher.class.getSimpleName());
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // tell window to resize and layout our components
        pack();
        setVisible(true);

        launchSample("com.sampler.InputListeningSample");
    }

    private void launchSample(String name) {
        Container container = getContentPane();

        if (lwjglAWTCanvas != null) {
            lwjglAWTCanvas.stop();
            container.remove(lwjglAWTCanvas.getCanvas());
        }

        ApplicationListener sample;
        try {
            Class<ApplicationListener> listenerClass = ClassReflection.forName(name);
            sample = ClassReflection.newInstance(listenerClass);
        } catch (ReflectionException e) {
            throw new RuntimeException("Can't create sample with name=" + name, e);
        }

        lwjglAWTCanvas = new LwjglAWTCanvas(sample);
        lwjglAWTCanvas.getCanvas().setSize(WIDTH, HEIGHT);
        container.add(lwjglAWTCanvas.getCanvas(), BorderLayout.CENTER);

        pack();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GdxSamplerLauncher::new);
    }
}
