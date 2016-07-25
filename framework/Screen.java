
package com.dagtech.opengl.framework;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Lionel on 3/6/2016.
 */
    public abstract class Screen {
        protected final Game game;

        public Screen(Game game) {
            this.game = game;
        }

        public abstract void onSurfaceCreated(GL10 gl, EGLConfig config);

        public abstract void onSurfaceChanged(GL10 gl, int width, int height);

        public abstract void onDrawFrame(GL10 gl);

        public abstract void pause();

        public abstract void resume();

        public abstract void dispose();

        public abstract void backButton();
    }
