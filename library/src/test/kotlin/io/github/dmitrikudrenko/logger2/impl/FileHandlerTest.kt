package io.github.dmitrikudrenko.logger2.impl

import io.github.dmitrikudrenko.logger2.MOCK_MESSAGE
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.util.concurrent.Executor
import java.util.logging.Level
import java.util.logging.LogRecord


@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class FileHandlerTest {
    private var handler: FileHandler? = null
    private var executor: Executor? = null
    private var logRecord: LogRecord? = null

    @Before
    fun `set up`() {
        handler = spy(FileHandler())
        executor = mock(Executor::class.java)
        handler?.setExecutor(executor)
        logRecord = LogRecord(Level.INFO, MOCK_MESSAGE)
    }

    @After
    fun `tear down`() {
        handler?.setExecutor(null)
    }

    @Test
    fun `should service be executed if publish`() {
        handler?.publish(logRecord)
        verify<Executor>(executor).execute(any())
    }

    @Test
    fun `should do publish be executed if publish`() {
        implementAsDirectExecutor(executor!!)
        handler?.publish(logRecord)
        verify<FileHandler>(handler).doPublish(logRecord)
    }

    private fun implementAsDirectExecutor(executor: Executor) {
        doAnswer { invocation ->
            (invocation.arguments[0] as Runnable).run()
            null
        }.`when`(executor).execute(any(Runnable::class.java))
    }
}