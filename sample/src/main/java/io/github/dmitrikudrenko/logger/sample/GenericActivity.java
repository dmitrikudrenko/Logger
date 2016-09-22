package io.github.dmitrikudrenko.logger.sample;


import android.app.Activity;
import android.os.Bundle;

import io.github.dmitrikudrenko.logger.Logger;
import io.github.dmitrikudrenko.logger.events.ActivityLifecycleEvent;

public abstract class GenericActivity extends Activity {
    @Override
    protected void onStart() {
        super.onStart();
        Logger.getInstance().event(ActivityLifecycleEvent.START, getClass());
    }

    @Override
    protected void onStop() {
        Logger.getInstance().event(ActivityLifecycleEvent.STOP, getClass());
        super.onStop();
    }

    @Override
    protected void onPause() {
        Logger.getInstance().event(ActivityLifecycleEvent.PAUSE, getClass());
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.getInstance().event(ActivityLifecycleEvent.RESUME, getClass());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.getInstance().event(ActivityLifecycleEvent.CREATE, getClass());
    }

    @Override
    protected void onDestroy() {
        Logger.getInstance().event(ActivityLifecycleEvent.DESTROY, getClass());
        super.onDestroy();
    }
}
