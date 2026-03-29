package stepik.course;

import stepik.course.logger.ImprovedLogger;

import java.util.logging.Level;

public class LoggerDemo {
    public static void main(String[] args) {

        ImprovedLogger myLogger1 = new ImprovedLogger();
        myLogger1.open();
        myLogger1.logError("error11");
        myLogger1.logWarning("warning12");
        myLogger1.logInfo("info13");

        for (String msg : myLogger1.getLogHistory()){ System.out.println(msg); }

        myLogger1.close();

        System.out.println("---");
        myLogger1.logInfo("info14");
        for (String msg : myLogger1.getLogHistory()){ System.out.println(msg); }
        System.out.println("===");

        myLogger1.setGlobalLoggerLevel(Level.OFF);

        ImprovedLogger myLogger2 = new ImprovedLogger("logger-special", false);

        myLogger2.open();

        for (int i = 21; i < 31; i++) {
            myLogger2.logError("error"+i);
        }

        for (String msg : myLogger2.getLogHistory()){ System.out.println(msg); }

        myLogger2.close();
    }
}