package io.github.dmitrikudrenko.logger2.impl;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import io.github.dmitrikudrenko.logger2.ILogger;
import io.github.dmitrikudrenko.logger2.events.LogEvent;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.Date;

import static io.github.dmitrikudrenko.logger2.LogUtils.getViewCaption;

public class OutputStreamLogger implements ILogger {
    private static final String DELIMITER = " ";
    private static final String I = "info/";
    private static final String W = "warning/";
    private static final String D = "debug/";
    private static final String E = "error/";
    private static final String V = "verbose/";
    private static final String EV = "event/";

    private boolean isTimestampEnabled = true;
    private DateFormat timestampFormat = DateFormat.getDateTimeInstance();

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
    public void e(Throwable throwable) {
        append(E + "No tag" + DELIMITER + throwable.getMessage() + DELIMITER + getStackTrace(throwable));
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
    public void event(LogEvent event, String message) {
        append(EV + event.getValue() + DELIMITER + message);
    }

    @Override
    public void event(LogEvent event, View view) {
        append(EV + event.getValue() + DELIMITER + getViewCaption(view));
    }

    @Override
    public void event(LogEvent event, Class<? extends Activity> activityClass) {
        append(EV + event.getValue() + DELIMITER + activityClass.getName());
    }

    private void append(String message) {
        try {
            if (isTimestampEnabled) {
                outputStreamWriter.append(timestampFormat.format(new Date())).append(DELIMITER);
            }
            outputStreamWriter.append(message).append("\n");
            outputStreamWriter.flush();
        } catch (IOException e) {
            Log.e(OutputStreamLogger.class.getName(), e.getMessage(), e);
        }
    }

    private String getStackTrace(Throwable throwable) {
        return Log.getStackTraceString(throwable);
    }

    public OutputStreamLogger setTimestampEnabled(boolean enabled) {
        this.isTimestampEnabled = enabled;
        return this;
    }
}
