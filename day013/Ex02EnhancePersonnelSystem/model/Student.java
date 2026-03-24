package model;

public class Student extends Person {
    private String schoolName;

    public Student(int id, String name, int age, String schoolName) {
        super(id, name, age);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return String.format("%s, школа: %s",
                super.toString(), schoolName);
    }

    @Override
    public Person clone() {
        return new Student(id, name, age, schoolName);
    }
}
