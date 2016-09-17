package io.github.dmitrikudrenko.logger;

import android.app.Activity;
import android.view.View;

public interface ILogger {
    void i(String tag, String message);
    void i(String tag, String message, Throwable throwable);

    void w(String tag, String message);
    void w(String tag, String message, Throwable throwable);

    void d(String tag, String message);
    void d(String tag, String message, Throwable throwable);

    void e(String tag, String message);
    void e(String tag, String message, Throwable throwable);

    void event(ViewEvents event, View view);
    void event(ActivityEvents event, Class<? extends Activity> activityClass);
}
