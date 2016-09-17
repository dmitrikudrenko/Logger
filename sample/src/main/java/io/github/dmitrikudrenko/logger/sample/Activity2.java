package io.github.dmitrikudrenko.logger.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import io.github.dmitrikudrenko.logger.ActivityEvents;
import io.github.dmitrikudrenko.logger.Logger;
import io.github.dmitrikudrenko.logger.ViewEvents;

public class Activity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_2);
    }

    public void clickButton(View view) {
        Logger.getInstance().event(ViewEvents.CLICK, view);
        onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.getInstance().event(ActivityEvents.ACTIVITY_START, getClass());
    }

    @Override
    protected void onStop() {
        Logger.getInstance().event(ActivityEvents.ACTIVITY_STOP, getClass());
        super.onStop();
    }
}
