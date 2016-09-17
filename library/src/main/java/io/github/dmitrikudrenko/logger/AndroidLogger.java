package io.github.dmitrikudrenko.logger;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AndroidLogger implements ILogger {
    @Override
    public void i(String tag, String message) {
        Log.i(tag, message);
    }

    @Override
    public void i(String tag, String message, Throwable throwable) {
        Log.i(tag, message, throwable);
    }

    @Override
    public void w(String tag, String message) {
        Log.w(tag, message);
    }

    @Override
    public void w(String tag, String message, Throwable throwable) {
        Log.w(tag, message, throwable);
    }

    @Override
    public void d(String tag, String message) {
        Log.d(tag, message);
    }

    @Override
    public void d(String tag, String message, Throwable throwable) {
        Log.d(tag, message, throwable);
    }

    @Override
    public void e(String tag, String message) {
        Log.e(tag, message);
    }

    @Override
    public void e(String tag, String message, Throwable throwable) {
        Log.e(tag, message, throwable);
    }

    @Override
    public void event(ViewEvents event, View view) {
        String caption;
        if (view instanceof TextView) {
            caption = ((TextView) view).getText().toString();
        } else caption = view.getClass().toString();
        Log.i(event.name(), caption);
    }

    @Override
    public void event(ActivityEvents event, Class<? extends Activity> activityClass) {
        Log.i(event.name(), activityClass.getName());
    }
}
