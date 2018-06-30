package com.example.anjali.notes;

import android.content.Context;
import android.content.SharedPreferences;


public class Database {
    Context context;
    SharedPreferences sharedpref;
    private static String username="username";
    private static String passwrd="password";
    private static String isLogin="IsLogin";
    Database(Context context)
    {
        this.context=context;
        sharedpref=context.getSharedPreferences("pref",context.MODE_PRIVATE);
    }
    void createUser(String user,String password)
    {
        sharedpref.edit().putString(username,user).apply();
        sharedpref.edit().putString(passwrd,password).apply();
        sharedpref.edit().putBoolean(isLogin,true).apply();
    }
    boolean isLogin()
    {
        return sharedpref.getBoolean(isLogin,false);
    }
    void LogOut()
    {
        sharedpref.edit().putBoolean(isLogin,false).apply();
    }
    String getuser()
    {
        return sharedpref.getString(username,"");
    }
}
