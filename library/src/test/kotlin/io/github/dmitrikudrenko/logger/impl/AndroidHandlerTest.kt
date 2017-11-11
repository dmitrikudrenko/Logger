package io.github.dmitrikudrenko.logger.impl

import io.github.dmitrikudrenko.logger.Log
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.logging.Level

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class AndroidHandlerTest {
    @Test
    fun `should return android-util-Log*ERROR if java-util-logging-Level*SEVERE`() {
        assertEquals(android.util.Log.ERROR, AndroidHandler.getAndroidLevel(Level.SEVERE))
    }

    @Test
    fun `should return android-util-Log*WARN if java-util-logging-Level*WARNING`() {
        assertEquals(android.util.Log.WARN, AndroidHandler.getAndroidLevel(Level.WARNING))
    }

    @Test
    fun `should return android-util-Log*INFO if java-util-logging-Level*INFO`() {
        assertEquals(android.util.Log.INFO, AndroidHandler.getAndroidLevel(Level.INFO))
    }

    @Test
    fun `should return android-util-Log*VERBOSE if Log*VERBOSE`() {
        assertEquals(android.util.Log.VERBOSE, AndroidHandler.getAndroidLevel(Log.VERBOSE))
    }

    @Test
    fun `should return android-util-Log*DEBUG if Log*DEBUG`() {
        assertEquals(android.util.Log.DEBUG, AndroidHandler.getAndroidLevel(Log.DEBUG))
    }
}