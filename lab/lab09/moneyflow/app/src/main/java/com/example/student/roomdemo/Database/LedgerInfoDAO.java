package com.example.student.roomdemo.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.student.roomdemo.Model.Balance;
import com.example.student.roomdemo.Model.LedgerInfo;

import java.util.List;

/**
 * Created by student on 11/3/2017 AD.
 */

@Dao
public interface LedgerInfoDAO {

    @Insert
    void insert(LedgerInfo ledgerInfo);

    @Delete
    void delete(LedgerInfo ledgerInfo);

    @Update
    void update(LedgerInfo ledgerInfo);

    @Query("SELECT * FROM LEDGER_INFO")
    List<LedgerInfo> findAll();


    @Query("Select income, payment from (select sum(AMOUNT) as income from LEDGER_INFO where TYPE = '+') join (SELECT sum(AMOUNT) AS payment FROM LEDGER_INFO WHERE TYPE = '-')")
    Balance findBalance();

}
