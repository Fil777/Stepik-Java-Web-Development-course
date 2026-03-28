package stepik.course.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

/**
 * Special class for logging.
 * Object with time mark, severity level and message text
 */
public class LoggerMessage {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
    private final String timeStamp;
    private final String level;
    private final String message;

    /**
     *
     * @implNote Creates object for Logging
     * @param currentTime   message time mark
     * @param logLevel      message severity level from java.util.logging.Level
     * @param message       message text
     */
    public LoggerMessage(LocalDateTime currentTime, Level logLevel, String message) {
        this.timeStamp = currentTime.format(formatter);
        this.level = logLevel.getName();
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return timeStamp + " : " + level + " : " + message;
    }

}
