package io.github.dmitrikudrenko.logger;


import android.view.View;
import android.widget.TextView;

public class LogUtils {
    public static String getViewCaption(View view) {
        if (view instanceof TextView) {
            return ((TextView) view).getText().toString();
        } else return view.getClass().getName();
    }
}
