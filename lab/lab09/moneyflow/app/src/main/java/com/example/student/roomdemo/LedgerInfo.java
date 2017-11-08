package com.example.student.roomdemo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by student on 11/3/2017 AD.
 */

@Entity(tableName = "LEDGER_INFO")
class LedgerInfo {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "lEDGER_LIST")
    private String ledgerList;

    @ColumnInfo(name = "VALUES")
    private int values;

    @ColumnInfo(name = "TYPE")
    private String type;

    @Override
    public String toString() {
        return String.format("%s : %s : %s", ledgerList, values, type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLedgerList() {
        return ledgerList;
    }

    public void setLedgerList(String ledgerList) {
        this.ledgerList = ledgerList;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
