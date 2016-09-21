package io.github.dmitrikudrenko.logger.events;

public enum ActivityEvents implements LogEvent {
    ACTIVITY_START {
        @Override
        public String getValue() {
            return "Start activity";
        }
    }, ACTIVITY_STOP {
        @Override
        public String getValue() {
            return "Stop activity";
        }
    }
}
