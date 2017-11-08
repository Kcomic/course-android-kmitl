package com.example.student.roomdemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by student on 11/3/2017 AD.
 */

@Dao
interface LedgerInfoDAO {

    @Insert
    void insert(LedgerInfo message);

    @Query("SELECT * FROM LEDGER_INFO")
    List<LedgerInfo> findAll();

    @Query("DELETE FROM LEDGER_INFO")
    void deleteAll();

    @Query("SELECT sum(VALUES) FROM LEDGER_INFO WHERE TYPE = 'true'")
    List<LedgerInfo> findIncome();

    @Query("SELECT sum(VALUES) FROM LEDGER_INFO WHERE TYPE = 'false'")
    List<LedgerInfo> findPayment();

}
