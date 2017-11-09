package com.example.student.roomdemo;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.student.roomdemo.Adapter.LedgerInfoAdapter;
import com.example.student.roomdemo.Database.LedgerDB;
import com.example.student.roomdemo.Model.Balance;
import com.example.student.roomdemo.Model.LedgerInfo;

import java.text.NumberFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LedgerInfoAdapter.LedgerInfoAdapterListener {

    private LedgerDB LedgerDB;
    private LedgerInfoAdapter ledgerInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.ledgerList);
        LedgerDB = Room.databaseBuilder(getApplicationContext(),
                com.example.student.roomdemo.Database.LedgerDB.class, "LEDGER")
                .build();
        ledgerInfoAdapter = new LedgerInfoAdapter(this, this);
        recyclerView.setAdapter(ledgerInfoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new AsyncTask<Void, Void, List<LedgerInfo>>(){

            @Override
            protected List<LedgerInfo> doInBackground(Void... voids) {
                List<LedgerInfo> result = LedgerDB.getLedgerInfoDAO().findAll();
                return result;
            }

            @Override
            protected void onPostExecute(List<LedgerInfo> LedgerInfos) {
                ledgerInfoAdapter.setLedgerInfoList(LedgerInfos);
                ledgerInfoAdapter.notifyDataSetChanged();
            }
        }.execute();

        new AsyncTask<Void, Void, Balance>(){

            @Override
            protected Balance doInBackground(Void... voids) {
                Balance result = LedgerDB.getLedgerInfoDAO().findBalance();

                return result;
            }

            @Override
            protected void onPostExecute(Balance balance) {
                TextView batv = findViewById(R.id.textView3);
                int amount = balance.getBalance();
                try {
                    float ratio = (float)amount / balance.getIncome();
                    if (ratio > 0.5) batv.setTextColor(Color.parseColor("#33FF00"));
                    else if (ratio >= 0.25) batv.setTextColor(Color.parseColor("#FF9900"));
                    else batv.setTextColor(Color.parseColor("#FF0000"));
                } catch(Exception e){
                    batv.setTextColor(Color.parseColor("#FF0000"));
                }
                batv.setText(NumberFormat.getNumberInstance().format(amount));
            }
        }.execute();

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, AddLedger.class);
        startActivity(intent);

//        new AsyncTask<Void, Void, List<LedgerInfo>>(){
//
//            @Override
//            protected List<LedgerInfo> doInBackground(Void... voids) {
//                LedgerDB.getLedgerInfoDAO().deleteAll();
//                return null;
//            }
//        }.execute();
    }

    @Override
    public void onItemTouched(final LedgerInfo ledgerInfo) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("ต้องการแก้ไข หรือลบออกจากรายการ?");
        builder.setPositiveButton("แก้ไข", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                startIntent(ledgerInfo);
            }
        });
        builder.setNegativeButton("ลบ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new AsyncTask<Void, Void, LedgerInfo>() {
                    @Override
                    protected LedgerInfo doInBackground(Void... voids) {
                        LedgerDB.getLedgerInfoDAO().delete(ledgerInfo);
                        finish();
                        startActivity(getIntent());
                        return null;
                    }
                }.execute();
            }
        });
        builder.show();
    }

    private void startIntent(LedgerInfo ledgerInfo){
        Intent intent = new Intent(this, AddLedger.class);
        intent.putExtra("ledgerInfo", ledgerInfo);
        finish();
        startActivity(intent);
    }

}
