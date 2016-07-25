package com.dagtech.opengl.framework.implementation;

import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Lionel on 3/6/2016.
 */
public class AndroidRenderer extends GLSurfaceView implements Renderer {
    AndroidGame game;
    volatile boolean running = false;

    public AndroidRenderer(AndroidGame game) {
        super(game);
        this.setRenderer(this);
        this.game = game;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        game.getCurrentScreen().onSurfaceCreated(gl, config);
    }

    public void onDrawFrame(GL10 gl) {
        game.getCurrentScreen().onDrawFrame(gl);
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        game.getCurrentScreen().onSurfaceChanged(gl, width, height);
    }

    public void resume() {
        running = true;
    }
}
