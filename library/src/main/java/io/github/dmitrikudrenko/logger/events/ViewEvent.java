package io.github.dmitrikudrenko.logger.events;

public enum ViewEvent implements LogEvent {
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
