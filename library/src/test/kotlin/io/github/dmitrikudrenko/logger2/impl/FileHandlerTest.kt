package io.github.dmitrikudrenko.logger2.impl

import io.github.dmitrikudrenko.logger2.Log
import io.github.dmitrikudrenko.logger2.MOCK_MESSAGE
import io.github.dmitrikudrenko.logger2.MOCK_TAG
import io.github.dmitrikudrenko.logger2.`make executor sync`
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.lang.IllegalArgumentException
import java.util.concurrent.Executor
import java.util.logging.Level
import java.util.logging.LogRecord


@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class FileHandlerTest {
    private val pattern = "pattern"
    private var handler: FileHandler? = null
    private var executor: Executor? = null
    private var logRecord: LogRecord? = null

    @Before
    fun `set up`() {
        handler = spy(FileHandler())
        executor = mock(Executor::class.java)
        handler?.setExecutor(executor)
        Log.addHandler(handler)
        logRecord = LogRecord(Level.INFO, MOCK_MESSAGE)
    }

    @After
    fun `tear down`() {
        handler?.setExecutor(null)
    }

    @Test
    fun `should handler be published if event`() {
        Log.i(MOCK_TAG, MOCK_MESSAGE)
        verify<FileHandler>(handler).publish(any(LogRecord::class.java))
    }

    @Test
    fun `should service be executed if publish`() {
        handler?.publish(logRecord)
        verify<Executor>(executor).execute(any())
    }

    @Test
    fun `should do publish be executed if publish`() {
        `make executor sync`(executor!!)
        handler?.publish(logRecord)
        verify<FileHandler>(handler).doPublish(logRecord)
    }

    @Test
    fun `test constructors`() {
        FileHandler(pattern)
        FileHandler(pattern, true)
        FileHandler(pattern, 1, 1)
        FileHandler(pattern, 1, 1, true)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should not empty pattern be accepted`() {
        FileHandler("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should not negative limit be accepted`() {
        FileHandler(pattern, -1, 1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should not 0 count be accepted`() {
        FileHandler(pattern, 1, 0)
    }
}