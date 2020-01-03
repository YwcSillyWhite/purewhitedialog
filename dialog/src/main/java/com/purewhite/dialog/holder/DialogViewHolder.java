package com.purewhite.dialog.holder;

import android.util.SparseArray;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;

import com.purewhite.dialog.type.DialogType;

/**
 * 控制注释
 */
public class DialogViewHolder<D extends DialogViewHolder>{
    private View dialogView;
    private SparseArray<View> sparseArray;
    private View.OnClickListener onClickListener;
    public DialogViewHolder(View dialogView,View.OnClickListener onClickListener) {
        this.dialogView = dialogView;
        this.onClickListener=onClickListener;
        this.sparseArray = new SparseArray();
    }

    /**
     * 查找控件
     * @param id
     * @return
     */
    public  View obtainView(@IdRes int id){
        View view = sparseArray.get(id);
        if (view == null){
            view = dialogView.findViewById(id);
            sparseArray.put(id,view);
        }
        return view;
    }


    /**
     * 是否能运行
     * @param id
     * @param enable
     * @return
     */
    public D setEnable(@IdRes int id,boolean enable){
        View view = obtainView(id);
        if (view != null)
            view.setEnabled(enable);
        return ((D) this);
    }

    /**
     * 设置是否隐藏
     * @param id
     * @param visibility
     * @return
     */
    public D setVisibility(@IdRes int id,@DialogType.Visibility int visibility){
        View view = obtainView(id);
        if (view != null)
            view.setVisibility(visibility);
        return ((D) this);
    }

    /**
     * 设置是否选中
     * @param id
     * @param selected
     * @return
     */
    public D setSelected(@IdRes int id,boolean selected){
        View view = obtainView(id);
        if (view != null)
            view.setSelected(selected);
        return ((D) this);
    }

    /**
     * 设置能否点击
     * @param id
     * @param clickable
     * @return
     */
    public D setClickable(@IdRes int id,boolean clickable){
        View view = obtainView(id);
        if (view != null)
            view.setClickable(clickable);
        return ((D) this);
    }

    /**
     * 设置点击事件
     * @param id
     * @return
     */
    public D setClicks(@IdRes int ...id){
        if (id.length > 0){
            for (int i = 0; i < id.length; i++) {
                setClick(id[i]);
            }
        }
        return ((D) this);
    }

    public D setClick(@IdRes int id){
        if (onClickListener != null){
            View view = obtainView(id);
            if (view != null)
                view.setOnClickListener(onClickListener);
        }
        return ((D) this);
    }



    public D setText(@IdRes int id,String content){
        View view = obtainView(id);
        if (view != null && view instanceof TextView){
            ((TextView) view).setText(content);
        }
        return ((D) this);
    }

    public D setRecycler(@IdRes int id, RecyclerView.Adapter adapter, RecyclerView.LayoutManager layoutManager){
        if (adapter == null || layoutManager==null)
            return (D)this;
        View view = obtainView(id);
        if (view != null && view instanceof RecyclerView){
            RecyclerView recyclerView = (RecyclerView)view;
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
        return (D)this;
    }

    public D setRadioCheckListener(@IdRes int id, RadioGroup.OnCheckedChangeListener checkedChangeListener){
        View view = obtainView(id);
        if (view != null && view instanceof RadioGroup){
            ((RadioGroup) view).setOnCheckedChangeListener(checkedChangeListener);
        }
        return ((D) this);
    }







}
