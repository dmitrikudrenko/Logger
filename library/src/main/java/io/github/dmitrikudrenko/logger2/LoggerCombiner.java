package io.github.dmitrikudrenko.logger2;

public interface LoggerCombiner {
    LoggerCombiner addLogger(ILogger logger);
    LoggerCombiner removeLogger(ILogger logger);
}
