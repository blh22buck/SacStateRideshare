package com.rideshare;

import android.app.Application;

import com.parse.Parse;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "9LiuD72xapKDZ0aLkjql7I3EGGG61gudadfgK9Ua", "vBJ6GVdPMPA87AGg7X3hZb4pGG01OPJnMJWssApf");
    }
}
