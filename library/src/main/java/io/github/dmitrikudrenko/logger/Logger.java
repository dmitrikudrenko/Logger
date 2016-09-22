package io.github.dmitrikudrenko.logger;

import android.app.Activity;
import android.view.View;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import io.github.dmitrikudrenko.logger.events.LogEvent;

import static io.github.dmitrikudrenko.logger.LogUtils.getViewCaption;

public class Logger implements LoggerCombiner, ILogger {
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
    public synchronized LoggerCombiner addLogger(ILogger logger) {
        loggers.add(logger);
        return this;
    }

    @Override
    public synchronized LoggerCombiner removeLogger(ILogger logger) {
        loggers.remove(logger);
        return this;
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
    public void v(String tag, String message) {
        for (ILogger logger : loggers) {
            logger.v(tag, message);
        }
    }

    @Override
    public void v(String tag, String message, Throwable throwable) {
        for (ILogger logger : loggers) {
            logger.v(tag, message, throwable);
        }
    }

    @Override
    public void event(LogEvent event) {
        for (ILogger logger : loggers) {
            logger.event(event);
        }
    }

    @Override
    public void event(LogEvent event, String message) {
        for (ILogger logger : loggers) {
            logger.event(event, message);
        }
    }

    @Override
    public synchronized void event(LogEvent event, View view) {
        for (ILogger logger : loggers) {
            logger.event(event, getViewCaption(view));
        }
    }

    @Override
    public synchronized void event(LogEvent event, Class<? extends Activity> activityClass) {
        for (ILogger logger : loggers) {
            logger.event(event, activityClass.getName());
        }
    }
}
