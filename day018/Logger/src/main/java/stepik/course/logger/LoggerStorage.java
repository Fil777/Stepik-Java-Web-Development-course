package stepik.course.logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public class LoggerStorage implements Serializable {
    private static HashMap<String, ArrayDeque<String>> storage = new HashMap<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
    private static final int arrayMaxSize = 500;

    protected LoggerStorage(String logName) {
        openLog(logName);
    }

    protected LoggerStorage() {
        openLog(defaultLog());
    }

    protected boolean logExists(String logName) {
        return storage.containsKey(logName);
    }

    protected String defaultLog() {
        return "default";
    }

    protected String openLog(String logName, boolean loadFromFile) {
        if (logExists(logName)) {
            return "";
        } else {
            storage.put(logName, new ArrayDeque<>());
        }
        String result = null;
        if (loadFromFile) {
            result = readLog(logName);
        }
        storage.get(logName).add(String.format("%s : %s : Log '%s' is opened.",
                LocalDateTime.now().format(formatter), Level.INFO, logName));
        if (result == null) {
            result = "";
        } else if (result.isEmpty()) {
            storage.get(logName).add(String.format("%s : %s : Log '%s' loaded from file.",
                    LocalDateTime.now().format(formatter), Level.INFO, logName));
        }
        return result;
    }

    protected String openLog(String logName) {
        return openLog(logName, true);
    }

    protected void logMessage(String logName, Level level, String message) {
        if (message == null || logName == null) return;
        String name = logName.isEmpty() ? defaultLog() : logName;
        if (!logExists(name)) return;
        storage.get(logName).add(String.format("%s : %s : %s",
                LocalDateTime.now().format(formatter), level, message));
        while (storage.get(name).size() > arrayMaxSize) {
            storage.get(name).pop();
        }
    }

    protected String closeLog(String logName) {
        if (!logExists(logName) || logName.isEmpty()) return "";
        storage.get(logName).add(String.format("%s : %s : Log '%s' is closed.",
                LocalDateTime.now().format(formatter), Level.INFO, logName));
        String result = writeLog(logName);
        storage.remove(logName);
        return result;
    }

    protected void logMessage(Level level, String message) {
        logMessage(defaultLog(), level, message);
    }

    protected int getSize(String name) {
        return storage.get(name).size();
    }

    /**
     *
     * @param logName Logger name
     * @return array of logger messages (String[])
     */
    protected String[] getMessages(String logName) {
        if (logExists(logName)) {
            return storage.get(logName).toArray(new String[0]);
        } else {
            return new String[0];
        }
    }

    private String fileName(String logName) {
        return "Log-" + logName.trim() + ".txt";
    }

    private String writeLog(String logName) {
        if (!logExists(logName)) {
            return "";
        }
        try {
            Files.write(Paths.get(fileName(logName)),
                    storage.get(logName));
            return "";
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    private String readLog(String logName) {
        if (!logExists(logName)) {
            return "Log '" + logName + "' not exists, can not read file.";
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName(logName)));
            for (String line : lines) {
                storage.get(logName).add(line);
            }
            return "";
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return "I/O Exception: " + e.getMessage();
        }

    }

}
