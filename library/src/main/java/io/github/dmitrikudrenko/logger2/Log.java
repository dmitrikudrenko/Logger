package io.github.dmitrikudrenko.logger2;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import io.github.dmitrikudrenko.logger2.events.LogEvent;
import io.github.dmitrikudrenko.logger2.impl.AndroidHandler;
import io.github.dmitrikudrenko.logger2.utils.Utils;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public final class Log {
    public static final Level VERBOSE = new Verbose();
    public static final Level DEBUG = new Debug();

    private static Formatter logcatFormatter;
    private static Formatter formatter;
    private static Logger logger;
    private static Handler handler;

    static {
        initDefault();
        initDefaultFormatters();
        initDefaultHandler();
    }

    private static void initDefault() {
        final LogManager manager = LogManager.getLogManager();
        logger = manager.getLogger("");
        logger.setLevel(Level.ALL);
    }

    private static void initDefaultFormatters() {
        logcatFormatter = new Formatter() {
            @Override
            public String format(LogRecord record) {
                final Throwable thrown = record.getThrown();
                String message;
                if (thrown != null) {
                    message = Utils.toString(thrown);
                } else {
                    message = record.getMessage();
                }
                return message;
            }
        };
        formatter = new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLoggerName() + ": " + logcatFormatter.format(record) + "\n";
            }
        };
    }

    private static void initDefaultHandler() {
        handler = new AndroidHandler();
    }

    @VisibleForTesting
    static void setLogger(Logger logger) {
        if (logger != null) {
            Log.logger = logger;
        } else {
            initDefault();
        }
    }

    @VisibleForTesting
    static void setFormatter(Formatter logcatFormatter, Formatter formatter) {
        if (logcatFormatter != null && formatter != null) {
            Log.logcatFormatter = logcatFormatter;
            Log.formatter = formatter;
        } else {
            initDefaultFormatters();
        }
    }

    @VisibleForTesting
    static void setDefaultHandler(Handler handler) {
        if (handler != null) {
            Log.handler = handler;
        } else {
            initDefaultHandler();
        }
    }

    public static void setup() {
        addHandler(handler, logcatFormatter);
    }

    private static void addHandler(Handler handler, Formatter formatter) {
        handler.setFormatter(formatter);
        logger.addHandler(handler);
    }

    public static void addHandler(Handler handler) {
        addHandler(handler, formatter);
    }

    public static void removeHandler(Handler handler) {
        logger.removeHandler(handler);
    }

    public static void v(final String tag, final String message) {
        logger.log(createLogRecord(VERBOSE, tag, message));
    }

    public static void v(final String tag, final String message, final Throwable th) {
        logger.log(createLogRecord(VERBOSE, tag, message, th));
    }

    public static void d(final String tag, final String message) {
        logger.log(createLogRecord(DEBUG, tag, message));
    }

    public static void d(final String tag, final String message, final Throwable th) {
        logger.log(createLogRecord(DEBUG, tag, message, th));
    }

    public static void w(final String tag, final String message) {
        logger.log(createLogRecord(Level.WARNING, tag, message));
    }

    public static void w(final String tag, final String message, final Throwable th) {
        logger.log(createLogRecord(Level.WARNING, tag, message, th));
    }

    public static void i(final String tag, final String message) {
        logger.log(createLogRecord(Level.INFO, tag, message));
    }

    public static void i(final String tag, final String message, final Throwable th) {
        logger.log(createLogRecord(Level.INFO, tag, message, th));
    }

    public static void e(final String tag, final String message) {
        logger.log(createLogRecord(Level.SEVERE, tag, message));
    }

    public static void e(final String tag, final String message, final Throwable th) {
        logger.log(createLogRecord(Level.SEVERE, tag, message, th));
    }

    public static void event(final LogEvent event) {
        logger.log(createLogRecord(Level.INFO, event.getClass().getSimpleName(), event.getValue()));
    }

    public static void event(final LogEvent event, final String tag) {
        logger.log(createLogRecord(Level.INFO, tag, event.getValue()));
    }

    private static LogRecord createLogRecord(final Level level, final String tag, final String message) {
        return createLogRecord(level, tag, message, null);
    }

    private static LogRecord createLogRecord(final Level level, final String tag,
                                             final String message,
                                             final Throwable th) {
        final LogRecord record = new LogRecord(level, TextUtils.isEmpty(message) ? "" : message);
        record.setThrown(th);
        record.setLoggerName(tag);
        return record;
    }

    private static class Verbose extends Level {
        //between INFO (800) and CONFIG (700)
        private static final int VALUE = 750;

        private Verbose() {
            super("VERBOSE", VALUE, "sun.util.logging.resources.logging");
        }
    }

    private static class Debug extends Level {
        //between CONFIG (700) and FINE (500)
        private static final int VALUE = 600;

        private Debug() {
            super("DEBUG", VALUE, "sun.util.logging.resources.logging");
        }
    }
}
