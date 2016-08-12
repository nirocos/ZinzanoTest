package com.faprun.zinzanotest.realm;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Admin on 11/8/2559.
 */
public class UserRealm extends RealmObject {

    @PrimaryKey
    private String userSN;


    @Required

    private String userName;



    public String getUserSN() {
        return userSN;
    }

    public void setUserSN(String userSN) {
        this.userSN = userSN;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



}
