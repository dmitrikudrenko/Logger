package io.github.dmitrikudrenko.logger;

public interface LoggerCombiner {
    void addLogger(ILogger logger);
    void removeLogger(ILogger logger);
}
