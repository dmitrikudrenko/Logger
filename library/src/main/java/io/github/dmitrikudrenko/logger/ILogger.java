package io.github.dmitrikudrenko.logger;

import android.app.Activity;
import android.view.View;

import io.github.dmitrikudrenko.logger.events.LogEvent;

public interface ILogger {
    void i(String tag, String message);
    void i(String tag, String message, Throwable throwable);

    void w(String tag, String message);
    void w(String tag, String message, Throwable throwable);

    void d(String tag, String message);
    void d(String tag, String message, Throwable throwable);

    void e(String tag, String message);
    void e(String tag, String message, Throwable throwable);

    void v(String tag, String message);
    void v(String tag, String message, Throwable throwable);

    void event(LogEvent event);
    void event(LogEvent event, String message);
    void event(LogEvent event, View view);
    void event(LogEvent event, Class<? extends Activity> activityClass);
}
