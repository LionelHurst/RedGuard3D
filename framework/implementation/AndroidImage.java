package com.dagtech.opengl.framework.implementation;

/**
 * Created by Lionel on 3/14/2016.
 * Implementation of the Image Interface
 */
import android.graphics.Bitmap;

import com.dagtech.opengl.framework.Graphics.ImageFormat;
import com.dagtech.opengl.framework.Image;

public class AndroidImage implements Image {
    Bitmap bitmap;
    ImageFormat format;

    public AndroidImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}
