package stepik.course;

import stepik.course.logger.*;

public class DemoLogger {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance("logger1");
        Logger logger2 = Logger.getInstance("logger2");

        logger2.loggerFilter.setCurrentLogLevel(LoggingLEVEL.DEBUG);
        logger2.error("error message 1");
        logger2.debug("debug message 2");
        logger2.setMaxLogsHistory(1);
        logger2.warn("warn message 3");
        logger1.info("info message 1");
        logger1.appenders.add(new ConsoleAppender());
        logger1.warn("warn message 2");
        logger1.error("error message 3");
        logger1.debug("debug message 4");
        logger1.loggerFilter.setCurrentLogLevel(LoggingLEVEL.DEBUG);
        logger1.debug("debug message 4-2");

        System.out.println();
        System.out.println("logger2 history: ");
        logger2.getLogsHistory().forEach(System.out::println);

        logger2.appenders.add(new FileAppender("logger2.log"));
        logger2.error("error message 2");

    }
}