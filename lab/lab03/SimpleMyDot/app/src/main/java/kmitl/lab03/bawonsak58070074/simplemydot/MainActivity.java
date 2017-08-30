package kmitl.lab03.bawonsak58070074.simplemydot;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import kmitl.lab03.bawonsak58070074.simplemydot.model.Dot;
import kmitl.lab03.bawonsak58070074.simplemydot.view.DotView;

public class MainActivity extends AppCompatActivity implements Dot.DotChangedListener {

    private Dot dot;
    private DotView dotView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dotView = (DotView) findViewById(R.id.dot);

    }

    public void onRandomDot(View view) {
        dot = new Dot(0, 0, 0, this);
        Random random = new Random();
        int centerX = random.nextInt(dotView.getWidth());
        int centerY = random.nextInt(dotView.getHeight());
        this.dot.setCenterX(centerX);
        this.dot.setCenterY(centerY);
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        this.dot.setPaint(r, g, b);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                dot = new Dot(x-45, y-215, 0, this);
                Random random = new Random();
                int r = random.nextInt(255);
                int g = random.nextInt(255);
                int b = random.nextInt(255);
                this.dot.setPaint(r, g, b);
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onDotChanged(Dot dot) {
        dotView.setDot(dot);
        dotView.invalidate();
    }

    public void onRemove(View view) {
        dotView.removeDot();
        dotView.invalidate();
    }
}

