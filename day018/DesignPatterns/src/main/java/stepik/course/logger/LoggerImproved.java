package stepik.course.logger;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerImproved {
    private static final Logger globalLogger = Logger.getLogger(Class.class.getName());
    private static final LoggerStorage storage = new LoggerStorage();
    private String name;

    /**
     * @implNote Opens new Logger
     * @param name = new logger name
     */
    public LoggerImproved(String name) {
        this.name = name;
        storage.openLog(name);
    }

    /**
     * @implNote Opens default Logger
     */
    public LoggerImproved(){
        this(storage.defaultLog());
    }

    public String getName(){
        return this.name;
    }

    public boolean logExists(String name){
        return storage.logExists(name);
    }

    private void log(Level level, String message){
        globalLogger.log(level , message);
        storage.logMessage(this.name, new LoggerMessage(LocalDateTime.now(), level, message));
    }

    public void logError(String message){
        log(Level.SEVERE, message);
    }

    public void logWarning(String message){
        log(Level.WARNING, message);
    }

    public void logInfo(String message){
        log(Level.INFO, message);
    }

    public LoggerMessage[] getMessages(){
        return storage.getMessages(this.name);
    }

    public int numberOfMessages(){
        return storage.getSize(this.name);
    }

    public void setGlobalLoggerLevel(Level level){
        globalLogger.setLevel(level);
    }


}
