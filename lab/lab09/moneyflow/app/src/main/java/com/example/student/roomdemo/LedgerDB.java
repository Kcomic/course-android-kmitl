package com.example.student.roomdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by student on 11/3/2017 AD.
 */
@Database(entities = { LedgerInfo.class }, version = 1)
public abstract class LedgerDB extends RoomDatabase {
    public abstract LedgerInfoDAO getLedgerInfoDAO();

}
