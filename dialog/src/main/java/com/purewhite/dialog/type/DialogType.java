package com.purewhite.dialog.type;

import android.view.Gravity;
import android.view.View;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DialogType {

    @IntDef({View.VISIBLE, View.GONE, View.INVISIBLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {}

    @IntDef({Gravity.TOP, Gravity.BOTTOM,Gravity.LEFT, Gravity.RIGHT,Gravity.CENTER,0})
    @Retention(RetentionPolicy.SOURCE)
    public @interface gravity {}
}
