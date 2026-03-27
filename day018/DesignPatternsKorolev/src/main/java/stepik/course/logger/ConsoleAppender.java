package stepik.course.logger;

public class ConsoleAppender implements LoggerAppender {
    @Override
    public void append(String message) {
        System.out.println(message);
    }
}