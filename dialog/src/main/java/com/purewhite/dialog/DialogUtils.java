package com.purewhite.dialog;

import android.app.Dialog;
import android.view.View;

import com.purewhite.dialog.builder.DialogBuilder;
import com.purewhite.dialog.holder.DialogViewHolder;

public class DialogUtils extends DialogViewHolder<DialogUtils>{


    private Dialog dialog;

    //获取dialog
    public Dialog obtainDialog(){
        return dialog;
    }

    public DialogUtils(View dialogView, View.OnClickListener onClickListener, Dialog dialog) {
        super(dialogView, onClickListener);
        this.dialog=dialog;
    }

    public static DialogBuilder build(){
        return new DialogBuilder();
    }

    /**
     * 显示
     */
    public void show(){
        if (null!=dialog && !dialog.isShowing()){
            dialog.show();
        }
    }

    /**
     * 隐藏
     */
    public void dismiss(){
        if (null!=dialog && dialog.isShowing()){
            dialog.dismiss();
        }
    }

}
