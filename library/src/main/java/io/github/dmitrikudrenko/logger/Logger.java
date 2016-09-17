package io.github.dmitrikudrenko.logger;

import android.app.Activity;
import android.view.View;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Logger implements LoggerCombiner, ILogger {
    private List<ILogger> loggers = new CopyOnWriteArrayList<>();
    private static Logger INSTANCE;

    private Logger() {
    }

    public static Logger getInstance() {
        if (INSTANCE == null) {
            synchronized (Logger.class) {
                INSTANCE = new Logger();
            }
        }
        return INSTANCE;
    }

    @Override
    public synchronized void addLogger(ILogger logger) {
        loggers.add(logger);
    }

    @Override
    public synchronized void removeLogger(ILogger logger) {
        loggers.remove(logger);
    }

    @Override
    public synchronized void i(String tag, String message) {
        for (ILogger logger : loggers) {
            logger.i(tag, message);
        }
    }

    @Override
    public synchronized void i(String tag, String message, Throwable throwable) {
        for (ILogger logger : loggers) {
            logger.i(tag, message, throwable);
        }
    }

    @Override
    public synchronized void w(String tag, String message) {
        for (ILogger logger : loggers) {
            logger.w(tag, message);
        }
    }

    @Override
    public synchronized void w(String tag, String message, Throwable throwable) {
        for (ILogger logger : loggers) {
            logger.w(tag, message, throwable);
        }
    }

    @Override
    public synchronized void d(String tag, String message) {
        for (ILogger logger : loggers) {
            logger.d(tag, message);
        }
    }

    @Override
    public synchronized void d(String tag, String message, Throwable throwable) {
        for (ILogger logger : loggers) {
            logger.d(tag, message, throwable);
        }
    }

    @Override
    public synchronized void e(String tag, String message) {
        for (ILogger logger : loggers) {
            logger.e(tag, message);
        }
    }

    @Override
    public synchronized void e(String tag, String message, Throwable throwable) {
        for (ILogger logger : loggers) {
            logger.e(tag, message, throwable);
        }
    }

    @Override
    public synchronized void event(ViewEvents event, View view) {
        for (ILogger logger : loggers) {
            logger.event(event, view);
        }
    }

    @Override
    public synchronized void event(ActivityEvents event, Class<? extends Activity> activityClass) {
        for (ILogger logger : loggers) {
            logger.event(event, activityClass);
        }
    }
}
