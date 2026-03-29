package stepik.course.logger;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.logging.Level;

public class LoggerStorage implements Serializable {
    private static final HashMap<String, ArrayDeque<LoggerMessage>> storage = new HashMap<>();
    private static final int arrayMaxSize = 3;

    protected LoggerStorage() {
        openLog(defaultLog());
    }

    protected boolean logExists(String logName) {
        return storage.containsKey(logName);
    }

    protected String defaultLog() {
        return "default";
    }

    protected void openLog(String logName) {
        if (logExists(logName) || logName.isEmpty()) return;
        storage.computeIfAbsent(logName, k -> new ArrayDeque<>())
                .add(new LoggerMessage(LocalDateTime.now(), Level.INFO, "Log '" + logName + "' opened"));
    }

    protected void logMessage(String logName, LoggerMessage message) {
        if (message == null || logName == null) return;
        String name = logName.isEmpty() ? defaultLog() : logName;
        storage.computeIfAbsent(name, k -> new ArrayDeque<>()).add(message);
        if (storage.get(name).size() > arrayMaxSize) {
            storage.get(name).pop();
        }
    }

    protected void logMessage(LoggerMessage message) {
        logMessage(defaultLog(), message);
    }

    protected int getSize(String name) {
        return storage.get(name).size();
    }

    /**
     *
     * @param name Logger name
     * @return array of logger messages (LoggerMessage[])
     */
    protected LoggerMessage[] getMessages(String name) {
        if (logExists(name)) {
            return storage.get(name).toArray(new LoggerMessage[0]);
        } else {
            return new LoggerMessage[]{};
        }
    }

}
