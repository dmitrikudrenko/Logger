package io.github.dmitrikudrenko.logger.events;

public enum ActivityLifecycleEvent implements LogEvent {
    START {
        @Override
        public String getValue() {
            return "Start activity";
        }
    }, STOP {
        @Override
        public String getValue() {
            return "Stop activity";
        }
    }, RESUME {
        @Override
        public String getValue() {
            return "Resume activity";
        }
    }, PAUSE {
        @Override
        public String getValue() {
            return "Pause activity";
        }
    }, CREATE {
        @Override
        public String getValue() {
            return "Create activity";
        }
    }, DESTROY {
        @Override
        public String getValue() {
            return "Destroy activity";
        }
    }
}
