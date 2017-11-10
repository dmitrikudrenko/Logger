package io.github.dmitrikudrenko.logger2

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.argThat
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.logging.Handler
import java.util.logging.Level

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class LoggerPublishTest : BasePublishTest() {

    @Test
    fun `should verbose record invoked`() {
        Log.v(MOCK_TAG, MOCK_MESSAGE)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Log.VERBOSE, MOCK_TAG, MOCK_MESSAGE)))
    }

    @Test
    fun `should verbose record with exception invoked`() {
        Log.v(MOCK_TAG, MOCK_MESSAGE, MOCK_EXCEPTION)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Log.VERBOSE, MOCK_TAG, MOCK_MESSAGE, MOCK_EXCEPTION)))
    }

    @Test
    fun `should debug record invoked`() {
        Log.d(MOCK_TAG, MOCK_MESSAGE)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Log.DEBUG, MOCK_TAG, MOCK_MESSAGE)))
    }

    @Test
    fun `should debug record with exception invoked`() {
        Log.d(MOCK_TAG, MOCK_MESSAGE, MOCK_EXCEPTION)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Log.DEBUG, MOCK_TAG, MOCK_MESSAGE, MOCK_EXCEPTION)))
    }

    @Test
    fun `should warning record invoked`() {
        Log.w(MOCK_TAG, MOCK_MESSAGE)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.WARNING, MOCK_TAG, MOCK_MESSAGE)))
    }

    @Test
    fun `should warning record with exception invoked`() {
        Log.w(MOCK_TAG, MOCK_MESSAGE, MOCK_EXCEPTION)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.WARNING, MOCK_TAG, MOCK_MESSAGE, MOCK_EXCEPTION)))
    }

    @Test
    fun `should info record invoked`() {
        Log.i(MOCK_TAG, MOCK_MESSAGE)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, MOCK_MESSAGE)))
    }

    @Test
    fun `should info record with exception invoked`() {
        Log.i(MOCK_TAG, MOCK_MESSAGE, MOCK_EXCEPTION)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, MOCK_MESSAGE, MOCK_EXCEPTION)))
    }

    @Test
    fun `should error record invoked`() {
        Log.e(MOCK_TAG, MOCK_MESSAGE)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.SEVERE, MOCK_TAG, MOCK_MESSAGE)))
    }

    @Test
    fun `should error record with exception invoked`() {
        Log.e(MOCK_TAG, MOCK_MESSAGE, MOCK_EXCEPTION)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.SEVERE, MOCK_TAG, MOCK_MESSAGE, MOCK_EXCEPTION)))
    }

    @Test
    fun `should info record invoked if LogEvent sent`() {
        Log.event(MOCK_EVENT)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_EVENT.javaClass.simpleName, MOCK_EVENT_VALUE)))
    }

    @Test
    fun `should info record with tag invoked if LogEvent sent`() {
        Log.event(MOCK_EVENT, MOCK_TAG)
        verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, MOCK_EVENT_VALUE)))
    }
}
