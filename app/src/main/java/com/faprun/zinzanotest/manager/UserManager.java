package com.faprun.zinzanotest.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Admin on 12/8/2559.
 */
public class UserManager extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private static String DB_NAMES = "ZinsanoDB";
    private static int DB_VERSION = 1;
    public static String TABLE_NAME = "user";
    public static String USER_SN = "userSN";
    public static String USER_NAME = "userName";

    public UserManager(Context context) {
        super(context, DB_NAMES, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT,userSN TEXT NOT NULL," +
                "userName TEXT NOT NULL);");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + USER_SN + "," + USER_NAME + ")" +
                "VALUES('SN001','Phongchayuth');");
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + USER_SN + "," + USER_NAME + ")" +
                "VALUES('SN002','Thanaphat');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertUser(String userSN, String userName) {
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + USER_SN + "," + USER_NAME + ")" +
                            "VALUES('" + userSN + "','" + userName + "');");
    }
    public void deleteUser(int i){
        db = this.getReadableDatabase();
        String query = "DELETE from " + TABLE_NAME +" WHERE id ="+"'"+i+"'";
        db.execSQL(query);
    }
    public String checkLogin(String text){
        db = this.getReadableDatabase();
        String query = "SELECT userSN, userName from " + TABLE_NAME ;
        Cursor cursor = db.rawQuery(query,null);
        String a,result;
        result =  "not found";

        if(cursor.moveToFirst()){
            do {
                a = cursor.getString(0);
                if(a.equals(text)){
                    result = "found";
                    break;
                }
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return result;
    }
    public String getUsername(String text){
        db = this.getReadableDatabase();
        String query = "SELECT userName from "+TABLE_NAME + " WHERE userSN =" + "'"+text+"'";
        Cursor cursor = db.rawQuery(query,null);
        String userName;
        userName = "not found";
        if(cursor.moveToFirst()){
            userName = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return userName;
    }


}
