package com.dagtech.opengl.framework;

import android.content.Context;

/**
 * Created by Lionel on 3/6/2016.
 */
public interface Game {

    Audio getAudio();

    Input getInput();

    Graphics getGraphics();

    //public FileIO getFileIO();

    //public Graphics getGraphics();

    void setScreen(Screen screen);

    Screen getCurrentScreen();

    Screen getInitScreen();

    Context getContext();
}
