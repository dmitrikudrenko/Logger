package io.github.dmitrikudrenko.logger.utils

import io.github.dmitrikudrenko.logger.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.logging.LogRecord

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
        assertEquals(MOCK_MESSAGE, Utils.formatForConsole(LogRecord(MOCK_LEVEL, MOCK_MESSAGE)))
    }

    @Test
    fun `should return exception stacktrace if record has exception`() {
        val message = Utils.formatForConsole(MOCK_LOG_RECORD_W_ERROR)
        assertTrue(message.startsWith("java.lang.Exception: exception"))
    }

    @Test
    fun `should output format message`() {
        assertEquals("tag: message\n", Utils.format(MOCK_LOG_RECORD))
    }
}
