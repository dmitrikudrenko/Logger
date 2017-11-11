package io.github.dmitrikudrenko.logger.events

import io.github.dmitrikudrenko.logger.BasePublishTest
import io.github.dmitrikudrenko.logger.Log
import io.github.dmitrikudrenko.logger.LogRecordMatcher
import io.github.dmitrikudrenko.logger.MOCK_TAG
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.logging.Handler
import java.util.logging.Level

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class ActivityLifecycleEventTest : BasePublishTest() {
    @Test
    fun `should publish "Start" activity event`() {
        Log.event(ActivityLifecycleEvent.START, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(Matchers.argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Start activity")))
    }

    @Test
    fun `should publish "Stop" activity event`() {
        Log.event(ActivityLifecycleEvent.STOP, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(Matchers.argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Stop activity")))
    }

    @Test
    fun `should publish "Resume" activity event`() {
        Log.event(ActivityLifecycleEvent.RESUME, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(Matchers.argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Resume activity")))
    }

    @Test
    fun `should publish "Pause" activity event`() {
        Log.event(ActivityLifecycleEvent.PAUSE, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(Matchers.argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Pause activity")))
    }

    @Test
    fun `should publish "Create" activity event`() {
        Log.event(ActivityLifecycleEvent.CREATE, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(Matchers.argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Create activity")))
    }

    @Test
    fun `should publish "Destroy" activity event`() {
        Log.event(ActivityLifecycleEvent.DESTROY, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(Matchers.argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Destroy activity")))
    }
}