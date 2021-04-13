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
public class DialogViewHolder{

    private View dialogView;
    private SparseArray<View> sparseArray;

    public DialogViewHolder(View dialogView) {
        this.dialogView = dialogView;
        this.sparseArray = new SparseArray();
    }

    /**
     * 查找控件
     * @param id
     * @return
     */
    public  View fdView(@IdRes int id){
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
    public DialogViewHolder setEnable(@IdRes int id,boolean enable){
        View view = fdView(id);
        if (null != view)
            view.setEnabled(enable);
        return this;
    }


    /**
     * 设置是否隐藏
     * @param id
     * @param visibility
     * @return
     */
    public DialogViewHolder setVisibility(@IdRes int id,@DialogType.Visibility int visibility){
        View view = fdView(id);
        if (null != view)
            view.setVisibility(visibility);
        return this;
    }

    /**
     * 设置是否选中
     * @param id
     * @param selected
     * @return
     */
    public DialogViewHolder setSelected(@IdRes int id,boolean selected){
        View view = fdView(id);
        if (null != view)
            view.setSelected(selected);
        return this;
    }

    /**
     * 设置能否点击
     * @param id
     * @param clickable
     * @return
     */
    public DialogViewHolder setClickable(@IdRes int id,boolean clickable){
        View view = fdView(id);
        if (null != view)
            view.setClickable(clickable);
        return this;
    }


    /**
     * 设置点击事件
     * @param id
     * @return
     */
    public DialogViewHolder seClickListener(View.OnClickListener onClickListener, @IdRes int ...id){
        if (null !=  onClickListener){
            if (id.length > 0){
                for (int i = 0; i < id.length; i++) {
                    View view = fdView(id[i]);
                    if (null != view){
                        view.setOnClickListener(onClickListener);
                    }
                }
            }
        }
        return this;
    }


    /**
     * 设置背景
     * @param id
     * @param resid
     * @return
     */
    public DialogViewHolder setBackgroundResource(@IdRes int id,@DrawableRes int resid){
        View view = fdView(id);
        if (null != view)
            view.setBackgroundResource(resid);
        return this;
    }

    public DialogViewHolder setBackground(@IdRes int id, Drawable drawable){
        if (null != drawable){
            View view = fdView(id);
            if (null != view)
                view.setBackground(drawable);
        }
        return this;
    }

    public DialogViewHolder setBackgroundColor(@IdRes int id, int color){
        View view = fdView(id);
        if (null != view)
            view.setBackgroundColor(color);
        return this;
    }


    public DialogViewHolder setText(@IdRes int id,String content){
        View view = fdView(id);
        if (null != view && view instanceof TextView){
            ((TextView) view).setText(content);
        }
        return this;
    }

    /**
     * 采用glide加载图片
     * @param id
     * @param object
     * @return
     */
    public DialogViewHolder setImageGlide(@IdRes int id,int loadImg,int  errorImg,Object object){
        if (null != object){
            View view = fdView(id);
            if (null != view   && view instanceof ImageView){
                if (loadImg!=0 || errorImg!=0){
                    RequestOptions requestOptions = new RequestOptions();
                    if (loadImg!=0)
                        requestOptions.error(errorImg);
                    if (errorImg!=0)
                        requestOptions.placeholder(loadImg);
                    Glide.with(view.getContext()).applyDefaultRequestOptions(requestOptions).load(object).into(((ImageView) view));
                }else{
                    Glide.with(view.getContext()).load(object).into(((ImageView) view));
                }
            }
        }
        return this;
    }


    public DialogViewHolder setImageGlide(@IdRes int id,Object object){
        return setImageGlide(id,0,0,object);
    }


    /**
     * 这个是使用Androidx包的方法
     * @param id
     * @param adapter
     * @param layoutManager
     * @return
     */
    public DialogViewHolder setRecyclerAndroidX(@IdRes int id, RecyclerView.Adapter adapter, RecyclerView.LayoutManager layoutManager){
        if (null != adapter && null != layoutManager){
            View view = fdView(id);
            if (null != view && view instanceof RecyclerView){
                RecyclerView recyclerView = (RecyclerView)view;
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        }
        return this;
    }


    public DialogViewHolder setRadioCheckListener(@IdRes int id, RadioGroup.OnCheckedChangeListener checkedChangeListener){
        View view = fdView(id);
        if (null != view && view instanceof RadioGroup){
            ((RadioGroup) view).setOnCheckedChangeListener(checkedChangeListener);
        }
        return this;
    }

}
