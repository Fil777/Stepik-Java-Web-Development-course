package database;

import model.PersonInterfaceObject;
import model.Person;
import repository.PersonRepository;

import java.util.logging.Logger;

public class FileRepositoryReader {
    private FileDataProcessor<PersonInterfaceObject> PioReadFile;
    private PersonRepository repository;

    public FileRepositoryReader(String fileName, PersonRepository repository, Logger logger) {
        PioReadFile = new FileDataProcessor<>(fileName, 'R', logger);
        this.repository = repository;
    }

    public void open() {
        PioReadFile.openDB();
    }

    public void read() {
        while (true) {
            PersonInterfaceObject pio = PioReadFile.readDBRecord();
            if (pio == null) break;
            Person person = pio.PioToPerson();
            repository.add(person);
        }
    }

    public void close() {
        PioReadFile.closeDB();
    }

    public void execute() {
        open();
        read();
        close();
    }

}
