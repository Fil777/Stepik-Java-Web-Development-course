package database;

public interface DataBaseInterface<T> {

    void openDB();

    T readDBRecord(String recordId);

    T readDBRecord();

    void saveDBRecord(String recordId, T record);

    void saveDBRecord(T record);

    void closeDB();

    String getDBMessage();

    String getDBStatus();

}
