package stepik.course.logger;

public interface LoggerInterface {
    void open();
    void close();
    void logError(String message);
    void logWarning(String message);
    void logInfo(String message);
    String[] getLogHistory();
}
