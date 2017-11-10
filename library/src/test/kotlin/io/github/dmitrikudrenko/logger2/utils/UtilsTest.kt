package io.github.dmitrikudrenko.logger2.utils

import io.github.dmitrikudrenko.logger2.MOCK_EXCEPTION
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class UtilsTest {
    @Test
    fun `should convert throwable to string`() {
        val exceptionStr = Utils.toString(MOCK_EXCEPTION)
        Assert.assertTrue(exceptionStr.startsWith("java.lang.Exception: exception"))
    }

    @Test
    fun `should return empty string if null throwable`() {
        Assert.assertEquals("", Utils.toString(null))
    }
}
