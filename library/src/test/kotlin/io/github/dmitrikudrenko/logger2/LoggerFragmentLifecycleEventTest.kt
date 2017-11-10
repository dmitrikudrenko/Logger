package io.github.dmitrikudrenko.logger2

import io.github.dmitrikudrenko.logger2.events.FragmentLifecycleEvent
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.argThat
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.logging.Handler
import java.util.logging.Level

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class LoggerFragmentLifecycleEventTest : BasePublishTest() {

    @Test
    fun `should publish "Create" fragment event`() {
        Log.event(FragmentLifecycleEvent.CREATE, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Create fragment")))
    }

    @Test
    fun `should publish "Destroy" fragment event`() {
        Log.event(FragmentLifecycleEvent.DESTROY, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Destroy fragment")))
    }

    @Test
    fun `should publish "Create view" fragment event`() {
        Log.event(FragmentLifecycleEvent.CREATE_VIEW, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Create fragment view")))
    }

    @Test
    fun `should publish "Destroy view" fragment event`() {
        Log.event(FragmentLifecycleEvent.DESTROY_VIEW, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Destroy fragment view")))
    }

    @Test
    fun `should publish "Start" fragment event`() {
        Log.event(FragmentLifecycleEvent.START, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Start fragment")))
    }

    @Test
    fun `should publish "Stop" fragment event`() {
        Log.event(FragmentLifecycleEvent.STOP, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Stop fragment")))
    }

    @Test
    fun `should publish "Resume" fragment event`() {
        Log.event(FragmentLifecycleEvent.RESUME, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Resume fragment")))
    }

    @Test
    fun `should publish "Pause" fragment event`() {
        Log.event(FragmentLifecycleEvent.PAUSE, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Pause fragment")))
    }

    @Test
    fun `should publish "Attach" fragment event`() {
        Log.event(FragmentLifecycleEvent.ATTACH, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Attach fragment")))
    }

    @Test
    fun `should publish "Detach" fragment event`() {
        Log.event(FragmentLifecycleEvent.DETACH, MOCK_TAG)
        Mockito.verify<Handler>(handler)
                .publish(argThat(LogRecordMatcher(Level.INFO, MOCK_TAG, "Detach fragment")))
    }
}