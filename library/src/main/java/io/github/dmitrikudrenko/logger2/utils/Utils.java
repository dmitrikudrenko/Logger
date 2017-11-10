package io.github.dmitrikudrenko.logger2.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

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
}
