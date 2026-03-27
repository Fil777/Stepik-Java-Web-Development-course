package model;

public class Instructor extends RootPerson implements InstructorInterface {
    private String subject;

    public Instructor(int id, String name, int age, String subject) {
        super(id, name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + ", Преподаватель, Subject: " + subject;
    }
}
