package com.purewhite.dialog.holder;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
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
        if (null == view){
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
        if (null != view)
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
        if (null != view)
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
        if (null != view)
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
        if (null != view)
            view.setClickable(clickable);
        return ((D) this);
    }

    /**
     * 设置点击事件
     * @param id
     * @return
     */
    public D setClicks(@IdRes int ...id){
        if (null !=  onClickListener){
            if (id.length > 0){
                for (int i = 0; i < id.length; i++) {
                    setClick(id[i]);
                }
            }
        }
        return ((D) this);
    }

    public D setClick(@IdRes int id){
        if (null != onClickListener){
            View view = obtainView(id);
            if (null != view)
                view.setOnClickListener(onClickListener);
        }
        return ((D) this);
    }

    public D setBackgroundResource(@IdRes int id,@DrawableRes int resid){
        View view = obtainView(id);
        if (null != view)
            view.setBackgroundResource(resid);
        return ((D) this);
    }

    public D setBackground(@IdRes int id, Drawable drawable){
        if (null != drawable){
            View view = obtainView(id);
            if (null != view)
                view.setBackground(drawable);
        }
        return ((D) this);
    }

    public D setBackgroundColor(@IdRes int id, int color){
        View view = obtainView(id);
        if (null != view)
            view.setBackgroundColor(color);
        return ((D) this);
    }

    public D setText(@IdRes int id,String content){
        View view = obtainView(id);
        if (null != view && view instanceof TextView){
            ((TextView) view).setText(content);
        }
        return ((D) this);
    }

    /**
     * 采用glide加载图片
     * @param id
     * @param object
     * @return
     */
    public D setImageGlide(@IdRes int id,int loadImg,int  errorImg,Object object){
        if (null != object){
            View view = obtainView(id);
            if (null != view   && view instanceof ImageView){
                if (loadImg!=0 || errorImg!=0){
                    RequestOptions requestOptions = new RequestOptions();
                    if (loadImg!=0)
                        requestOptions.error(errorImg);
                    if (errorImg!=0)
                        requestOptions.placeholder(loadImg);
                    Glide.with(view).applyDefaultRequestOptions(requestOptions).load(object);
                }else{
                    Glide.with(view).load(object);
                }
            }
        }
        return ((D) this);
    }


    public D setImageGlide(@IdRes int id,Object object){
        return setImageGlide(id,0,0,object);
    }

    /**
     * 这个是使用Androidx包的方法
     * @param id
     * @param adapter
     * @param layoutManager
     * @return
     */
    public D setRecyclerAndroidX(@IdRes int id, RecyclerView.Adapter adapter, RecyclerView.LayoutManager layoutManager){
        if (null != adapter && null != layoutManager){
            View view = obtainView(id);
            if (null != view && view instanceof RecyclerView){
                RecyclerView recyclerView = (RecyclerView)view;
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        }
        return (D)this;
    }


    public D setRadioCheckListener(@IdRes int id, RadioGroup.OnCheckedChangeListener checkedChangeListener){
        View view = obtainView(id);
        if (null != view && view instanceof RadioGroup){
            ((RadioGroup) view).setOnCheckedChangeListener(checkedChangeListener);
        }
        return ((D) this);
    }


}
