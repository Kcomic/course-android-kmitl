package kmitl.lab03.bawonsak58070074.simplemydot;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import kmitl.lab03.bawonsak58070074.simplemydot.model.Colors;
import kmitl.lab03.bawonsak58070074.simplemydot.model.Dot;
import kmitl.lab03.bawonsak58070074.simplemydot.model.Dots;
import kmitl.lab03.bawonsak58070074.simplemydot.view.DotView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements Dots.OnDotsChangeListener, DotView.OnDotViewPressListener, EditDotFragment.EditDotFragmentListener {

    private File imagePath;

    private Bitmap bitmap;

    private DotView dotView;
    private Dots dots;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dots = new Dots();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        dotView = (DotView) rootView.findViewById(R.id.dotView);
        dotView.setOnDotViewPressListener(this);

        dots.setListener(this);

        Button random_btn = (Button) rootView.findViewById(R.id.random_btn);
        Button share_btn = (Button) rootView.findViewById(R.id.share_btn);
        Button remove_btn = (Button) rootView.findViewById(R.id.remove_btn);
        random_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomDot();
            }
        });
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    share();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        remove_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dots.clearAll();
            }
        });
        return rootView;
    }



    public void randomDot() {
        Random random = new Random();
        int centerX = random.nextInt(dotView.getWidth());
        int centerY = random.nextInt(dotView.getHeight());
        Dot newDot = new Dot(centerX, centerY, 50, new Colors().randomColor());
        dots.addDot(newDot);
    }

    @Override
    public void onDotsChanged(Dots dots) {
        dotView.setDots(dots);
        dotView.invalidate();
    }


    @Override
    public void onDotViewPressed(float x, float y) {
        int dotPosition = dots.findDot(x, y);
        if(dotPosition == -1) {
            Dot newDot = new Dot(x, y, 50, new Colors().randomColor());
            dots.addDot(newDot);
        } else {
            dots.removeBy(dotPosition);
        }
    }

    @Override
    public void onDotViewLongPressed(float x, float y) {
        int position = dots.findDot(x, y);
        if (position == -1) {
            Dot dot = new Dot(x, y, 50, new Colors().getColor());
            dots.addDot(dot);
        } else {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, new EditDotFragment().newInstance(dots.getAllDot().get(position), position, MainFragment.this))
                    .addToBackStack("simpleMyDotFragment")
                    .commit();
        }
    }

    public void share() throws IOException {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        try {
            final String imgFile = Environment.getExternalStorageDirectory().toString() + "/scr.png";
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(getActivity());
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

                    View rootView = getActivity().getWindow().getDecorView().getRootView();
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


    @Override
    public void EditDotFinished(Dot dot, int position) {
        if(position != -1) {
            dots.getAllDot().set(position, dot);
            dotView.invalidate();
        }
    }
}
