package io.github.dmitrikudrenko.logger2;

import io.github.dmitrikudrenko.logger2.impl.AndroidHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.robolectric.annotation.Config;

import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@Config(manifest = Config.NONE)
@PrepareForTest({Log.class, Logger.class, LogManager.class})
public class LogSetupTest {
    private Logger logger;
    private Handler handler;

    @Before
    public void setUp() {
        logger = mock(Logger.class);
        handler = mock(Handler.class);

        PowerMockito.mockStatic(LogManager.class);
        LogManager logManager = mock(LogManager.class);
        when(LogManager.getLogManager()).thenReturn(logManager);
        when(logManager.getLogger(any())).thenReturn(logger);
    }

    @Test
    public void shouldAddAndroidHandlerIfSetup() {
        Log.setup();
        verify(logger).addHandler(any(AndroidHandler.class));
    }

    @Test
    public void shouldAddHandler() {
        Log.addHandler(handler);
        verify(logger).addHandler(handler);
    }

    @Test
    public void shouldRemoveHandler() {
        Log.removeHandler(handler);
        verify(logger).removeHandler(handler);
    }
}
