package io.github.dmitrikudrenko.logger.events;

public enum ViewEvents implements LogEvent {
    TOUCH {
        @Override
        public String getValue() {
            return "Touch";
        }
    }, CLICK {
        @Override
        public String getValue() {
            return "Click";
        }
    }, LONG_CLICK {
        @Override
        public String getValue() {
            return "Long click";
        }
    }
}
