package ru.ksergey.builder.exercise;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer age;
    private String faculty;
    private Integer course;
    private Double averageGrade;
    private Boolean isGrantHolder;
    private String phoneNumber;

    private Student() {
    }

    public static class StudentBuilder {

        private Student student;

        private StudentBuilder() {
            this.student = new Student();
        }

        public static StudentBuilder create() {
            return new StudentBuilder();
        }

        public static Student createDefaultStudent() {
            return create()
                    .firstName("Unnamed")
                    .lastName("Student")
                    .age(18)
                    .course(1)
                    .faculty("General")
                    .averageGrade(3.0)
                    .build();
        }

        public StudentBuilder id(Long id) {
            student.id = id;
            return this;
        }

        public StudentBuilder firstName(String firstName) {
            student.firstName = firstName;
            return this;
        }

        public StudentBuilder lastName(String lastName) {
            student.lastName = lastName;
            return this;
        }

        public StudentBuilder middleName(String middleName) {
            student.middleName = middleName;
            return this;
        }

        public StudentBuilder age(Integer age) {
            student.age = age;
            return this;
        }

        public StudentBuilder faculty(String faculty) {
            student.faculty = faculty;
            return this;
        }

        public StudentBuilder course(Integer course) {
            student.course = course;
            return this;
        }

        public StudentBuilder averageGrade(Double averageGrade) {
            student.averageGrade = averageGrade;
            return this;
        }

        public StudentBuilder isGrantHolder(Boolean isGrantHolder) {
            student.isGrantHolder = isGrantHolder;
            return this;
        }

        public StudentBuilder phoneNumber(String phoneNumber) {
            student.phoneNumber = phoneNumber;
            return this;
        }

        public StudentBuilder validate() {
            if (student.firstName == null || student.lastName == null) {
                throw new IllegalStateException("Имя и фамилия обязательны");
            }

            if (student.age != null && (student.age < 16 || student.age > 35)) {
                throw new IllegalArgumentException("Возраст должен быть от 16 до 35 лет");
            }

            if (student.course != null && (student.course < 1 || student.course > 6)) {
                throw new IllegalArgumentException("Курс должен быть от 1 до 6");
            }

            if (student.averageGrade != null && (student.averageGrade < 2.0 || student.averageGrade > 5.0)) {
                throw new IllegalArgumentException("Средний балл должен быть от 2.0 до 5.0");
            }

            return this;
        }

        public Student build() {
            // Неявный вызов validate(), если нужна обязательная валидация
            return student;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", averageGrade=" + averageGrade +
                ", isGrantHolder=" + isGrantHolder +
                '}';
    }
}
