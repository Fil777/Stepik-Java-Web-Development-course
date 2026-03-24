package ui;

import database.DataManager;
import model.Instructor;
import model.Person;
import model.Staff;
import model.Student;
import printer.ConsoleListDataPrinter;
import repository.ListBasedPersonRepository;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class UserInteface {

    public void start(
            Scanner scanner,
            ConsoleListDataPrinter dataPrinter,
            ListBasedPersonRepository personRepository) {

        try {
            personRepository.add(DataManager.readData());
            Terminal.writeLine("Данные считаны из файла");
        } catch (NoSuchFileException e) {
            Terminal.writeNewLine("Новая база данных: " + e);
        } catch (IOException e) {
            Terminal.writeNewLine("Проблема работы с файлом данных: " + e.getMessage());
            return;
        } catch (Exception e) {
            Terminal.writeNewLine("Проблема выполнения: " + e.getMessage());
            return;
        }

        Terminal.writeNewLine("Начало работы, здравствуйте!");

        while (true) {
            char choice = getChoiceMainMenu(scanner);
            switch (choice) {
                case '1':
                    char choice1 = getChoicePersonsMenu(scanner);
                    int newId = 0;
                    switch (choice1) {
                        case '1':
                            Terminal.writeLine("Введите имя сотрудника:");
                            String staffName = scanner.next();
                            Terminal.writeLine("Введите возраст сотрудника:");
                            int staffAge = scanner.nextInt();
                            Terminal.writeLine("Введите зарплату сотрудника:");
                            double staffSalary = scanner.nextDouble();
                            Staff newStaff = new Staff(staffName, staffAge, staffSalary);
                            personRepository.add(newStaff);
                            newId = newStaff.getId();
                            break;
                        case '2':
                            Terminal.writeLine("Введите имя преподавателя:");
                            String teacherName = scanner.next();
                            Terminal.writeLine("Введите возраст преподавателя:");
                            int teacherAge = scanner.nextInt();
                            Terminal.writeLine("Введите предмет преподавателя:");
                            String teacherSubject = scanner.next();
                            Instructor newTeacher = new Instructor(teacherName, teacherAge, teacherSubject);
                            personRepository.add(newTeacher);
                            newId = newTeacher.getId();
                            break;
                        case '3':
                            Terminal.writeLine("Введите имя учащегося:");
                            String studentName = scanner.next();
                            Terminal.writeLine("Введите возраст учащегося:");
                            int studentAge = scanner.nextInt();
                            Terminal.writeLine("Введите название школы учащегося:");
                            String studentSchool = scanner.next();
                            Student newStudent = new Student(studentName, studentAge, studentSchool);
                            personRepository.add(newStudent);
                            newId = newStudent.getId();
                            break;
                        default:
                            Terminal.writeLine("Неверный выбор. Пожалуйста, попробуйте снова.");
                            break;
                    }
                    Terminal.writeLine("Добавлен человек. ID = " + newId) ;
                    break;
                case '2':
                    Terminal.writeLine("Введите ID человека для удаления:");
                    int deleteId = scanner.nextInt();
                    if (deleteId == personRepository.removeById(deleteId)){
                        Terminal.writeLine("Человек с ID " + deleteId + " удалён.");
                    } else {
                        Terminal.writeLine("Человек не найден.");
                    }
                    break;
                case '3':
                    Terminal.writeLine("Введите ID человека для поиска:");
                    int searchId = scanner.nextInt();
                    Person foundPersonById = personRepository.findById(searchId);
                    if (foundPersonById != null) {
                        Terminal.writeLine(foundPersonById.toString());
                    } else {
                        Terminal.writeLine("Человек не найден.");
                    }
                    break;
                case '4':
                    dataPrinter.displayAll(personRepository);
                    break;
                case '0':
                    Terminal.writeNewLine("Завершение работы. До свидания!");
                    try {
                        DataManager.saveData(personRepository.getAll());
                        Terminal.writeNewLine("Данные сохранены в файле");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
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
