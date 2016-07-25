package com.dagtech.opengl.framework;

import android.graphics.Bitmap;

/**
 * Created by Lionel on 3/16/2016.
 */
public interface Graphics {
    public static enum ImageFormat {
        ARGB8888, ARGB4444, RGB565
    }

    public Bitmap newImage(String fileName, ImageFormat format);

}