package com.purewhite.purewhitedialog;



import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.purewhite.dialog.DialogUtils;
import com.purewhite.dialog.anim.DialogAnimStyle;
import com.purewhite.dialog.holder.DialogViewHolder;
import com.purewhite.dialog.io.DialogIo;

public class MainActivity extends AppCompatActivity {

    private DialogUtils dialogUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.one:
                dialogUtils = DialogUtils.build().setLayoutId(R.layout.dialog_one)
                        .setDialogAnim(DialogAnimStyle.bottom_anim)
                        .setSplace(0, 0, Gravity.CENTER)
                        .setDialogIo(new DialogIo() {
                            @Override
                            public void initView(DialogViewHolder dialogViewHolder) {
                                //数据初始化
                            }
                        })
                        .buildDialog(this);
                //buildDialog 完可以在用这个复制
                DialogViewHolder dialogViewHolder = dialogUtils.getDialogViewHolder();
                dialogUtils.show();


                break;
        }
    }
}
