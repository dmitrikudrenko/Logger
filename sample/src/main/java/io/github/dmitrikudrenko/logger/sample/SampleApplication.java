package io.github.dmitrikudrenko.logger.sample;

import android.app.Application;
import android.content.Context;

import java.io.FileNotFoundException;

import io.github.dmitrikudrenko.logger.Logger;
import io.github.dmitrikudrenko.logger.impl.AndroidLogger;
import io.github.dmitrikudrenko.logger.impl.OutputStreamLogger;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        try {
            Logger.getInstance().addLogger(new AndroidLogger());
            Logger.getInstance().addLogger(new OutputStreamLogger(openFileOutput("log.txt", Context.MODE_APPEND)));
        } catch (FileNotFoundException e) {
            Logger.getInstance().e("Logger initializing", e.getMessage(), e);
        }
        super.onCreate();
    }
}
