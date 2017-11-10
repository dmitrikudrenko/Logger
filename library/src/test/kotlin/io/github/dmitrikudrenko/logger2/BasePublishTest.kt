package io.github.dmitrikudrenko.logger2

import org.junit.Before
import org.mockito.Mockito
import java.util.logging.Handler

abstract class BasePublishTest {
    var handler: Handler? = null

    @Before
    fun setup() {
        handler = Mockito.mock(Handler::class.java)
        Log.addHandler(handler)
    }
}