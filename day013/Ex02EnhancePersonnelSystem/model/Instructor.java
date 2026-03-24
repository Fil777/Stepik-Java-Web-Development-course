package model;

public class Instructor extends Person {
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
        return String.format("%s, предмет: %s",
                super.toString(), subject);
    }

    @Override
    public Person clone() {
        return new Instructor(id, name, age, subject);
    }
}
