package ui;

import database.FileRepositoryReader;
import database.FileRepositoryWriter;
import model.PersonInterfaceObject;
import model.PersonType;
import printer.ConsoleListDataPrinter;
import repository.ListBasedPersonRepository;
//import repository.ArrayBasedPersonRepository;
import utils.IdGenerator;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInteraction {

    public void start(
            Scanner scanner,
            ConsoleListDataPrinter dataPrinter,
            ListBasedPersonRepository personRepository,
            Logger logger)
    {
        FileRepositoryReader reader = new FileRepositoryReader("persons.bin", personRepository, logger);
        reader.execute();
        IdGenerator.setID(personRepository.maxId()+1);

//        try {
//            personRepository.add(DataManager.readData());
//            Terminal.writeLine("Данные считаны из файла");
//        } catch (NoSuchFileException e) {
//            Terminal.writeNewLine("Новая база данных: " + e);
//        } catch (IOException e) {
//            Terminal.writeNewLine("Проблема работы с файлом данных: " + e.getMessage());
//            return;
//        } catch (Exception e) {
//            Terminal.writeNewLine("Проблема выполнения: " + e.getMessage());
//            return;
//        }

        Terminal.writeNewLine("Начало работы, здравствуйте!");

        while (true) {
            char choice = getChoiceMainMenu(scanner);
            switch (choice) {
                case '1':
                    char choice1 = getChoicePersonsMenu(scanner);
                    PersonInterfaceObject pio = null;
                    switch (choice1) {
                        case '1':
                            // запрашиваем параметры человека
                            Terminal.writeLine("Введите имя сотрудника:");
                            String staffName = scanner.next();
                            Terminal.writeLine("Введите возраст сотрудника:");
                            int staffAge = scanner.nextInt();
                            Terminal.writeLine("Введите зарплату сотрудника:");
                            double staffSalary = scanner.nextDouble();
                            // создаём объект для передачи
                            pio = new PersonInterfaceObject(PersonType.STAFF);
                            pio.setId(IdGenerator.generateId());
                            pio.setName(staffName);
                            pio.setAge(staffAge);
                            pio.setSalary(staffSalary);
                            break;
                        case '2':
                            // запрашиваем параметры человека
                            Terminal.writeLine("Введите имя преподавателя:");
                            String teacherName = scanner.next();
                            Terminal.writeLine("Введите возраст преподавателя:");
                            int teacherAge = scanner.nextInt();
                            Terminal.writeLine("Введите предмет преподавателя:");
                            String teacherSubject = scanner.next();
                            // создаём объект для передачи
                            pio = new PersonInterfaceObject(PersonType.INSTRUCTOR);
                            pio.setId(IdGenerator.generateId());
                            pio.setName(teacherName);
                            pio.setAge(teacherAge);
                            pio.setSubject(teacherSubject);
                            break;
                        case '3':
                            // запрашиваем параметры человека
                            Terminal.writeLine("Введите имя учащегося:");
                            String studentName = scanner.next();
                            Terminal.writeLine("Введите возраст учащегося:");
                            int studentAge = scanner.nextInt();
                            Terminal.writeLine("Введите название школы учащегося:");
                            String studentSchool = scanner.next();
                            // создаём объект для передачи
                            pio = new PersonInterfaceObject(PersonType.STUDENT);
                            pio.setId(IdGenerator.generateId());
                            pio.setName(studentName);
                            pio.setAge(studentAge);
                            pio.setSubject(studentSchool);
                            break;
                        default:
                            Terminal.writeLine("Неверный выбор. Пожалуйста, попробуйте снова.");
                            break;
                    }
                    // создаём объект в репозитарии
                    if (pio != null) {
                        personRepository.add(pio.PioToPerson());
                        Terminal.writeLine("Добавлен " + pio.getName() + ", ID = " + pio.getId());
                    }
                    break;
                case '2':
                    Terminal.writeLine("Введите ID человека для удаления:");
                    int deleteId = scanner.nextInt();
                    if (deleteId == personRepository.removeById(deleteId)) {
                        Terminal.writeLine("Человек с ID " + deleteId + " удалён.");
                    } else {
                        Terminal.writeLine("Человек не найден.");
                    }
                    break;
                case '3':
                    Terminal.writeLine("Введите ID человека для поиска:");
                    int searchId = scanner.nextInt();
                    PersonInterfaceObject foundById = new PersonInterfaceObject(personRepository.findById(searchId));
                    if (foundById != null) {
                        Terminal.writeLine(foundById.toString());
                    } else {
                        Terminal.writeLine("Человек не найден.");
                    }
                    break;
                case '4':
                    dataPrinter.displayAll(personRepository);
                    break;
                case '0':
                    Terminal.writeNewLine("Завершение работы. До свидания!");
                    FileRepositoryWriter writer = new FileRepositoryWriter("persons.bin", personRepository, logger);
                    writer.execute();
                    return;
                default:
                    Terminal.writeLine("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        }

    }

    private char getChoiceMainMenu(Scanner scanner) {
        Terminal.writeNewLine("1. Добавить человека");
        Terminal.writeLine("2. Удалить человека");
        Terminal.writeLine("3. Найти человека");
        Terminal.writeLine("4. Показать всех людей");
        Terminal.writeLine("0. Выйти");
        Terminal.writeLine();

        while (true) {
            Terminal.write("Введите ваш выбор: ");
            char choice = scanner.next().charAt(0);
            scanner.nextLine();
            if ("12340".indexOf(choice) < 0) {
                Terminal.writeLine("Неверный ввод. Пожалуйста, попробуйте снова.");
            } else {
                return choice;
            }
        }
    }

    private char getChoicePersonsMenu(Scanner scanner) {
        Terminal.writeLine("\tУточните:");
        Terminal.writeLine("\t1 - Сотрудник");
        Terminal.writeLine("\t2 - Преподаватель");
        Terminal.writeLine("\t3 - Учащийся");

        while (true) {
            Terminal.write("Добавление человека. Введите ваш выбор: ");
            char choice = scanner.next().charAt(0);
            scanner.nextLine();

            if ("123".indexOf(choice) < 0) {
                Terminal.writeLine("Неверный ввод. Пожалуйста, попробуйте снова.");
            } else {
                return choice;
            }
        }
    }

}
