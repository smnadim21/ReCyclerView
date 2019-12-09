package com.smnadim21.bdarchilogy.advert;

import android.app.Application;
import android.content.Context;

public class AppConfig extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();

        context =  getApplicationContext();

    }


    public static Context getContext(){
        return context;
    }



}
