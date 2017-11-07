package io.github.dmitrikudrenko.logger2;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Log.class})
public class LoggerPublishTest {
    private static final String MOCK_TAG = "tag";
    private static final String MOCK_MESSAGE = "message";

    private static Logger logger;
    private static Handler handler;

    @BeforeClass
    public static void setUp() {
        logger = mock(Logger.class);
        handler = mock(Handler.class);

        PowerMockito.mockStatic(LogManager.class);
        LogManager logManager = mock(LogManager.class);
        when(LogManager.getLogManager()).thenReturn(logManager);
        when(logManager.getLogger(any())).thenReturn(logger);
    }

    @Test
    public void shouldPublishRecord() {
        Log.addHandler(handler);
        Log.i(MOCK_TAG, MOCK_MESSAGE);
        verify(handler).publish(any(LogRecord.class));
    }
}
