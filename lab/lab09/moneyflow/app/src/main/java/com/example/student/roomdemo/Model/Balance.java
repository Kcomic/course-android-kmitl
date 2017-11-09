package com.example.student.roomdemo.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

/**
 * Created by Kcomic on 9/11/2560.
 */
@Entity(tableName = "Balance")
public class Balance {

    @ColumnInfo(name = "income")
    private int income;

    @ColumnInfo(name = "payment")
    private int payment;

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getBalance(){
        return income-payment;
    }
}
