package alhdo.xyz.ifiedt;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    public static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static App getInstance(){
        return mInstance;

    }

    public static Context getAppContext(){
        return mInstance;
    }
}
