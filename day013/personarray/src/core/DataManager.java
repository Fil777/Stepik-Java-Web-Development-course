package core;

import java.util.Scanner;

public class DataManager {

    ArrayBasedPersonRepository personRepository = new ArrayBasedPersonRepository(100);
    ConsoleArrayDataPrinter dataPrinter = new ConsoleArrayDataPrinter();
    Scanner scanner = new Scanner(System.in);

    public void start() {

        Terminal.writeNewLine("Начало работы, здравствуйте!");

        while (true) {
            char choice = getChoiceMainMenu();
            switch (choice) {
                case '1':
                    char choice1 = getChoicePersonsMenu();
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
                            break;
                        default:
                            Terminal.writeLine("Неверный выбор. Пожалуйста, попробуйте снова.");
                            break;
                    }
                    break;
                case '2':
                    Terminal.writeLine("Введите ID человека для удаления:");
                    int deleteId = scanner.nextInt();
                    Person deletePersonById = personRepository.findById(deleteId);
                    if (deletePersonById != null) {
                        Terminal.writeLine("Человек с ID " + deleteId + " найден. Удаление...");
                        personRepository.removeById(deleteId);
                        Terminal.writeLine("Готово.");
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
                    return;
                default:
                    Terminal.writeLine("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
    }
    
    private char getChoiceMainMenu() {
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

    private char getChoicePersonsMenu() {
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
