package com.purewhite.dialog;

import android.app.Dialog;

import com.purewhite.dialog.builder.DialogBuilder;
import com.purewhite.dialog.holder.DialogViewHolder;

public class DialogUtils {

    public static DialogBuilder build(){
        return new DialogBuilder();
    }

    //隐藏
    public static void dismiss(DialogUtils ...dialogUtils){
        if (null!=dialogUtils && dialogUtils.length>0){
            for (int i = 0; i < dialogUtils.length; i++) {
                dialogUtils[i].dismiss();
            }
        }
    }

    private Dialog dialog;
    private DialogViewHolder dialogViewHolder;

    //获取dialog
    public Dialog getDialog() {
        return dialog;
    }

    public DialogViewHolder getDialogViewHolder() {
        return dialogViewHolder;
    }

    public DialogUtils(DialogViewHolder dialogViewHolder, Dialog dialog) {
        this.dialogViewHolder = dialogViewHolder;
        this.dialog=dialog;
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
