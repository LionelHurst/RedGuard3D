package com.dagtech.opengl.framework.implementation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.dagtech.opengl.framework.Audio;
import com.dagtech.opengl.framework.Game;
import com.dagtech.opengl.framework.Graphics;
import com.dagtech.opengl.framework.Input;
import com.dagtech.opengl.framework.Screen;

/**
 * Created by Lionel on 3/6/2016.
 */
public abstract class AndroidGame extends Activity implements Game {
    AndroidRenderer renderView;
    Audio audio;
    Screen screen;
    Input input;
    Graphics graphics;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getBaseContext();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        renderView = new AndroidRenderer(this);
        graphics = new AndroidGraphics(getAssets());
        input = new AndroidInput(this, renderView);
        screen = getInitScreen();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(renderView);
    }

    @Override
    public void onResume() {
        super.onResume();
        //wakeLock.acquire();
        screen.resume();
        renderView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //wakeLock.release();
        //renderView.pause();
        screen.pause();

        if (isFinishing())
            screen.dispose();
    }

    @Override
    public Input getInput() {
        return input;
    }

    /*@Override
    public FileIO getFileIO() {
        return fileIO;
    }*/

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    @Override
    public void setScreen(Screen screen) {
        if (screen == null)
            throw new IllegalArgumentException("Screen must not be null");

        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        this.screen = screen;
    }

    public Screen getCurrentScreen() {

        return screen;
    }

    public Context getContext(){
        return context;
    }
}
