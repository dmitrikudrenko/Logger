package io.github.dmitrikudrenko.logger;

public interface LoggerCombiner {
    LoggerCombiner addLogger(ILogger logger);
    LoggerCombiner removeLogger(ILogger logger);
}
