package io.github.dmitrikudrenko.logger2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.logging.Handler;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class LogSetupTest {
    @Test
    public void shouldAddHandler() {
        Logger logger = mock(Logger.class);
        Log.logger = logger;

        Handler handler = mock(Handler.class);

        Log.addHandler(handler);
        verify(logger).addHandler(handler);
    }

    @Test
    public void shouldRemoveHandler() {
        Logger logger = mock(Logger.class);
        Log.logger = logger;

        Handler handler = mock(Handler.class);

        Log.removeHandler(handler);
        verify(logger).removeHandler(handler);
    }
}
