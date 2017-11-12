package io.github.dmitrikudrenko.logger.events

import io.github.dmitrikudrenko.logger.BasePublishTest
import io.github.dmitrikudrenko.logger.Log
import io.github.dmitrikudrenko.logger.LogRecordMatcher
import io.github.dmitrikudrenko.logger.MOCK_TAG
import org.junit.Test
import org.mockito.Mockito.argThat
import org.mockito.Mockito.verify
import java.util.logging.Handler
import java.util.logging.Level

class ViewEventTest : BasePublishTest() {

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