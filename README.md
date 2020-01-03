# purewhitedialog
纯白dialog


### 引入纯白dialog

Add it in your root build.gradle at the end of repositories:
```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```java

	dependencies {
	        implementation 'com.github.YwcSillyWhite:purewhitedialog:V1.0.0'
	}

```

### 使用纯白dialog
```java
 DialogUtils dialogUtils = DialogUtils.build().setLayoutId(R.layout.dialog_one) //设置布局
                .setCanceled()    //点击返回键是否取消 默认是true（可以点击取消）
                .setCanceledOnTouchOutside()//点击dialog外部是否取消 默认是true（可以点击取消）
                .setDialogAnim(DialogAnimStyle.top_anim) //dialog动画 框架里面提供了4种
                .setOnDismissListener() //取消监听
                .setOnKeyListener() //键盘处理监听
                .setSplace(0, 0, 0, 0, Gravity.BOTTOM)  //dialog位置 宽,高，x移动，y移动 ，位置
                .setThemeRes() //dialogtheme
                .setOnClickListener() //dialog的子view点击事件
                .buildDialog(this);//构建完成 buildBottomSheetDialog使用这个而必须导入包才能使用
        dialogUtils.setImageGlide() //设置布局内容
           .show(); //显示
        dialogUtils.obtainView() //获取控件
        dialogUtils.obtainDialog() //获取dialog
        DialogHelper.dismiss(dialogUtils); //隐藏dialog
        DialogHelper.show(dialogUtils); //显示dialog
```
### 注意事项
```java
1.要使用buildBottomSheetDialog必须导入androidx包下material包
2.要使用setRecyclerAndroidX必须导入androidx包下material包
3.要使用setImageGlide必须到导入glide
```

