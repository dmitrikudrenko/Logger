package io.github.dmitrikudrenko.logger2.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.LogRecord;

public final class Utils {

    private Utils() {
    }

    public static String toString(final Throwable tr) {
        if (tr == null) {
            return "";
        }
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        return sw.toString();
    }

    public static String defaultIfNull(String message) {
        return message != null ? message : "";
    }

    public static String formatForConsole(LogRecord record) {
        final Throwable thrown = record.getThrown();
        String message;
        if (thrown != null) {
            message = toString(thrown);
        } else {
            message = record.getMessage();
        }
        return message;
    }

    public static String format(LogRecord record) {
        return record.getLoggerName() + ": " + formatForConsole(record) + "\n";
    }
}
