package com.dagtech.opengl;

import com.dagtech.opengl.framework.*;

import java.util.Random;

/**
 * Created by Lionel on 7/21/2016.
 */
public class Tile {
    private int x, y, type, tileW, tileH, hOffset, vOffset;
    private Random rand;

    Vertex shape,texture;

    public Tile(int x, int y, int type, int hOffset, int vOffset){
        this.x = x;
        this.y = y;
        tileW = 64;
        tileH = 32;
        //tileX = ((y * tileW/2) - (x * tileW/2)) + hOffset;
        //tileY = ((x * tileH/2) + (y * tileH/2)) + vOffset;
        this.hOffset = hOffset;
        this.vOffset = vOffset;
        /*speedX = 0;
        speedY = 0;*/
        rand = new Random();
        this.type = type;
        setType(type);

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

    public void setType(int i) {
        type = i;
    }

    public Vertex getShapeVertex(){
        return shape;
    }

    public Vertex getTextureVertex() {
        return texture;
    }
}
