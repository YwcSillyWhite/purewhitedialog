package com.purewhile.purewhiledialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.purewhile.dialog.DialogUtils;
import com.purewhile.dialog.anim.DialogAnimStyle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.one:
                DialogUtils.build().setLayoutId(R.layout.dialog_one)
                        .setDialogAnim(DialogAnimStyle.bottom_anim)
                        .setSplace(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT,0,0, Gravity.CENTER)
                        .buildDialog(this).show();
                break;
        }
    }
}
