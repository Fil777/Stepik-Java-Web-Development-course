package database;

import model.PersonInterfaceObject;
import model.Person;
import repository.PersonRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FileRepositoryWriter {
    private FileDataProcessor<PersonInterfaceObject> DaoWriteFile;
    private PersonRepository repository;

    public FileRepositoryWriter(String fileName, PersonRepository repository, Logger logger){
        DaoWriteFile = new FileDataProcessor<>(fileName, 'W', logger);
        this.repository = repository;
    }

    public void open() {
        DaoWriteFile.openDB();
    }

    public void write() {
        for (Person person : repository.getAll()) {
            PersonInterfaceObject dao = new PersonInterfaceObject(person);
            DaoWriteFile.saveDBRecord(dao);
        }
    }

    public void close() {
        DaoWriteFile.closeDB();
    }

    public void execute(){
        open();
        write();
        close();
    }

}
