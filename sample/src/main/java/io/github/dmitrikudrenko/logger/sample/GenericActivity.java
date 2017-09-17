package io.github.dmitrikudrenko.logger.sample;


import android.app.Activity;
import android.os.Bundle;
import io.github.dmitrikudrenko.logger2.Logger;
import io.github.dmitrikudrenko.logger2.events.ActivityLifecycleEvent;

public abstract class GenericActivity extends Activity {
    protected Logger logger = Logger.getInstance();

    @Override
    protected void onStart() {
        super.onStart();
        logger.event(ActivityLifecycleEvent.START, getClass());
    }

    @Override
    protected void onStop() {
        logger.event(ActivityLifecycleEvent.STOP, getClass());
        super.onStop();
    }

    @Override
    protected void onPause() {
        logger.event(ActivityLifecycleEvent.PAUSE, getClass());
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        logger.event(ActivityLifecycleEvent.RESUME, getClass());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logger.event(ActivityLifecycleEvent.CREATE, getClass());
    }

    @Override
    protected void onDestroy() {
        logger.event(ActivityLifecycleEvent.DESTROY, getClass());
        super.onDestroy();
    }
}
