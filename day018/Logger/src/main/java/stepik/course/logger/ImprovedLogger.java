package stepik.course.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ImprovedLogger implements LoggerInterface {
    private static final Logger globalLogger = Logger.getLogger(Class.class.getName());
    private static final LoggerStorage storage = new LoggerStorage();
    private String name;
    private boolean loadFromFile;

    /**
     * @param name = new logger name
     * @implNote Opens new Logger
     */
    public ImprovedLogger(String name, boolean loadFromFile) {
        if (name.isEmpty() || !name.replaceAll("[^\\p{Alnum}-.]", "").equals(name)) {
            throw new RuntimeException("Incorrect logger name");
        } else {
            this.name = name;
            this.loadFromFile = loadFromFile;
        }
    }

    public ImprovedLogger(String name) {
        this(name, true);
    }

        public void open() {
        String result = storage.openLog(this.name, this.loadFromFile);
        if (result.isEmpty()) {
            globalLogger.log(Level.INFO, "Log '" + this.name + "' opened.");
        } else {
            globalLogger.log(Level.SEVERE, "Opening logger error: " + result);
        }
    }

    /**
     * @implNote Opens default Logger
     */
    public ImprovedLogger() {
        this(storage.defaultLog());
    }

    public String getName() {
        return this.name;
    }

    public boolean logExists(String name) {
        return storage.logExists(name);
    }

    private void log(Level level, String message) {
        if (logExists(this.name)) {
            globalLogger.log(level, message);
            storage.logMessage(this.name, level, message);
        }
    }

    public void logError(String message) {
        log(Level.SEVERE, message);
    }

    public void logWarning(String message) {
        log(Level.WARNING, message);
    }

    public void logInfo(String message) {
        log(Level.INFO, message);
    }

    public String[] getLogHistory() {
        return storage.getMessages(this.name);
    }

    public int numberOfMessages() {
        return storage.getSize(this.name);
    }

    public void setGlobalLoggerLevel(Level level) {
        globalLogger.setLevel(level);
    }

    public void close() {
        String result = storage.closeLog(this.name);
        if (result.isEmpty()) {
            globalLogger.log(Level.INFO, "Log '" + this.name + "' saved and closed.");
        } else {
            globalLogger.log(Level.SEVERE, "Saving log '" + this.name + "' I/O Error: " + result);
        }
    }

}
