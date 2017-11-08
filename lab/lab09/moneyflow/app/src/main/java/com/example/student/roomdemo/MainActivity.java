package com.example.student.roomdemo;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LedgerDB LedgerDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LedgerDB = Room.databaseBuilder(getApplicationContext(),
                LedgerDB.class, "LEDGER")
                .build();

        new AsyncTask<Void, Void, List<LedgerInfo>>(){

            @Override
            protected List<LedgerInfo> doInBackground(Void... voids) {
                List<LedgerInfo> result = LedgerDB.getLedgerInfoDAO().findAll();
                return result;
            }

            @Override
            protected void onPostExecute(List<LedgerInfo> LedgerInfos) {
                ArrayAdapter<LedgerInfo> adaptor = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, LedgerInfos);
                ListView messageInfoList = findViewById(R.id.LedgerList);
                messageInfoList.setAdapter(adaptor);
            }
        }.execute();

        new AsyncTask<Void, Void, Integer>(){

            @Override
            protected Integer doInBackground(Void... voids) {
                List<LedgerInfo> result = LedgerDB.getLedgerInfoDAO().findIncome();
                result = LedgerDB.getLedgerInfoDAO().findPayment();
                return 1000;
            }

            @Override
            protected void onPostExecute(Integer balance) {
                TextView textView3 = findViewById(R.id.textView3);
                int income = ledgerInfos.get(0).getValues();
                int payment = ledgerInfos.get(0).getValues();
                int balance = income-payment;
                textView3.setText(balance+"");
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
}
