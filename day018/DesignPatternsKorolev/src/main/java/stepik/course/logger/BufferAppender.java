package stepik.course.logger;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class BufferAppender implements LoggerAppender {
    private int maxBufferSize = Integer.MAX_VALUE - 1;
    private List<String> buffer = new LinkedList<>();

    @Override
    public void append(String message) {
        buffer.add(message);
        if (buffer.size() > maxBufferSize) {
            buffer.removeFirst();
        }
    }

    public Stream<String> getLogsHistory() {
        return buffer.stream();
    }

    public void setBufferMaxSize(int size) {
        this.maxBufferSize = size;
        while (buffer.size() > size) {
            buffer.removeFirst();
        }
    }
}