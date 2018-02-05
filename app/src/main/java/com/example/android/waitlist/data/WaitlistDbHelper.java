package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kylesmith on 2/5/18.
 */

public class WaitlistDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "waitlist.db";
    private static final int DATABASE_VERSION = 1;

    public WaitlistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE" +
                WaitlistContract.WaitListEntry.TABLE_NAME + " (" +
                WaitlistContract.WaitListEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WaitlistContract.WaitListEntry.COLUMN_GUEST_NAME + " TEXT NOT NULL, " +
                WaitlistContract.WaitListEntry.COLUMN_PARTY_SIZE + " INTEGER NOT NULL," +
                WaitlistContract.WaitListEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        final String SQL_DROP_WAITLIST_TABLE = "DROP TABLE IF EXISTS " +
                WaitlistContract.WaitListEntry.TABLE_NAME;

        sqLiteDatabase.execSQL(SQL_DROP_WAITLIST_TABLE);
        onCreate(sqLiteDatabase);
    }
}
