package io.github.dmitrikudrenko.logger.impl;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.util.Map;

import io.github.dmitrikudrenko.logger.ILogger;
import io.github.dmitrikudrenko.logger.events.LogEvent;

import static io.github.dmitrikudrenko.logger.LogUtils.getViewCaption;

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
    public void e(Throwable throwable) {
        Log.e("No tag", throwable.getMessage(), throwable);
    }

    @Override
    public void v(String tag, String message) {
        Log.v(tag, message);
    }

    @Override
    public void v(String tag, String message, Throwable throwable) {
        Log.v(tag, message, throwable);
    }

    @Override
    public void event(LogEvent event) {
        Log.i(event.getValue(), event.getValue());
    }

    @Override
    public void event(LogEvent event, String message) {
        Log.i(event.getValue(), message);
    }

    @Override
    public void event(LogEvent event, Map<String, Object> attributes) {
        Log.i(event.getValue(), attributes.toString());
    }

    @Override
    public void event(LogEvent event, View view) {
        Log.i(event.getValue(), getViewCaption(view));
    }

    @Override
    public void event(LogEvent event, Class<? extends Activity> activityClass) {
        Log.i(event.getValue(), activityClass.getName());
    }
}
