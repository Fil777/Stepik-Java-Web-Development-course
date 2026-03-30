package stepik.course;

import java.io.Serializable;

public class Student implements Serializable {
    private boolean valid;
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private String faculty;
    private int course;
    private double averageGrade;
    private boolean isGrantHolder;
    private String phoneNumber;

    private Student() {
        valid = false;
        id = 0L;
        firstName = "Безимянный";
        lastName = "Безфамильный";
        middleName = "";
        age = 16;
        faculty = "";
        course = 1;
        averageGrade = 2.0;
        isGrantHolder = false;
        phoneNumber = "";
    }

    public Student cloneStudent(){
        Student clone = Student.create()
                .setId(this.getId())
                .setFirstName(this.getFirstName())
                .setMiddleName(this.getMiddleName())
                .setLastName(this.getLastName())
                .setAge(this.getAge())
                .setFaculty(this.getFaculty())
                .setCourse(this.getCourse())
                .setAverageGrade(this.getAverageGrade())
                .setIsGrantHolder(this.getIsGrantHolder())
                .setPhoneNumber(this.getPhoneNumber())
                .build();
        clone.validate();
        return clone;
    }

//    public Student(Student student){
//        this = SerializationUtils.roundtrip(student);
//    }

    public static StudentBuilder create() {
        return new StudentBuilder();
    }

    public Student validate() {
        this.valid =  (this.id > 0) &&
            (!this.firstName.isEmpty() && !this.lastName.isEmpty()) &&
            (this.age >= 15 && this.age <= 35) &&
            (this.course >= 1 && this.course <= 6) &&
            (this.averageGrade >= 2.0 && this.averageGrade <= 5.0);
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s Возраст: %d, Факультет: '%s', Курс: %d, Средний балл: %.2f, Стипендия: %b, Телефон: %s, Данные актуальны: %b.",
                id, firstName, middleName, lastName, age, faculty, course, averageGrade, isGrantHolder, phoneNumber, valid);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        validate();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        validate();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        validate();
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
        validate();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        validate();
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
        validate();
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
        validate();
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
        validate();
    }

    public boolean getIsGrantHolder() {
        return isGrantHolder;
    }

    public void setIsGrantHolder(boolean isGrantHolder) {
        this.isGrantHolder = isGrantHolder;
        validate();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        validate();
    }

    public static class StudentBuilder {
        private final Student student;

        private StudentBuilder() {
            this.student = new Student();
        }

        public StudentBuilder setId(long id) {
            student.id = id;
            return this;
        }

        public StudentBuilder setFirstName(String name) {
            student.firstName = name;
            return this;
        }

        public StudentBuilder setLastName(String name) {
            student.lastName = name;
            return this;
        }

        public StudentBuilder setMiddleName(String name) {
            student.middleName = name;
            return this;
        }

        public StudentBuilder setAge(int age) {
            student.age = age;
            return this;
        }

        public StudentBuilder setFaculty(String faculty) {
            student.faculty = faculty;
            return this;
        }

        public StudentBuilder setCourse(int course) {
            student.course = course;
            return this;
        }

        public StudentBuilder setAverageGrade(double averageGrade) {
            student.averageGrade = averageGrade;
            return this;
        }

        public StudentBuilder setIsGrantHolder(boolean isGrantHolder) {
            student.isGrantHolder = isGrantHolder;
            return this;
        }

        public StudentBuilder setPhoneNumber(String phoneNumber) {
            student.phoneNumber = phoneNumber;
            return this;
        }

        public Student build() {
            return student;
        }


    }
}
