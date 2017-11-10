package io.github.dmitrikudrenko.logger2

import io.github.dmitrikudrenko.logger2.impl.AndroidHandler
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.logging.Formatter
import java.util.logging.Handler

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class LogFormatterTest {
    private var handler: Handler? = null
    private var androidHandler: AndroidHandler? = null
    private var logcatFormatter: Formatter? = null
    private var formatter: Formatter? = null

    @Before
    fun `set up`() {
        handler = mock(Handler::class.java)
        androidHandler = mock(AndroidHandler::class.java)
        logcatFormatter = mock(Formatter::class.java)
        formatter = mock(Formatter::class.java)

        Log.setDefaultHandler(androidHandler)
        Log.setFormatter(logcatFormatter, formatter)
    }

    @After
    fun `tear down`() {
        Log.setDefaultHandler(null)
        Log.setFormatter(null, null)
    }

    @Test
    fun `should set logcat formatter if setup`() {
        Log.setup()
        verify<AndroidHandler>(androidHandler).formatter = logcatFormatter
    }
}