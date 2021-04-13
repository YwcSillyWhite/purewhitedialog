package com.purewhite.dialog.builder;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.LayoutRes;

import com.purewhite.dialog.DialogUtils;
import com.purewhite.dialog.R;
import com.purewhite.dialog.holder.DialogViewHolder;
import com.purewhite.dialog.io.DialogIo;
import com.purewhite.dialog.type.DialogType;

public class DialogBuilder {

    //dialog布局
    private int layoutId;
    //dialog的动画
    private int dialogAnim ;
    //主题
    private int themeRes =R.style.BaseDialog;
    //点击外面是否取消
    private boolean canceledOnTouchOutside=true;
    //点击返回键是否取消
    private boolean canceled=true;
    //取消监听
    private DialogInterface.OnDismissListener onDismissListener;
    //键盘按键监听
    private DialogInterface.OnKeyListener onKeyListener;
    //设置dialog的大小,显示位置
    private int width = WindowManager.LayoutParams.MATCH_PARENT;
    private int height = WindowManager.LayoutParams.WRAP_CONTENT;
    private int deviationX,deviationY,gravity;
    //回调设置数据
    private DialogIo dialogIo;

    /**
     * 设置布局
     * @param layoutId
     * @return
     */
    public DialogBuilder setLayoutId(@LayoutRes int layoutId) {
        if (layoutId != 0)
            this.layoutId = layoutId;
        return this;
    }


    public DialogBuilder setDialogIo(DialogIo dialogIo) {
        this.dialogIo = dialogIo;
        return this;
    }

    /**
     * 设置dialog动画
     * 已写了4种动画,上下左右进入;
     * 需要其他需要自己写
     * @param dialogAnim
     * @return
     */
    public DialogBuilder setDialogAnim(int dialogAnim) {
        this.dialogAnim = dialogAnim;
        return this;
    }

    /**
     * 设置dialog主题
     * 提供了2种主题类型
     * @param themeRes
     * @return
     */
    public DialogBuilder setThemeRes(int themeRes) {
        this.themeRes = themeRes;
        return this;
    }

    /**
     * 设置点击外部是否取消dialog
     * @param canceledOnTouchOutside
     * @return
     */
    public DialogBuilder setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        this.canceledOnTouchOutside = canceledOnTouchOutside;
        return this;
    }

    /**
     * 设置点击返回是否取消dialog
     * @param canceled
     * @return
     */
    public DialogBuilder setCanceled(boolean canceled) {
        this.canceled = canceled;
        return this;
    }

    /**
     * 设置取消监听
     * @param onDismissListener
     * @return
     */
    public DialogBuilder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
        return this;
    }

    /**
     * 设置键盘监听
     * @param onKeyListener
     * @return
     */
    public DialogBuilder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.onKeyListener = onKeyListener;
        return this;
    }


    public DialogBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public DialogBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    /**
     *设置 位置
     * @param deviationX  偏移x
     * @param deviationY  偏移y
     * @param gravity     显示位置
     * @return
     */
    public DialogBuilder setSplace(int deviationX,int deviationY,@DialogType.gravity int gravity){
        this.deviationX=deviationX;
        this.deviationY=deviationY;
        this.gravity=gravity;
        return this;
    }



    public DialogUtils buildDialog(Context context){
        View dialogView = LayoutInflater.from(context).inflate(layoutId!=0 ? layoutId : R.layout.dialog_error, null);
        DialogViewHolder dialogViewHolder = new DialogViewHolder(dialogView);
        Dialog dialog = new Dialog(context, themeRes);
        dialog.setContentView(dialogView);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
        dialog.setCancelable(canceled);
        if (null != onDismissListener)
            dialog.setOnDismissListener(onDismissListener);
        if (null != onKeyListener)
            dialog.setOnKeyListener(onKeyListener);
        Window window = dialog.getWindow();
        if (dialogAnim != 0)
            window.setWindowAnimations(dialogAnim);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = width;
        layoutParams.height = height;
        if (deviationX!=0)
            layoutParams.x = deviationX;
        if (deviationY!=0)
            layoutParams.y = deviationY;
        if (gravity!=0)
            layoutParams.gravity =gravity;
        window.setAttributes(layoutParams);
        if (null != dialogIo)
            dialogIo.initView(dialogViewHolder);
        return new DialogUtils(dialogViewHolder,dialog);
    }


//    /***
//     * 使用这个方法需要注意,必须导入androidx包 material
//     * @param context
//     * @return
//     */
//    public DialogUtils buildBottomSheetDialog(Context context){
//        View dialogView = LayoutInflater.from(context).inflate(layoutId!=0 ? layoutId : R.layout.dialog_error, null);
//        BottomSheetDialog dialog = new BottomSheetDialog(context, themeRes);
//        dialog.setContentView(dialogView);
//        dialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
//        dialog.setCancelable(canceled);
//        if (null != onDismissListener)
//            dialog.setOnDismissListener(onDismissListener);
//        if (null != onKeyListener)
//            dialog.setOnKeyListener(onKeyListener);
//        return new DialogUtils(dd,onClickListener,dialog);
//    }
}
