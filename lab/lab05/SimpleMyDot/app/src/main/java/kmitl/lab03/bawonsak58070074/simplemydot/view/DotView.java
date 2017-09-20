package kmitl.lab03.bawonsak58070074.simplemydot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import kmitl.lab03.bawonsak58070074.simplemydot.model.Dot;
import kmitl.lab03.bawonsak58070074.simplemydot.model.Dots;


public class DotView extends View {
    private Paint paint;
    private Dots allDot;
    private GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            DotView.this.onDotViewPressListener.onDotViewPressed((float) e.getX(), (float) e.getY());
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            DotView.this.onDotViewPressListener.onDotViewLongPressed((float) e.getX(), (float) e.getY());
        }

    });

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(this.allDot != null) {
            for (Dot dot: allDot.getAllDot()) {
                paint.setColor(dot.getColor());
                canvas.drawCircle(
                        dot.getCenterX(),
                        dot.getCenterY(), 50, paint);
            }
        }
    }

    public interface OnDotViewPressListener{
        void onDotViewPressed(float x, float y);
        void onDotViewLongPressed(float x, float y);
    }

    private OnDotViewPressListener onDotViewPressListener;

    public void setOnDotViewPressListener(
            OnDotViewPressListener onDotViewPressListener) {
        this.onDotViewPressListener = onDotViewPressListener;
    }


    public DotView(Context context) {
        super(context);
        paint = new Paint();
    }

    public DotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public DotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }


    public void setDots(Dots dots) {
        this.allDot = dots;
    }


}

