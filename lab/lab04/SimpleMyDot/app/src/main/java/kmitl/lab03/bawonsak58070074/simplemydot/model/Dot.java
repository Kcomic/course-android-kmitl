package kmitl.lab03.bawonsak58070074.simplemydot.model;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.LinkedList;

public class Dot {

    private float centerX;
    private float centerY;
    private int radius;
    private DotChangedListener listener;
    private Paint paint = new Paint();

    public Dot(float centerX, float centerY, int radius, DotChangedListener listener) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.listener = listener;
        this.listener.onDotChanged(this);


    }

    public Dot(float centerX, float centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;

    }

    public void setPaint(int r, int g, int b){
        paint.setColor(Color.argb(255, r, g, b));
    }

    public Paint getPaint(){
        return paint;
    }

    public interface DotChangedListener{
        void onDotChanged(Dot dot);
    }

    public void setDotChangedListener(DotChangedListener listener){
        this.listener = listener;
    }


    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
        this.listener.onDotChanged(this);
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
        this.listener.onDotChanged(this);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
