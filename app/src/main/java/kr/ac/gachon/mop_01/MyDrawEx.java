package kr.ac.gachon.mop_01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyDrawEx extends View {

    public MyDrawEx(Context context) {
        super(context);
    }

    public MyDrawEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawColor(Color.WHITE);
        for (int i = 0; i < 200; i++) {
            canvas.drawLine(i, 0, 200 - i, 100, paint);
        }
    }
}
