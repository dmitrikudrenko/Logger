package io.github.dmitrikudrenko.logger.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.github.dmitrikudrenko.logger.Logger;
import io.github.dmitrikudrenko.logger.events.ViewEvent;

public class Activity1 extends GenericActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_1);
    }

    public void clickButton(View view) {
        Logger.getInstance().event(ViewEvent.CLICK, view);
        startActivity(new Intent(this, Activity2.class));
    }
}
