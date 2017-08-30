package kmitl.lab03.bawonsak58070074.simplemydot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import kmitl.lab03.bawonsak58070074.simplemydot.model.Dot;


public class DotView extends View {
    private Paint paint;
    private Dot dot;
    private LinkedList<Dot> listDot;


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
            for(int i=0;i<listDot.size();i++) {
                canvas.drawCircle(listDot.get(i).getCenterX(), listDot.get(i).getCenterY(), 30, listDot.get(i).getPaint());
            }


    }


    public DotView(Context context) {
        super(context);
        paint = new Paint();
        listDot = new LinkedList<Dot>();
    }

    public DotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        listDot = new LinkedList<Dot>();
    }

    public DotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        listDot = new LinkedList<Dot>();
    }


    public void setDot(Dot dot) {
        listDot.add(dot);
    }

    public void removeDot() {
        listDot.clear();
    }


}

