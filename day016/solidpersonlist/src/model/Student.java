package model;

public class Student extends RootPerson implements StudentInterface{
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
        return super.toString() + ", Учащийся, Школа: " + schoolName;
    }
}
