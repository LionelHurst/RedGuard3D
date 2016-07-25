package com.dagtech.opengl.framework.implementation;

import android.content.Context;
import android.os.Build;
import android.view.View;

import com.dagtech.opengl.framework.Input;

import java.util.List;

/**
 * Created by Lionel on 3/14/2016.
 */
public class AndroidInput implements Input {
    TouchHandler touchHandler;

    public AndroidInput(Context context, View view) {
            touchHandler = new SingleTouchHandler(view);
            //touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
    }


    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }



    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }

}