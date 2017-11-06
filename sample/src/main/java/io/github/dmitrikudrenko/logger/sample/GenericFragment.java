package io.github.dmitrikudrenko.logger.sample;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.github.dmitrikudrenko.logger2.Log;
import io.github.dmitrikudrenko.logger2.events.FragmentLifecycleEvent;

public class GenericFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.event(FragmentLifecycleEvent.ATTACH, getClass().getSimpleName());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.event(FragmentLifecycleEvent.CREATE, getClass().getSimpleName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.event(FragmentLifecycleEvent.CREATE_VIEW, getClass().getSimpleName());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.event(FragmentLifecycleEvent.START, getClass().getSimpleName());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.event(FragmentLifecycleEvent.RESUME, getClass().getSimpleName());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.event(FragmentLifecycleEvent.PAUSE, getClass().getSimpleName());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.event(FragmentLifecycleEvent.STOP, getClass().getSimpleName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.event(FragmentLifecycleEvent.DESTROY_VIEW, getClass().getSimpleName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.event(FragmentLifecycleEvent.DESTROY, getClass().getSimpleName());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.event(FragmentLifecycleEvent.DETACH, getClass().getSimpleName());
    }
}
