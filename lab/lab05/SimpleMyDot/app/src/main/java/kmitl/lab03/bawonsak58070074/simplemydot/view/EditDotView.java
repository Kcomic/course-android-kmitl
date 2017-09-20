package kmitl.lab03.bawonsak58070074.simplemydot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by student on 9/21/2017 AD.
 */

public class EditDotView extends View {


    private Paint paint = null;
    private int color = Color.RED, radius = 0,
            currentX = 0, currentY = 0;

    public int getColor() {
        return color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        currentX = canvas.getWidth() / 2;
        currentY = canvas.getHeight() / 2;

        paint.setColor(color);
        canvas.drawCircle(currentX, currentY, radius, paint);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public EditDotView(Context context) {
        super(context);
        paint = new Paint();
    }

    public EditDotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public EditDotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }
}
