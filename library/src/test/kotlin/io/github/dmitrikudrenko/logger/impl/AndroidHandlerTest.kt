package io.github.dmitrikudrenko.logger.impl

import io.github.dmitrikudrenko.logger.*
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*
import java.util.logging.Formatter
import java.util.logging.Level

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

    @Test
    fun `should publish`() {
        val handler = spy(AndroidHandler().apply { formatter = mock(Formatter::class.java) })
        handler.publish(MOCK_LOG_RECORD)
        verify(handler).printLog(eq(MOCK_LEVEL), eq(MOCK_TAG), any())
    }

    @Test
    fun `should publish long tag`() {
        val handler = spy(AndroidHandler().apply { formatter = mock(Formatter::class.java) })
        handler.publish(MOCK_LONG_LOG_RECORD)
        verify(handler).printLog(eq(MOCK_LEVEL), eq("Long long long long lon"), any())
    }
}