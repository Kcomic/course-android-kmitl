package com.example.student.roomdemo.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.student.roomdemo.Model.LedgerInfo;

/**
 * Created by student on 11/3/2017 AD.
 */
@Database(entities = { LedgerInfo.class }, version = 1)
public abstract class LedgerDB extends RoomDatabase {
    public abstract LedgerInfoDAO getLedgerInfoDAO();

}
