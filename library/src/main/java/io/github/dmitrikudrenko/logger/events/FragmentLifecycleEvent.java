package io.github.dmitrikudrenko.logger.events;

public enum FragmentLifecycleEvent implements LogEvent {
    CREATE() {
        @Override
        public String getValue() {
            return "Create fragment";
        }
    }, DESTROY {
        @Override
        public String getValue() {
            return "Destroy fragment";
        }
    }, CREATE_VIEW {
        @Override
        public String getValue() {
            return "Create fragment view";
        }
    }, DESTROY_VIEW {
        @Override
        public String getValue() {
            return "Destroy fragment view";
        }
    }, START {
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
