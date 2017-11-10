package io.github.dmitrikudrenko.logger2.impl;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;

public class FileHandler extends java.util.logging.FileHandler {
    private static final int QUEUE_SIZE = 256;

    private final Executor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(QUEUE_SIZE), new DiscardPolicy());

    public FileHandler() throws IOException, SecurityException {
    }

    public FileHandler(String pattern) throws IOException, SecurityException {
        super(pattern);
    }

    public FileHandler(String pattern, boolean append) throws IOException, SecurityException {
        super(pattern, append);
    }

    public FileHandler(String pattern, int limit, int count) throws IOException, SecurityException {
        super(pattern, limit, count);
    }

    public FileHandler(String pattern, int limit, int count, boolean append) throws IOException, SecurityException {
        super(pattern, limit, count, append);
    }

    @Override
    public synchronized void publish(final LogRecord record) {
        executor.execute(() -> super.publish(record));
    }
}