package kmitl.lab03.bawonsak58070074.simplemydot;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
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

import kmitl.lab03.bawonsak58070074.simplemydot.model.Colors;
import kmitl.lab03.bawonsak58070074.simplemydot.model.Dot;
import kmitl.lab03.bawonsak58070074.simplemydot.model.Dots;
import kmitl.lab03.bawonsak58070074.simplemydot.view.DotView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialFragment();
    }



    private void initialFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, new MainFragment())
                .commit();
    }
}

