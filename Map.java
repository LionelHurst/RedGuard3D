package com.dagtech.opengl;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Lionel on 7/21/2016.
 */
public class Map {
    private ArrayList<ArrayList<Tile>> tilearray;
    private int hOffset, vOffset, width, height;

    private Vertex shape, texture;

    public Map() {
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

    public void generateMap(int w, int h){
        this.width = w;
        this.height = h;

        tilearray = new ArrayList<ArrayList<Tile>>();
        int i = 0;
        int j = 0;

        for (i = 0; i < height; i++){
            tilearray.add(new ArrayList<Tile>());
            for (j = 0; j < width; j++) {
                Tile t = new Tile(i, j, 5, 0, 0);
                tilearray.get(i).add(t);
            }
        }
    }

    public void draw(GL10 gl, int image){
        float z = -15;
        gl.glBindTexture(GL10.GL_TEXTURE_2D, image);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glColor4f (1.0f, 1.0f, 1.0f, 0.5f);
        gl.glFrontFace(GL10.GL_CW);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, shape.buffer);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texture.buffer);
        //gl.glLoadIdentity();
        //gl.glRotatef(-45, 1, 0, 0);
        for (int i = 0; i < tilearray.size(); i++) {
            for (int j = 0; j < tilearray.get(i).size(); j++) {
                gl.glPushMatrix();
                //((y * tileW/2) - (x * tileW/2))
                gl.glTranslatef(((j * 1f/2) - (i * 1f/2)), ((i * 1f/2) + (j * 1f/2)), 0);
                gl.glRotatef(45, 0, 0, 1);
                gl.glDrawArrays (GL10.GL_TRIANGLE_STRIP, 0, shape.vertex.length /   3);
                //gl.glPushMatrix();
                gl.glPopMatrix();
            }
        }
    }

    public Tile getTile(int x, int y){
        return tilearray.get(x).get(y);
    }

}
