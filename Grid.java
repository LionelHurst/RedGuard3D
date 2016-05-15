package com.dagtech.opengl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
import android.util.Log;

import com.dagtech.opengl.framework.Vertex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

// Just a basic square, for testing purposes

public class Grid {
    private boolean mShouldLoadTexture = true;
    private float z = 0;

    Vertex shape,texture;

    public Grid() {
        shape = new Vertex (new float[]
                {
                        1f,1f,0f,
                        0f,1f,0f,
                        1f,0f,0f,
                        0f,0f,0f,
                });

        texture = new Vertex (new float[]
                {
                        0.0f, 1.0f,
                        1.0f, 1.0f,
                        0.0f, 0.0f,
                        1.0f, 0.0f,
                });
    }
    /**
     * This function draws our square on screen.
     * @param gl
     */
    public void draw(GL10 gl, int image) {
        z = -10;
        gl.glBindTexture(GL10.GL_TEXTURE_2D, image);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glColor4f (1.0f, 1.0f, 1.0f, 0.5f);
        gl.glFrontFace(GL10.GL_CW);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, shape.buffer);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texture.buffer);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, z);
        gl.glPushMatrix();

        gl.glTranslatef(-1, 0, 0);
        gl.glDrawArrays (GL10.GL_TRIANGLE_STRIP, 0, shape.vertex.length /   3);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 0, 0);
        gl.glDrawArrays (GL10.GL_TRIANGLE_STRIP, 0, shape.vertex.length /   3);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(1, 0, 0);
        gl.glDrawArrays (GL10.GL_TRIANGLE_STRIP, 0, shape.vertex.length /   3);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-1, -1, 0);
        gl.glDrawArrays (GL10.GL_TRIANGLE_STRIP, 0, shape.vertex.length /   3);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, -1, 0);
        gl.glDrawArrays (GL10.GL_TRIANGLE_STRIP, 0, shape.vertex.length /   3);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(1, -1, 0);
        gl.glDrawArrays (GL10.GL_TRIANGLE_STRIP, 0, shape.vertex.length /   3);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-1, 1, 0);
        gl.glDrawArrays (GL10.GL_TRIANGLE_STRIP, 0, shape.vertex.length /   3);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 1, 0);
        gl.glDrawArrays (GL10.GL_TRIANGLE_STRIP, 0, shape.vertex.length /   3);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(1, 1, 0);
        gl.glDrawArrays (GL10.GL_TRIANGLE_STRIP, 0, shape.vertex.length /   3);
        gl.glPopMatrix();
        // Disable face culling.
        //gl.glDisable(GL10.GL_CULL_FACE);
    }

}
