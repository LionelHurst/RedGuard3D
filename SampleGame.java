package com.dagtech.opengl;

import com.dagtech.opengl.framework.Screen;
import com.dagtech.opengl.framework.implementation.AndroidGame;

/**
 * Created by Lionel on 3/6/2016.
 */
public class SampleGame extends AndroidGame {
    @Override
    public Screen getInitScreen() {

        return new LoadingScreen(this);

    }
}
