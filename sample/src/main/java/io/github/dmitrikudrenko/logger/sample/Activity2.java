package io.github.dmitrikudrenko.logger.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import io.github.dmitrikudrenko.logger2.Log;
import io.github.dmitrikudrenko.logger2.events.ViewEvent;

public class Activity2 extends GenericActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_2);
    }

    public void clickButton(View view) {
        Log.event(ViewEvent.CLICK, (String) ((Button) view).getText());
        onBackPressed();
    }
}
