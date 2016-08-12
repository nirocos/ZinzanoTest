package com.faprun.zinzanotest.manager;

import android.provider.BaseColumns;

/**
 * Created by Admin on 12/8/2559.
 */
public class User {

    public static  String TABLE  = "user";

    public class Column{
        public String ID = BaseColumns._ID;
        public String userName = "userName";
        public String userSN = "userSN";
    }

    private int id ;


    private String userName;
    private String userSN;

    public User(String userName,String userSN){
        this.userName = userName;
        this.userSN = userSN;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSN() {
        return userSN;
    }

    public void setUserSN(String userSN) {
        this.userSN = userSN;
    }



}
