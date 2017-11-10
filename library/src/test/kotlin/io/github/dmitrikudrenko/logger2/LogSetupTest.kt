package io.github.dmitrikudrenko.logger2

import io.github.dmitrikudrenko.logger2.impl.AndroidHandler
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.logging.Formatter
import java.util.logging.Handler
import java.util.logging.Logger

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class LogSetupTest {
    private var logger: Logger? = null
    private var handler: Handler? = null

    @Before
    fun `set up`() {
        logger = mock(Logger::class.java)
        handler = mock(Handler::class.java)
        Log.setLogger(logger)
    }

    @After
    fun tearDown() {
        Log.setLogger(null)
    }

    @Test
    fun `should add android handler if setup`() {
        Log.setup()
        verify<Logger>(logger).addHandler(Matchers.any(AndroidHandler::class.java))
    }

    @Test
    fun `should add handler`() {
        Log.addHandler(handler)
        verify<Logger>(logger).addHandler(handler)
    }

    @Test
    fun `should remove handler`() {
        Log.removeHandler(handler)
        verify<Logger>(logger).removeHandler(handler)
    }

    @Test
    fun `should set formatter to new handler`() {
        Log.addHandler(handler)
        verify<Handler>(handler).formatter = Matchers.any(Formatter::class.java)
    }
}
