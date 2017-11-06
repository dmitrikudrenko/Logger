package io.github.dmitrikudrenko.logger2;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
public class LoggerPublishTest {
    public void shouldPublishRecord() {
        Handler handler = mock(Handler.class);
        Log.addHandler(handler);
        Log.i("Tag", "Message");
        verify(handler).publish(any(LogRecord.class));
    }
}
