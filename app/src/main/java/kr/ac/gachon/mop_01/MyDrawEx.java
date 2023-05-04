package kr.ac.gachon.mop_01;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;

public class MyDrawEx {
    private Paint paint;

    private Bitmap mAndroidGreen;
    private Bitmap mAndroidRed;
    private int nAngle=0;

    public void init(){
        paint=new Paint();

        Resources res=Resources.getSystem();
        mAndroidGreen= BitmapFactory.decodeResource(res,R.drawable.android_green);

    }

}
