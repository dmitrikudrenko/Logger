package io.github.dmitrikudrenko.logger2.impl

import io.github.dmitrikudrenko.logger2.MOCK_MESSAGE
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.concurrent.ExecutorService
import java.util.logging.Level
import java.util.logging.LogRecord

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class FileHandlerTest {
    private var handler: FileHandler? = null
    private var executor: ExecutorService? = null

    @Before
    fun `set up`() {
        handler = FileHandler()
        executor = mock(ExecutorService::class.java)
        handler?.setExecutor(executor)
    }

    @Test
    fun `should service be executed if publish`() {
        handler?.publish(LogRecord(Level.INFO, MOCK_MESSAGE))
        verify<ExecutorService>(executor).execute(any())
    }
}