package io.github.dmitrikudrenko.logger.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.github.dmitrikudrenko.logger.Logger;
import io.github.dmitrikudrenko.logger.events.ActivityEvents;
import io.github.dmitrikudrenko.logger.events.ViewEvents;

public class Activity1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_1);
    }

    public void clickButton(View view) {
        Logger.getInstance().event(ViewEvents.CLICK, view);
        startActivity(new Intent(this, Activity2.class));
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
