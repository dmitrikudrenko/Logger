package io.github.dmitrikudrenko.logger.impl

import io.github.dmitrikudrenko.logger.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.lang.IllegalArgumentException
import java.util.concurrent.Executor
import java.util.logging.LogRecord


class FileHandlerTest {
    private val pattern = "pattern"
    private var handler: FileHandler? = null
    private var executor: Executor? = null

    @Before
    fun `set up`() {
        handler = spy(FileHandler())
        executor = mock(Executor::class.java)
        handler?.setExecutor(executor)
        Log.addHandler(handler)
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
        handler?.publish(MOCK_LOG_RECORD)
        verify<Executor>(executor).execute(any())
    }

    @Test
    fun `should do publish be executed if publish`() {
        `make executor sync`(executor!!)
        handler?.publish(MOCK_LOG_RECORD)
        verify<FileHandler>(handler).doPublish(MOCK_LOG_RECORD)
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