package com.dagtech.opengl;

import android.graphics.Bitmap;
import android.util.SparseIntArray;

import com.dagtech.opengl.framework.Image;

/**
 * Created by Lionel on 3/6/2016.
 * Global class for all game assets to be used across all screens
 * Should be broken up into long term and short term assets later
 */
public class Assets {
    public static Image android;
    public static Bitmap tile;
    public static SparseIntArray textures = new SparseIntArray();
}
