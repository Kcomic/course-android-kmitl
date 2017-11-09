package com.example.student.roomdemo.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by student on 11/3/2017 AD.
 */

@Entity(tableName = "LEDGER_INFO")
public class LedgerInfo implements Parcelable {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "lEDGER_LIST")
    private String ledgerList;

    @ColumnInfo(name = "AMOUNT")
    private int amount;

    @ColumnInfo(name = "TYPE")
    private String type;

    protected LedgerInfo(Parcel in) {
        id = in.readInt();
        type = in.readString();
        ledgerList = in.readString();
        amount = in.readInt();
    }

    public static final Creator<LedgerInfo> CREATOR = new Creator<LedgerInfo>() {
        @Override
        public LedgerInfo createFromParcel(Parcel in) {
            return new LedgerInfo(in);
        }

        @Override
        public LedgerInfo[] newArray(int size) {
            return new LedgerInfo[size];
        }
    };

    public LedgerInfo() {

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(type);
        dest.writeString(ledgerList);
        dest.writeInt(amount);
    }
}
