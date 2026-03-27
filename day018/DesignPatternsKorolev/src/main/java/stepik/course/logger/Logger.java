package stepik.course.logger;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Logger {
    private final String name;
    public final LoggerFilter loggerFilter;
    public List<LoggerAppender> appenders;

    private Logger(String name) {
        this.name = name;
        this.loggerFilter = new LoggerFilter();
        this.appenders = new LinkedList<>();
        this.appenders.add(new BufferAppender());
    }

    private static class LoggerHolder {
        private static final Map<String, Logger> REGISTRY = new ConcurrentHashMap<>();

        private static Logger demaindLogger(String name) {
            return REGISTRY.computeIfAbsent(name, Logger::new);
        }
    }

    public static Logger getInstance(String name) {
        return LoggerHolder.demaindLogger(name);
    }

    public void log(LoggingLEVEL loggingLevel, String message) {
        if (!loggerFilter.filter(loggingLevel)) {
            return;
        }
        Instant timestamp = Instant.now();
        String logRecord = name + ": " + timestamp.toString() + ": " + loggingLevel + ": " + message;
        append(logRecord);
    }

    private void append(String message) {
        appenders.forEach(a -> a.append(message));
    }

    public Stream<String> getLogsHistory() {
        return ((BufferAppender) appenders.getFirst()).getLogsHistory();
    }

    public void setMaxLogsHistory(int size) {
        ((BufferAppender) appenders.getFirst()).setBufferMaxSize(size);
    }

    public static class LoggerFilter {
        private LoggingLEVEL currentLogLevel = LoggingLEVEL.INFO;

        public boolean filter(LoggingLEVEL loggingLevel) {
            return currentLogLevel.ordinal() <= loggingLevel.ordinal();
        }

        public void setCurrentLogLevel(LoggingLEVEL currentLogLevel) {
            this.currentLogLevel = currentLogLevel;
        }
    }

    public void debug(String message) {
        log(LoggingLEVEL.DEBUG, message);
    }

    public void info(String message) {
        log(LoggingLEVEL.INFO, message);
    }

    public void warn(String message) {
        log(LoggingLEVEL.WARN, message);
    }

    public void error(String message) {
        log(LoggingLEVEL.ERROR, message);
    }
}