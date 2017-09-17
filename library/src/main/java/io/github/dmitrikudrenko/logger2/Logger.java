package io.github.dmitrikudrenko.logger2;

import android.app.Activity;
import android.view.View;
import io.github.dmitrikudrenko.logger2.events.LogEvent;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static io.github.dmitrikudrenko.logger2.LogUtils.getViewCaption;

public final class Logger implements LoggerCombiner, ILogger {
    private List<ILogger> loggers = new CopyOnWriteArrayList<>();
    private static Logger INSTANCE;
    private Scheduler scheduler;

    private Logger(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public static Logger getInstance() {
        return getInstance(AndroidSchedulers.mainThread());
    }

    public static Logger getInstance(Scheduler scheduler) {
        if (INSTANCE == null) {
            synchronized (Logger.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Logger(scheduler);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LoggerCombiner addLogger(ILogger logger) {
        loggers.add(logger);
        return this;
    }

    @Override
    public LoggerCombiner removeLogger(ILogger logger) {
        loggers.remove(logger);
        return this;
    }

    @Override
    public void i(final String tag, final String message) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.i(tag, message);
                }
            }
        });
    }

    @Override
    public void i(final String tag, final String message, final Throwable throwable) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.i(tag, message, throwable);
                }
            }
        });
    }

    @Override
    public void w(final String tag, final String message) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.w(tag, message);
                }
            }
        });
    }

    @Override
    public void w(final String tag, final String message, final Throwable throwable) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.w(tag, message, throwable);
                }
            }
        });
    }

    @Override
    public void d(final String tag, final String message) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.d(tag, message);
                }
            }
        });
    }

    @Override
    public void d(final String tag, final String message, final Throwable throwable) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.d(tag, message, throwable);
                }
            }
        });
    }

    @Override
    public void e(final String tag, final String message) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.e(tag, message);
                }
            }
        });
    }

    @Override
    public void e(final String tag, final String message, final Throwable throwable) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.e(tag, message, throwable);
                }
            }
        });
    }

    @Override
    public void e(final Throwable throwable) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.e(throwable);
                }
            }
        });
    }

    @Override
    public void v(final String tag, final String message) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.v(tag, message);
                }
            }
        });
    }

    @Override
    public void v(final String tag, final String message, final Throwable throwable) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.v(tag, message, throwable);
                }
            }
        });
    }

    @Override
    public void event(final LogEvent event) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.event(event);
                }
            }
        });
    }

    @Override
    public void event(final LogEvent event, final String message) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.event(event, message);
                }
            }
        });
    }

    @Override
    public void event(final LogEvent event, final View view) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.event(event, getViewCaption(view));
                }
            }
        });
    }

    @Override
    public void event(final LogEvent event, final Class<? extends Activity> activityClass) {
        run(new Action() {
            @Override
            public void run() throws Exception {
                for (ILogger logger : loggers) {
                    logger.event(event, activityClass.getName());
                }
            }
        });
    }

    private void run(Action action) {
        Completable.fromAction(action).subscribeOn(scheduler).subscribe();
    }
}
