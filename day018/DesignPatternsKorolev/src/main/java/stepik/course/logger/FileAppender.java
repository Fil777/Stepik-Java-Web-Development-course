package stepik.course.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileAppender implements LoggerAppender {
    private final Path path;

    public FileAppender(String fileName) {
        this.path = resolvePath(fileName);
    }

    private Path resolvePath(String fileName) {
        Path path = Path.of(fileName).toAbsolutePath();
        if (Files.exists(path) && Files.isRegularFile(path)) {
            return path;
        }
        if (path.getParent() != null && Files.isDirectory(path.getParent())) {
            try {
                return Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Can't create log file " + path);
                return null;
            }
        }
        System.out.println("Wrong file name " + path);
        return null;
    }

    @Override
    public void append(String message) {
        if (path == null) {
            return;
        }
        try {
            Files.writeString(path, message + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Can't write to log file " + path);
        }
    }
}