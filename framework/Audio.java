package com.dagtech.opengl.framework;

/**
 * Created by Lionel on 3/6/2016.
 */
public interface Audio {
    public Music createMusic(String file);

    public Sound createSound(String file);
}

