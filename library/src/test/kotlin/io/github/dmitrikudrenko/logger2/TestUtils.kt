package io.github.dmitrikudrenko.logger2

import io.github.dmitrikudrenko.logger2.events.LogEvent
import org.mockito.ArgumentMatcher
import java.util.logging.Level
import java.util.logging.LogRecord

val MOCK_TAG = "tag"
val MOCK_MESSAGE = "message"
val MOCK_EXCEPTION = Exception("exception")

val MOCK_EVENT_VALUE = "value"
val MOCK_EVENT = LogEvent { MOCK_EVENT_VALUE }

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