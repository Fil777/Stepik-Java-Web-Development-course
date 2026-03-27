package database;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDataProcessor<T> implements DataBaseInterface<T> {
    private final Path path;
    private final char mode;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private String status;
    private String message;
    private Logger logger;

    private String logMessage(String message){
        return message.isEmpty() ? status : status + ": " + message;
    }
    private void logWarning(String message) {
        logger.log(Level.WARNING, logMessage(message));
    }
    private void logStandard(String message) {
        logger.log(Level.INFO, logMessage(message));
    }

    public FileDataProcessor(String connect, char mode, Logger logger) {
        this.path = Paths.get(connect);
        this.mode = mode;
        this.status = "Initialized";
        this.message = "";
        this.logger = logger;
    }

    public String getDBStatus() {
        return this.status;
    }

    public String getDBMessage() {
        return message;
    }

    public void openDB() {
        if (mode == 'R') {
            oos = null;
            try {
                ois = new ObjectInputStream(Files.newInputStream(path));
            } catch (IOException e) {
                ois = null;
                status = "Exception";
                message = e.getMessage();
                logWarning(message);
            }
            status = "Opened(R)";
            message = "";
            logStandard(message);
        } else if (mode == 'W') {
            ois = null;
            try {
                oos = new ObjectOutputStream(Files.newOutputStream(path));
            } catch (IOException e) {
                oos = null;
                status = "Exception";
                message = e.getMessage();
                logWarning(message);
            }
            status = "Opened(W)";
            message = "";
            logStandard(message);
        } else {
            status = "Error";
            message = "Open failed. DB mode incorrect!";
            logWarning(message);
        }
    }

    public T readDBRecord() {
        T record;
        if (ois == null) {
            status = "Fail";
            message = "ObjectInputStream = null";
            record = null;
            logWarning(message);
        } else {
            try {
                record = (T) ois.readObject();
                status = "Read";
                message = "";
                logStandard(message);
            } catch (EOFException e) {
                status = "End of file";
                message = '"' + path.toString() + '"';
                record = null;
                logWarning(message);
            } catch (IOException | ClassNotFoundException | NullPointerException e) {
                status = "Exception";
                message = e.getMessage();
                record = null;
                logWarning(message);
            }
        }
        return record;
    }

    public T readDBRecord(String recordId) {
        // игнор id записи, это файл.
        return readDBRecord("");
    }

    public void saveDBRecord(T record) {
        if (oos == null) {
            status = "Fail";
            message = "ObjectOutputStream = null";
            logWarning(message);
        } else {
            try {
                oos.writeObject(record);
                status = "Written";
                message = "";
                logStandard(message);
            } catch (IOException e) {
                status = "Exception";
                message = e.getMessage();
                logWarning(message);
            }
        }
    }

    public void saveDBRecord(String recordId, T record) {
        // игнор id записи, это файл.
        saveDBRecord(record);
    }

    public void closeDB() {
        if (mode == 'R') {
            try {
                if (ois != null) {
                    ois.close();
                    status = "Closed(R)";
                    message = "";
                    logStandard(message);
                } else {
                    status = "Info";
                    message = "ObjectInputStream = null";
                }
            } catch (IOException e) {
                status = "Exception";
                message = e.getMessage();
                logWarning(message);
            }
        } else if (mode == 'W') {
            try {
                if (oos != null) {
                    oos.close();
                    status = "Closed(W)";
                    message = "";
                    logStandard(message);
                } else {
                    status = "Info";
                    message = "ObjectOutputStream = null";
                }
            } catch (IOException e) {
                status = "Exception";
                message = e.getMessage();
                logWarning(message);
            }
        } else {
            status = "Error";
            message = "Close failed. DB mode incorrect!";
            logWarning(message);
        }
    }
}