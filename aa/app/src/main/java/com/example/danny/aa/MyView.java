package com.example.danny.aa;

import android.content.Context;
import android.graphics.AvoidXfermode;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelXorXfermode;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by danny on 2016/3/1.
 */
public class MyView extends View {

    private Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    Paint paint = new Paint();

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.figure).copy(Bitmap.Config.ARGB_8888, true);;

        Canvas canvas1 = new Canvas(bitmap);

        paint.setFilterBitmap(false);
        paint.setColor(Color.GREEN);
        paint.setXfermode(xfermode);

        canvas1.drawBitmap(aa(canvas),0,0,paint);
//        canvas1.drawBitmap(aa(canvas), 0, 0, paint);

////        canvas1.drawRect(0,bitmap.getHeight()*1/2,bitmap.getWidth(),bitmap.getHeight(),paint);
        paint.setXfermode(null);
        canvas.drawBitmap(bitmap,0,0,paint);
    }

    private Bitmap aa(Canvas canvas){
        Bitmap bitmap1 = Bitmap.createBitmap(150,50, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmap1);
        paint.setColor(Color.BLUE);
        canvas2.drawRect(0, 0, bitmap1.getWidth(), bitmap1.getHeight(), paint);

        return bitmap1;
    }
}
