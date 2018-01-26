import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter
import ch.qos.logback.core.status.OnConsoleStatusListener
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender
import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO


final String FILE_APPENDER = "FILE"
final String CONSOLE_APPENDER = "CONSOLE"
final String TIME_STAMP_PATTERN = "%d{[HH:mm:ss]} %m%n"


statusListener(OnConsoleStatusListener)

appender(FILE_APPENDER, FileAppender) {

    file = "app.log"
    append = false
    encoder(PatternLayoutEncoder) {
        pattern = TIME_STAMP_PATTERN
    }
    filter(ThresholdFilter) {
        level = DEBUG
    }
}

appender(CONSOLE_APPENDER, ConsoleAppender) {
    target = System.out
    encoder(PatternLayoutEncoder) {
        pattern = TIME_STAMP_PATTERN
    }
    filter(ThresholdFilter) {
        level = INFO
    }
}

root(DEBUG, [FILE_APPENDER, CONSOLE_APPENDER])