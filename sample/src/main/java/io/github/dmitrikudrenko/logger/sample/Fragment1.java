package io.github.dmitrikudrenko.logger.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import io.github.dmitrikudrenko.logger2.Log;
import io.github.dmitrikudrenko.logger2.events.ViewEvent;

public class Fragment1 extends GenericFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.button).setOnClickListener(v -> {
            Log.event(ViewEvent.CLICK, (String) ((Button) v).getText());
            startActivity(new Intent(getActivity(), Activity2.class));
        });
    }
}
