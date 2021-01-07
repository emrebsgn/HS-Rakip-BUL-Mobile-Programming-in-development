package com.emrebisgun.hsrakipbul;

import android.app.Application;

import com.parse.Parse;

public class ParseBaslat extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        Parse.initialize(new Parse.Configuration.Builder(ParseBaslat.this)
                .applicationId("HZ7GL8y6WS347MaCx7Pv9f4sppsoncFPKfyglqUS")
                .clientKey("gE62hpjzVZ0idSFg9h3z8neadbtVFLGch8F9YitS")
                .server("https://parseapi.back4app.com/")
                .build()

        );
    }
}
