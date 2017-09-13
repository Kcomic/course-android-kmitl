package kmitl.lab03.bawonsak58070074.simplemydot;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.facebook.FacebookSdk;
import com.facebook.share.widget.ShareButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import kmitl.lab03.bawonsak58070074.simplemydot.model.Dot;
import kmitl.lab03.bawonsak58070074.simplemydot.view.DotView;

public class MainActivity extends AppCompatActivity implements Dot.DotChangedListener {

    private Dot dot;
    private DotView dotView;
    // share button
    private ShareButton shareButton;
    //image
    //counter
    private int counter = 0;

    private File imagePath;

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        dotView = (DotView) findViewById(R.id.dot);
        dotView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Random random = new Random();
                        int r = random.nextInt(255);
                        int g = random.nextInt(255);
                        int b = random.nextInt(255);
                        dot = new Dot((int)event.getX(), (int)event.getY(), 0, MainActivity.this);
                        dot.setPaint(r, g, b);
                }
                return true;
            }
        });
    }

    public void onShare(View view) throws IOException {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        try {
            final String imgFile = Environment.getExternalStorageDirectory().toString() + "/scr.png";
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Share Screenshot or Dot only");
            builder.setPositiveButton("DOT ONLY", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                    dotView.setDrawingCacheEnabled(true);
                    bitmap = Bitmap.createBitmap(dotView.getDrawingCache());
                    dotView.setDrawingCacheEnabled(false);
                    SaveAndShare(imgFile);

                }
            });
            builder.setNegativeButton("SCREENSHOT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    View rootView = getWindow().getDecorView().getRootView();
                    rootView.setDrawingCacheEnabled(true);
                    bitmap = Bitmap.createBitmap(rootView.getDrawingCache());
                    rootView.setDrawingCacheEnabled(false);
                    SaveAndShare(imgFile);
                }
            });
            builder.show();


    } catch(Exception e){}

    }

public void SaveAndShare(String imgFile){
    try {
        File imageFile = new File(imgFile);
        FileOutputStream outputStream = new FileOutputStream(imageFile);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        outputStream.flush();
        outputStream.close();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/png");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(imageFile));
        startActivity(Intent.createChooser(intent, "Share to"));
    } catch(FileNotFoundException e){} catch (IOException e) {}
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
    public void onDotChanged(Dot dot) {
        dotView.setDot(dot);
        dotView.invalidate();
    }

    public void onRemove(View view) {
        dotView.removeDot();
        dotView.invalidate();
    }
}

