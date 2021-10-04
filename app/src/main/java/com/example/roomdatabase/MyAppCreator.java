package com.example.roomdatabase;

import android.app.Application;
import android.content.Context;


public class MyAppCreator extends Application {

    static MyAppCreator mInstance;
    static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mContext = getApplicationContext();
    }

    public static MyAppCreator getAppCreatorInstance(){
        return new MyAppCreator();
    }

    public static DBRepo getRepoInstance(){
        return new DBRepo(getAppCreatorInstance(),mContext);
    }
}

