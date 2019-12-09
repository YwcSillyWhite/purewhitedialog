package com.purewhite.dialog.help;

import com.purewhite.dialog.DialogUtils;

/**
 * dialog帮助类
 * 用于显示
 */
public class DialogHelper {

    //显示
    public static void show(DialogUtils dialogUtils){
        if (dialogUtils!=null)
            dialogUtils.show();
    }

    //隐藏
    public  static void dismiss(DialogUtils ...dialogUtils){
        if (dialogUtils!=null && dialogUtils.length>0){
            for (int i = 0; i < dialogUtils.length; i++) {
                dialogUtils[i].dismiss();
            }
        }
    }
}