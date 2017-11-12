package io.github.dmitrikudrenko.logger

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import java.util.logging.Formatter

class LogTestUtils {
    private lateinit var logcatFormatter: Formatter
    private lateinit var formatter: Formatter

    @Before
    fun `set up`() {
        logcatFormatter = mock(Formatter::class.java)
        formatter = mock(Formatter::class.java)
    }

    @Test
    fun `should set default formatters 1`() {
        Log.setFormatter(logcatFormatter, null)
        Log.setup()
        assertNotEquals(Log.logcatFormatter, logcatFormatter)
        assertNotEquals(Log.formatter, formatter)
    }

    @Test
    fun `should set default formatters 2`() {
        Log.setFormatter(null, formatter)
        Log.setup()
        assertNotEquals(Log.logcatFormatter, logcatFormatter)
        assertNotEquals(Log.formatter, formatter)
    }

    @Test
    fun `should set default formatters 3`() {
        Log.setFormatter(null, null)
        Log.setup()
        assertNotEquals(Log.logcatFormatter, logcatFormatter)
        assertNotEquals(Log.formatter, formatter)
    }

    @Test
    fun `should set default formatters 4`() {
        Log.setFormatter(logcatFormatter, formatter)
        Log.setup()
        assertEquals(Log.logcatFormatter, logcatFormatter)
        assertEquals(Log.formatter, formatter)
    }
}