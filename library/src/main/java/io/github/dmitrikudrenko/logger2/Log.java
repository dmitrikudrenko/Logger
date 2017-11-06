package io.github.dmitrikudrenko.logger2;

import android.text.TextUtils;
import io.github.dmitrikudrenko.logger2.events.LogEvent;
import io.github.dmitrikudrenko.logger2.impl.AndroidHandler;
import io.reactivex.annotations.Nullable;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public final class Log {
    private static final Level VERBOSE = new Verbose();
    private static final Level DEBUG = new Debug();

    public static final Handler ANDROID = new AndroidHandler();

    private static final Formatter FORMATTER = new Formatter() {
        @Override
        public String format(final LogRecord r) {
            final Throwable thrown = r.getThrown();
            if (thrown != null) {
                return "\n" + Log.toString(thrown);
            } else {
                return r.getMessage();
            }
        }
    };

    private static final Logger logger;

    static {
        final LogManager manager = LogManager.getLogManager();
        logger = manager.getLogger("");
        logger.setLevel(Level.ALL);
    }

    public static void addHandler(Handler handler) {
        handler.setFormatter(FORMATTER);
        logger.addHandler(handler);
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

    public static void w(final String tag, final Throwable th) {
        logger.log(createLogRecord(Level.WARNING, tag, th));
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

    private static LogRecord createLogRecord(final Level level, final String tag, final Throwable th) {
        return createLogRecord(level, tag, null, th);
    }

    private static LogRecord createLogRecord(final Level level, final String tag,
                                             @Nullable final String message,
                                             @Nullable final Throwable th) {
        final LogRecord record = new LogRecord(level, tag + ": " + (TextUtils.isEmpty(message) ? "" : message));
        record.setThrown(th);
        return record;
    }

    private static String toString(@Nullable final Throwable tr) {
        if (tr == null) {
            return "";
        }
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        return sw.toString();
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
