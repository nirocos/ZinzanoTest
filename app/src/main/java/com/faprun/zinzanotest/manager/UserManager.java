package com.faprun.zinzanotest.manager;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 12/8/2559.
 */
public class UserManager extends SQLiteOpenHelper {

    public static  String TAG = UserManager.class.getSimpleName();
    private SQLiteDatabase mDatabase;

    public UserManager(Context context) {
        super(context, "ZinsanoDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public User checkUserLogin(User user) {
        return null;
    }

}
