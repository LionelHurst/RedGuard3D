package com.dagtech.opengl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLU;
import android.opengl.GLUtils;
import android.util.Log;
import android.util.SparseIntArray;

import com.dagtech.opengl.framework.Game;
import com.dagtech.opengl.framework.Graphics;
import com.dagtech.opengl.framework.Input;
import com.dagtech.opengl.framework.Screen;
import com.dagtech.opengl.framework.implementation.AndroidGame;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Lionel on 3/7/2016.
 */
public class LoadingScreen extends Screen {

    public Context context;
    public Resources resources;

    private float angle = 0;
    private float z = 0;

    public LoadingScreen(Game game) {
        super(game);
        this.context =  game.getContext();
        this.resources = context.getResources();
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
        image(gl, R.drawable.tilesq);
    }

    private static int next (GL10 gl)
    {
        int[] temp = new int[1];
        gl.glGenTextures (1, temp, 0);
        return temp[0];
    }

    public int image (GL10 gl, int resource)
    {
        int id = next (gl);
        Assets.textures.put (resource, id);

        gl.glBindTexture (GL10.GL_TEXTURE_2D, id);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_NEAREST);

        gl.glTexEnvf (GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_REPLACE);

        BitmapFactory.Options options = new BitmapFactory.Options ();
        options.inScaled = false;

        InputStream input = resources.openRawResource (resource);
        Bitmap bitmap = null;
        try
        {
            bitmap = BitmapFactory.decodeStream (input, null, options);
        }
        finally
        {

            try
            {
                input.close ();
            }
            catch (IOException e)
            {

            }
        }


//       Matrix flip = new Matrix ();
//       flip.postScale (1f, -1f);
//       bitmap = Bitmap.createBitmap (bitmap, 0, 0, bitmap.getWidth (), bitmap.getHeight (), flip, true);

        GLUtils.texImage2D (GL10.GL_TEXTURE_2D, 0, bitmap, 0);
        return id;
    }

    @Override
    public void onDrawFrame(GL10 gl) {

        // Create game objects here and update your loading screen animation at the same time
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == Input.TouchEvent.TOUCH_UP) {
                game.setScreen(new MainMenu(game));
            }
        }

        // Clears the screen and depth buffer.
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        // Replace the current matrix with the identity matrix
        gl.glLoadIdentity();
        // Translates 10 units into the screen.
        //gl.glTranslatef(0, 0, z);
        angle++;

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
        Log.i("OPENGL", "FIRST");
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
        z+=1;
    }
}
