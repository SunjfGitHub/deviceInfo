package com.kkxl.deviceinfo;

import android.app.Application;
import android.content.Context;

/**
 * Created by hello on 18-8-30.
 */

public class MainApplication extends Application  {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }
    static {
        System.loadLibrary("core+");
    }
}
