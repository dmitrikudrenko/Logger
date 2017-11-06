package io.github.dmitrikudrenko.logger.sample;

import android.app.Application;
import io.github.dmitrikudrenko.logger2.Log;
import io.github.dmitrikudrenko.logger2.impl.FileHandler;

import java.io.File;
import java.io.IOException;

public class SampleApplication extends Application {
    private static final String TAG = "SampleApplication";
    private static final int MAX_LOG_FILE_SIZE = 5 * 1024 * 1024;

    @Override
    public void onCreate() {
        Log.setup();
        addLogToFile();
        super.onCreate();
    }

    private void addLogToFile() {
        try {
            File log = new File(getFilesDir(), "log.txt");
            if (log.exists() || log.createNewFile()) {
                Log.addHandler(new FileHandler(log.getAbsolutePath(), MAX_LOG_FILE_SIZE, 1, true));
            } else {
                Log.i(TAG, "Can't create log file");
            }
        } catch (IOException e) {
            Log.e("SampleApplication", "addLogToFile", e);
        }
    }
}
