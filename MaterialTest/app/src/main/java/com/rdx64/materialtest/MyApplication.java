package com.rdx64.materialtest;

import android.app.Application;
import android.content.Context;

/**
 * Created by RDX64 on 2017/6/18.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
