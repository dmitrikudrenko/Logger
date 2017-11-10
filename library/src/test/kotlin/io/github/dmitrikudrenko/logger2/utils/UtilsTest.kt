package io.github.dmitrikudrenko.logger2.utils

import io.github.dmitrikudrenko.logger2.MOCK_EXCEPTION
import io.github.dmitrikudrenko.logger2.MOCK_MESSAGE
import io.github.dmitrikudrenko.logger2.MOCK_TAG
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.logging.Level
import java.util.logging.LogRecord

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class UtilsTest {
    @Test
    fun `should convert throwable to string`() {
        val exceptionStr = Utils.toString(MOCK_EXCEPTION)
        assertTrue(exceptionStr.startsWith("java.lang.Exception: exception"))
    }

    @Test
    fun `should return empty string if null throwable`() {
        assertEquals("", Utils.toString(null))
    }

    @Test
    fun `should return message if it is not null`() {
        assertEquals(MOCK_MESSAGE, Utils.defaultIfNull(MOCK_MESSAGE))
    }

    @Test
    fun `should return empty string if message is null`() {
        assertEquals("", Utils.defaultIfNull(null))
    }

    @Test
    fun `should return only message if record has not exception`() {
        assertEquals(MOCK_MESSAGE, Utils.formatForConsole(LogRecord(Level.INFO, MOCK_MESSAGE)))
    }

    @Test
    fun `should return exception stacktrace if record has exception`() {
        val logRecord = LogRecord(Level.INFO, MOCK_MESSAGE)
        logRecord.thrown = MOCK_EXCEPTION
        val message = Utils.formatForConsole(logRecord)
        assertTrue(message.startsWith("java.lang.Exception: exception"))
    }

    @Test
    fun `should output format message`() {
        val logRecord = LogRecord(Level.INFO, MOCK_MESSAGE)
        logRecord.loggerName = MOCK_TAG
        assertEquals("tag: message\n", Utils.format(logRecord))
    }
}
