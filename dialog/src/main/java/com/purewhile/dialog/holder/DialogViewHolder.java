package com.purewhile.dialog.holder;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.IdRes;

import com.purewhile.dialog.type.DialogType;

public class DialogViewHolder<D extends DialogViewHolder> {



    private View dialogView;
    private SparseArray<View> sparseArray;
    private View.OnClickListener onClickListener;
    public DialogViewHolder(View dialogView,View.OnClickListener onClickListener) {
        this.dialogView = dialogView;
        this.onClickListener=onClickListener;
        this.sparseArray = new SparseArray();
    }

    public View fdView(@IdRes int id){
        View view = sparseArray.get(id);
        if (view == null){
            view = dialogView.findViewById(id);
            sparseArray.put(id,view);
        }
        return view;
    }

    public D setText(@IdRes int id,String content){
        if (!TextUtils.isEmpty(content)){
            View view = fdView(id);
            if (view != null && view instanceof TextView){
                ((TextView) view).setText(content);
            }
        }
        return (D) this;
    }


    public D setClicks(@IdRes int ...id){
        if (id.length > 0){
            for (int i = 0; i < id.length; i++) {
                setClick(id[i]);
            }
        }
        return (D)this;
    }

    public D setClick(@IdRes int id){
        if (onClickListener != null){
            View view = fdView(id);
            if (view != null)
                view.setOnClickListener(onClickListener);
        }
        return (D)this;
    }

    public D setEnable(@IdRes int id,boolean enable){
        View view = fdView(id);
        if (view != null)
            view.setEnabled(enable);
        return (D)this;
    }

    public D setVisibility(@IdRes int id,@DialogType.Visibility int visibility){
        View view = fdView(id);
        if (view != null)
            view.setVisibility(visibility);
        return (D)this;
    }

    public D setSelected(@IdRes int id,boolean selected){
        View view = fdView(id);
        if (view != null)
            view.setSelected(selected);
        return (D)this;
    }

    public D setClickable(@IdRes int id,boolean clickable){
        View view = fdView(id);
        if (view != null)
            view.setClickable(clickable);
        return (D)this;
    }

}
