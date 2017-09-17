package io.github.dmitrikudrenko.logger.sample;

import android.app.Application;
import android.content.Context;
import io.github.dmitrikudrenko.logger2.Logger;
import io.github.dmitrikudrenko.logger2.impl.AndroidLogger;
import io.github.dmitrikudrenko.logger2.impl.OutputStreamLogger;
import io.reactivex.schedulers.Schedulers;

import java.io.FileNotFoundException;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        try {
            Logger.getInstance(Schedulers.io()) //scheduler set once in application
                    .addLogger(new AndroidLogger())
                    .addLogger(new OutputStreamLogger(openFileOutput("log.txt", Context.MODE_APPEND)));
        } catch (FileNotFoundException e) {
            Logger.getInstance().e("Logger initializing", e.getMessage(), e);
        }
        super.onCreate();
    }
}
