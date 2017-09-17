package io.github.dmitrikudrenko.logger2.events;

public enum FragmentLifecycleEvent implements LogEvent {
    START {
        @Override
        public String getValue() {
            return "Start fragment";
        }
    }, STOP {
        @Override
        public String getValue() {
            return "Stop fragment";
        }
    }, RESUME {
        @Override
        public String getValue() {
            return "Resume fragment";
        }
    }, PAUSE {
        @Override
        public String getValue() {
            return "Pause fragment";
        }
    }, ATTACH {
        @Override
        public String getValue() {
            return "Attach fragment";
        }
    }, DETACH {
        @Override
        public String getValue() {
            return "Detach fragment";
        }
    }
}
