package com.rdx64.chapter13;

import android.app.Application;
import android.content.Context;

/**
 * Created by RDX64 on 2017/6/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    private static Context context;
}
