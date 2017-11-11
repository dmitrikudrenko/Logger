package io.github.dmitrikudrenko.logger2

import org.junit.After
import org.junit.Before
import org.mockito.Mockito.mock
import java.util.logging.Handler

abstract class BasePublishTest {
    var handler: Handler? = null
    var androidHandler: Handler? = null

    @Before
    fun `set up`() {
        handler = mock(Handler::class.java)
        androidHandler = mock(Handler::class.java)
        Log.setDefaultHandler(androidHandler)
        Log.setup()
        Log.addHandler(handler)
    }

    @After
    fun `tear down`() {
        Log.setDefaultHandler(null)
    }
}