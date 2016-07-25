package com.dagtech.opengl.framework.implementation;

import android.view.View;

import com.dagtech.opengl.framework.Input;

import java.util.List;

/**
 * Created by Lionel on 3/14/2016.
 */
public interface TouchHandler extends View.OnTouchListener {
    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<Input.TouchEvent> getTouchEvents();
}

