package com.dagtech.opengl;

import android.opengl.GLU;

import com.dagtech.opengl.framework.Game;
import com.dagtech.opengl.framework.Input;
import com.dagtech.opengl.framework.Screen;

import java.util.List;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Lionel on 3/14/2016.
 * The main menu class
 */
public class MainMenu extends Screen{

    //private Grid square = new Grid();
    private Map map = new Map();
    private float angle = 0;
    private float x = 0;
    private float y = -60;
    private float x1, y1;
    private float x2, y2;
    private float dx, dy;

    public MainMenu(Game game) {
        super(game);
        map.generateMap(8,8);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glEnable(GL10.GL_TEXTURE_2D);            //Enable Texture Mapping ( NEW )
        gl.glShadeModel(GL10.GL_SMOOTH);            //Enable Smooth Shading
        gl.glClearColor(1.0f, 1.0f, 1.0f, 0.5f);    //Black Background
        gl.glClearDepthf(1.0f);                     //Depth Buffer Setup
        gl.glEnable(GL10.GL_DEPTH_TEST);            //Enables Depth Testing
        gl.glDepthFunc(GL10.GL_LEQUAL);             //The Type Of Depth Testing To Do

        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
        gl.glEnable(GL10.GL_BLEND);


        //Really Nice Perspective Calculations
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);

    }
        @Override
        public void onDrawFrame(GL10 gl) {

            gl.glMatrixMode(GL10.GL_MODELVIEW);
            gl.glLoadIdentity();
            //GLU.gluLookAt(gl, 0, 0, 0, 0, 0, -10, 0, 1, 0);
            //gl.glRotatef(15,0,0,1);

            List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
            int len = touchEvents.size();
            for (int i = 0; i < len; i++) {
                Input.TouchEvent event = touchEvents.get(i);
                if (event.type == Input.TouchEvent.TOUCH_UP) {

                } else if (event.type == Input.TouchEvent.TOUCH_DOWN) {
                    x1 = event.x;
                    y1 = event.y;
                    x2 = 0;
                    y2 = 0;
                } else if (event.type == Input.TouchEvent.TOUCH_DRAGGED) {
                    if (x2 != 0) {
                        x1 = x2;
                        y1 = y2;
                    }

                    x2 = event.x;
                    y2 = event.y;

                    dx = x2 - x1;
                    dy = y2 - y1;
                    x -= dx/10;
                    y += dy/10;
                }
            }

            // Clears the screen and depth buffer.
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
            // Replace the current matrix with the identity matrix
            gl.glLoadIdentity();
            gl.glTranslatef(0, -1, -7);
            gl.glRotatef(x, 0, 1, 0);
            gl.glRotatef(y, 1, 0, 0);
            //gl.glRotatef(z, 0, 0, 1);
            gl.glPushMatrix();
            //square.draw(gl, Assets.textures.get(R.drawable.tilesq));
            map.draw(gl, Assets.textures.get(R.drawable.tilesq));

        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            // Sets the current view port to the new size.
            gl.glViewport(0, 0, width, height);
            // Select the projection matrix
            gl.glMatrixMode(GL10.GL_PROJECTION);
            // Reset the projection matrix
            gl.glLoadIdentity();
            // Calculate the aspect ratio of the window
            GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f,
                    100.0f);
            // Select the modelview matrix
            gl.glMatrixMode(GL10.GL_MODELVIEW);
            // Reset the modelview matrix
            gl.glLoadIdentity();
        }

        @Override
        public void pause() {


        }


        @Override
        public void resume() {


        }

        @Override
        public void dispose() {


        }


        @Override
        public void backButton() {


        }
}
