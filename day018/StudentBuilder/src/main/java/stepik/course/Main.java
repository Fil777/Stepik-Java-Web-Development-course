package stepik.course;

public class Main {
    public static void main(String[] args) {
        // Создание студента с полной информацией
        Student student1 = Student.create()
                .setId(1L)
                .setFirstName("Иван")
                .setMiddleName("Эдуардович")
                .setLastName("Петров")
                .setAge(20)
                .setFaculty("Информатика")
                .setCourse(3)
                .setAverageGrade(4.5)
                .setIsGrantHolder(true)
                .setPhoneNumber("+7(909)111-22-33")
                .build()
                .validate();

        // Создание студента с частичной информацией
        Student student2 = Student.create()
                .setId(2)
                .setFirstName("Анна")
                .setLastName("Смирнова")
                .setFaculty("Экономика")
                .setAge(12)
                .build()
                .validate();

        // Использование метода по умолчанию
        Student defaultStudent = Student.create().build();

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(defaultStudent);

        student2.setAge(18);
        System.out.println(student2);

        Student student3 = student1.cloneStudent();
        student3.setId(3);
        System.out.println(student3);
    }
}