package io.github.dmitrikudrenko.logger

import io.github.dmitrikudrenko.logger.events.LogEvent
import org.mockito.ArgumentMatcher
import org.mockito.Mockito
import org.mockito.Mockito.mock
import java.util.concurrent.Executor
import java.util.logging.Level
import java.util.logging.LogRecord

val MOCK_TAG = "tag"
val MOCK_LONG_TAG = "Long long long long long tag"
val MOCK_MESSAGE = "message"
val MOCK_EXCEPTION = Exception("exception")

val MOCK_EVENT_VALUE = "value"
val MOCK_EVENT = LogEvent { MOCK_EVENT_VALUE }

val MOCK_LEVEL = mock(Level::class.java)

val MOCK_LOG_RECORD = LogRecord(MOCK_LEVEL, MOCK_MESSAGE).apply { this.loggerName = MOCK_TAG }
val MOCK_LONG_LOG_RECORD = LogRecord(MOCK_LEVEL, MOCK_MESSAGE).apply { this.loggerName = MOCK_LONG_TAG }
val MOCK_LOG_RECORD_W_ERROR = LogRecord(MOCK_LEVEL, MOCK_MESSAGE).apply { this.thrown = MOCK_EXCEPTION }

class LogRecordMatcher(private val level: Level,
                       private val tag: String,
                       private val message: String,
                       private val exception: Exception? = null) : ArgumentMatcher<LogRecord>() {
    override fun matches(argument: Any?): Boolean {
        if (argument is LogRecord) {
            return argument.level == level
                    && argument.loggerName == tag
                    && argument.message == message
                    && argument.thrown == exception
        }
        return false
    }
}

fun `make executor sync`(executor: Executor) {
    Mockito.doAnswer { invocation ->
        (invocation.arguments[0] as Runnable).run()
        null
    }.`when`(executor).execute(Mockito.any(Runnable::class.java))
}