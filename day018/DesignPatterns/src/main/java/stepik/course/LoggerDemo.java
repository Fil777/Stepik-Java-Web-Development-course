package stepik.course;

import stepik.course.logger.LoggerImproved;
import stepik.course.logger.LoggerMessage;

import java.util.logging.Level;

public class LoggerDemo {
    public static void main(String[] args) {

        LoggerImproved myLogger1 = new LoggerImproved();
        myLogger1.logError("error11");
        myLogger1.logWarning("warning12");
        myLogger1.logInfo("info13");

        myLogger1.setGlobalLoggerLevel(Level.OFF);

        LoggerImproved myLogger2 = new LoggerImproved("logger1");
        myLogger2.logError("error21");
        myLogger2.logWarning("warning22");
        myLogger2.logInfo("info23");
        myLogger2.logError("error24");
        myLogger2.logWarning("warning25");
        myLogger2.logInfo("info26");

        for (LoggerMessage msg : myLogger2.getMessages()){
            System.out.println(msg);
        }
    }
}