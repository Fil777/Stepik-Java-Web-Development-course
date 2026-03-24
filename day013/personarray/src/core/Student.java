package core;

public class Student extends EmptyPerson{
    private String schoolName;

    public Student(String name, int age, String schoolName) {
        super(name, age);
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
        return super.toString() + ", Школа: " + schoolName;
    }
}
