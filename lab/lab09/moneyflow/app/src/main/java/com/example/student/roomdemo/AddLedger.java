package com.example.student.roomdemo;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class AddLedger extends AppCompatActivity implements View.OnClickListener {
    private LedgerDB LedgerDB;
    private Button okBtn;
    private TextView income, payment;
    private int chk = 0;
    private EditText text, value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        okBtn = findViewById(R.id.okBtn);
        income = findViewById(R.id.income);
        payment = findViewById(R.id.payment);
        text = findViewById(R.id.editText);
        value = findViewById(R.id.editText2);
        okBtn.setOnClickListener(this);
        income.setOnClickListener(this);
        payment.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (R.id.okBtn == view.getId()) {
            LedgerDB = Room.databaseBuilder(getApplicationContext(),
                    LedgerDB.class, "LEDGER")
                    .build();
            final String text = this.text.getText().toString();
            final int value = Integer.valueOf(this.value.getText().toString());
            new AsyncTask<Void, Void, LedgerInfo>(){

                @Override
                protected LedgerInfo doInBackground(Void... voids) {
                    LedgerInfo ledgerInfo = new LedgerInfo();
                    ledgerInfo.setLedgerList(text);
                    ledgerInfo.setValues(value);
                    if(chk == 0) ledgerInfo.setType("true");
                    else ledgerInfo.setType("false");
                    LedgerDB.getLedgerInfoDAO().insert(ledgerInfo);
                    return null;
                }
            }.execute();

            finish();
        } else if (R.id.income == view.getId()) {
            chk = 0;
            income.setBackgroundColor(Color.parseColor("#6699FF"));
            payment.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            chk = 1;
            payment.setBackgroundColor(Color.parseColor("#6699FF"));
            income.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }
}
