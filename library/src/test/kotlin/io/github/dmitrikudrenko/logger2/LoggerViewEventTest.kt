package io.github.dmitrikudrenko.logger2

import io.github.dmitrikudrenko.logger2.events.ViewEvent
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.argThat
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.logging.Handler
import java.util.logging.Level

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class LoggerViewEventTest : BasePublishTest() {

    @Test
    fun `should publish "Touch" view event`() {
        Log.event(ViewEvent.TOUCH, MOCK_TAG)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Touch")))
    }

    @Test
    fun `should publish "Click" view event`() {
        Log.event(ViewEvent.CLICK, MOCK_TAG)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Click")))
    }

    @Test
    fun `should publish "Long click" view event`() {
        Log.event(ViewEvent.LONG_CLICK, MOCK_TAG)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Long click")))
    }
}