package io.github.dmitrikudrenko.logger2.impl;

import android.util.Log;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class AndroidHandler extends Handler {

    private static final int SEVERE = Level.SEVERE.intValue();
    private static final int WARNING = Level.WARNING.intValue();
    private static final int INFO = Level.INFO.intValue();
    private static final int CONFIG = Level.CONFIG.intValue();

    @Override
    public void publish(LogRecord record) {
        Level level = record.getLevel();
        String tag = record.getLoggerName();
        if (tag.length() > 23) {
            tag = tag.substring(0, 23);
        }
        Log.println(getAndroidLevel(level), tag, getFormatter().format(record));
    }

    private int getAndroidLevel(Level level) {
        final int value = level.intValue();
        if (value >= SEVERE) {
            return Log.ERROR;
        } else if (value >= WARNING) {
            return Log.WARN;
        } else if (value >= INFO) {
            return Log.INFO;
        } else if (value >= CONFIG) {
            return Log.VERBOSE;
        } else {
            return Log.DEBUG;
        }
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }
}