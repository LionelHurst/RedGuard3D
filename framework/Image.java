package com.dagtech.opengl.framework;

import com.dagtech.opengl.framework.Graphics.ImageFormat;

/**
 * Created by Lionel on 3/14/2016.
 * Interface for the image class
 */
public interface Image {
    int getWidth();
    int getHeight();
    ImageFormat getFormat();
    void dispose();
}

