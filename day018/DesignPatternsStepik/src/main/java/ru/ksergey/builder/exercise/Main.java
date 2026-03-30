package ru.ksergey.builder.exercise;

public class Main {
    public static void main(String[] args) {
        Student student1 = Student.StudentBuilder
                .create()
                .id(1L)
                .firstName("Иван")
                .lastName("Петров")
                .age(20)
                .faculty("Информатика")
                .course(3)
                .averageGrade(4.5)
                .isGrantHolder(true)
                .validate()
                .build();

        Student student2 = Student.StudentBuilder
                .create()
                .firstName("Анна")
                .lastName("Смирнова")
                .faculty("Экономика")
                .build();

        Student defaultStudent = Student.StudentBuilder
                .createDefaultStudent();

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(defaultStudent);
    }
}
