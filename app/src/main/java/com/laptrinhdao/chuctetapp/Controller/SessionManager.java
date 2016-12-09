package com.laptrinhdao.chuctetapp.Controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class SessionManager {
    private static String TAG = SessionManager.class.getSimpleName();
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    private static final String NAME = "laptrinhdao.com";
    private static final String KEY_LOGIN = "isLoggedIn";

    public SessionManager(Context context){
        this.context = context;
        pref = context.getSharedPreferences(NAME,0);
        editor = pref.edit();
    }

    public void SaveLogin(boolean isLogin){
        editor.putBoolean(KEY_LOGIN,isLogin);
        editor.commit();
        Log.d(TAG,"Save Login To SharePrefences");
    }

    public boolean CheckLogin(){
        return pref.getBoolean(KEY_LOGIN, false);
    }

}
