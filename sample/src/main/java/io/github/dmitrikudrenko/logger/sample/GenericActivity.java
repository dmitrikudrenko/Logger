package io.github.dmitrikudrenko.logger.sample;


import android.app.Activity;
import android.os.Bundle;
import io.github.dmitrikudrenko.logger2.Log;
import io.github.dmitrikudrenko.logger2.events.ActivityLifecycleEvent;

public abstract class GenericActivity extends Activity {
    @Override
    protected void onStart() {
        super.onStart();
        Log.event(ActivityLifecycleEvent.START, getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.event(ActivityLifecycleEvent.STOP, getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.event(ActivityLifecycleEvent.PAUSE, getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.event(ActivityLifecycleEvent.RESUME, getClass().getSimpleName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.event(ActivityLifecycleEvent.CREATE, getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.event(ActivityLifecycleEvent.DESTROY, getClass().getSimpleName());
    }
}
