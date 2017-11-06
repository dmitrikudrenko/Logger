package io.github.dmitrikudrenko.logger.sample;

import android.app.Application;
import io.github.dmitrikudrenko.logger2.Log;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        Log.addHandler(Log.ANDROID);
        super.onCreate();
    }
}
