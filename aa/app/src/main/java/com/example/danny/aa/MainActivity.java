package com.example.danny.aa;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       final ImageView imageView = (ImageView) findViewById(R.id.imageview);

       ViewTreeObserver observer =  imageView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.i("lxm", "layout....");
                ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", 0, 30, -30, 15, -15, 5, -5, 0);
                imageView.setPivotX(imageView.getWidth() / 2);
                imageView.setPivotY(imageView.getHeight() / 5);
                animator.setDuration(3000);
                Ga
                animator.start();
            }
        });


    }
}
