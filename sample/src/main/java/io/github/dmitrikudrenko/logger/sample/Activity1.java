package io.github.dmitrikudrenko.logger.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import io.github.dmitrikudrenko.logger2.Log;
import io.github.dmitrikudrenko.logger2.events.ViewEvent;

public class Activity1 extends GenericActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_1);
    }

    public void clickButton(View view) {
        Log.event(ViewEvent.CLICK, (String) ((Button) view).getText());
        startActivity(new Intent(this, Activity2.class));
    }
}
