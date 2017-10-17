package kmitl.lab07.bawonsak58070074.lazyinstagram;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kmitl.lab07.bawonsak58070074.lazyinstagram.Adapter.LazyInstagramAdapter;
import kmitl.lab07.bawonsak58070074.lazyinstagram.Adapter.PostAdapter;
import kmitl.lab07.bawonsak58070074.lazyinstagram.Api.LazyInstagramApi;
import kmitl.lab07.bawonsak58070074.lazyinstagram.Model.UserProfile;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    public OkHttpClient client;
    public Retrofit retrofit;
    public LazyInstagramApi lazyInstagramApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getConnection();
        getContentByName("cartoon");


    }
    public void getConnection(){
        client = new OkHttpClient.Builder().build();
        retrofit = new Retrofit
                .Builder()
                .baseUrl(LazyInstagramApi.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        lazyInstagramApi = retrofit.create(LazyInstagramApi.class);
    }

    private void getContentByName(String userName){
        Call<UserProfile> call = lazyInstagramApi.getProfile(userName);
        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                if (response.isSuccessful()){
                    UserProfile userProfile = response.body();
                    display(userProfile);
                }
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {
                System.out.println("Connect API FAILED");
            }
        });
    }
    private void display(UserProfile userProfile){
        List<Layout> layouts = new ArrayList<>();
        layouts.add(new Layout(Layout.TYPE_USER_DETAIL));
        layouts.add(new Layout(Layout.TYPE_POST_ITEM));

        LazyInstagramAdapter lazyInstagramAdapter = new LazyInstagramAdapter(this, layouts);
        lazyInstagramAdapter.setUserProfile(userProfile);
        RecyclerView recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(lazyInstagramAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.changeUser){
            selectUser();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectUser(){
        final String[] user = {"cartoon", "nature", "android"};

        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select Account");
        builder.setItems(user, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selected = user[which];
                getContentByName(selected);
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.create();
        builder.show();
    }

    public void onFollow(View view) {
        Button followBtn = findViewById(R.id.follow);
        if(String.valueOf(followBtn.getText()).equals("FOLLOW")) followBtn.setText("FOLLOWING");
        else followBtn.setText("FOLLOW");
    }
}
