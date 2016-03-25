package com.example.danny.aa;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView ivPicture;  //操作的动画
    private Button btClick;//点击开始

    private int picWidth;//图片宽度
    private int picHeight;//图片高度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPicture = (ImageView) findViewById(R.id.imageview);
        ViewTreeObserver observer =  ivPicture.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                picWidth = ivPicture.getWidth();
                picHeight = ivPicture.getHeight();
            }
        });

        btClick = (Button) findViewById(R.id.click);
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(ivPicture, "rotation", 0, 30, -30, 15, -15, 5, -5, 0);
                ivPicture.setPivotX(picWidth / 2);
                ivPicture.setPivotY(picHeight / 5);
                animator.setDuration(3000);
                animator.start();
            }
        });

    }
}
