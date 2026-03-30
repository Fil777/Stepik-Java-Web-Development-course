package ru.ksergey.singleton.exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    // Перечисление уровней логирования
    public enum LogLevel {
        DEBUG, INFO, WARNING, ERROR
    }

    // Приватный статический экземпляр класса (Singleton)
    private static Logger instance;

    // Максимальный размер истории логов
    private static final int MAX_LOG_HISTORY = 100;

    // Список для хранения логов
    private final List<LogEntry> logHistory;

    // Файл для сохранения логов
    private static final String LOG_FILE = "shop_logs.txt";

    // Приватный конструктор для предотвращения создания экземпляров
    private Logger() {
        this.logHistory = new ArrayList<>();
    }

    public static /* synchronized */ Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private static class LogEntry {
        private LocalTime timestamp;
        private LogLevel level;
        private String message;

        public LogEntry(LogLevel level, String message) {
            this.timestamp = LocalTime.now();
            this.level = level;
            this.message = message;
        }

        @Override
        public String toString() {
            return String.format("[%s] %s: %s",
                    timestamp.format(DateTimeFormatter.ISO_LOCAL_TIME),
                    level,
                    message);
        }
    }

    // Метод логирования с указанием уровня
    private void log(LogLevel level, String message) {
        LogEntry entry = new LogEntry(level, message);

        // Добавление записи в историю
        logHistory.add(entry);

        // Ограничение размера истории
        if (logHistory.size() > MAX_LOG_HISTORY) {
            logHistory.removeFirst();
        }

        // Сохранение в файл
        saveToFile(entry);
    }

    // Методы логирования для разных уровней
    public void logDebug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void logInfo(String message) {
        log(LogLevel.INFO, message);
    }

    public void logWarning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void logError(String message) {
        log(LogLevel.ERROR, message);
    }

    // Получение полной истории логов
    public List<String> getLogHistory() {
        List<String> logs = new ArrayList<>();
        for (LogEntry entry : logHistory) {
            logs.add(entry.toString());
        }
        return logs;
    }

    // Получение логов определенного уровня
    public List<String> getLogsByLevel(LogLevel level) {
        List<String> filteredLogs = new ArrayList<>();
        for (LogEntry entry : logHistory) {
            if (entry.level == level) {
                filteredLogs.add(entry.toString());
            }
        }
        return filteredLogs;
    }

    // Сохранение лога в файл
    private void saveToFile(LogEntry entry) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(LOG_FILE,
                        true))) {
            writer.println(entry.toString());
        } catch (IOException e) {
            System.err.println("Ошибка при записи лога в файл: " + e.getMessage());
        }
    }

    // Очистка истории логов
    public void clearLogs() {
        logHistory.clear();
    }
}
