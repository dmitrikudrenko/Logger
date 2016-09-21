package io.github.dmitrikudrenko.logger.impl;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import io.github.dmitrikudrenko.logger.ILogger;
import io.github.dmitrikudrenko.logger.events.LogEvent;

public class OutputStreamLogger implements ILogger {
    private static final String DELIMITER = " ";
    private static final String I = "info/";
    private static final String W = "warning/";
    private static final String D = "debug/";
    private static final String E = "error/";
    private static final String V = "verbose/";
    private static final String EV = "event/";

    private OutputStreamWriter outputStreamWriter;

    public OutputStreamLogger(OutputStream outputStream) {
        outputStreamWriter = new OutputStreamWriter(outputStream);
    }

    @Override
    public void i(String tag, String message) {
        append(I + tag + DELIMITER + message);
    }

    @Override
    public void i(String tag, String message, Throwable throwable) {
        append(I + tag + DELIMITER + message + DELIMITER + getStackTrace(throwable));
    }

    @Override
    public void w(String tag, String message) {
        append(W + tag + DELIMITER + message);
    }

    @Override
    public void w(String tag, String message, Throwable throwable) {
        append(W + tag + DELIMITER + message + DELIMITER + getStackTrace(throwable));
    }

    @Override
    public void d(String tag, String message) {
        append(D + tag + DELIMITER + message);
    }

    @Override
    public void d(String tag, String message, Throwable throwable) {
        append(D + tag + DELIMITER + message + DELIMITER + getStackTrace(throwable));
    }

    @Override
    public void e(String tag, String message) {
        append(E + tag + DELIMITER + message);
    }

    @Override
    public void e(String tag, String message, Throwable throwable) {
        append(E + tag + DELIMITER + message + DELIMITER + getStackTrace(throwable));
    }

    @Override
    public void v(String tag, String message) {
        append(V + tag + DELIMITER + message);
    }

    @Override
    public void v(String tag, String message, Throwable throwable) {
        append(V + tag + DELIMITER + message + DELIMITER + getStackTrace(throwable));
    }

    @Override
    public void event(LogEvent event) {
        append(EV + event.getValue());
    }

    @Override
    public void event(LogEvent event, View view) {
        String caption;
        if (view instanceof TextView) {
            caption = ((TextView) view).getText().toString();
        } else caption = view.getClass().toString();
        append(EV + event.getValue() + DELIMITER + caption);
    }

    @Override
    public void event(LogEvent event, Class<? extends Activity> activityClass) {
        append(EV + event.getValue() + DELIMITER + activityClass.getName());
    }

    private void append(String message) {
        try {
            outputStreamWriter.append(message).append("\n");
            outputStreamWriter.flush();
        } catch (IOException e) {
            Log.e(OutputStreamLogger.class.getName(), e.getMessage(), e);
        }
    }

    private String getStackTrace(Throwable throwable) {
        return Log.getStackTraceString(throwable);
    }
}
