package model;

import java.io.Serializable;
import java.util.HashMap;


public class PersonInterfaceObject implements StudentInterface, StaffInteface, InstructorInterface, Serializable {

    private HashMap<String, String> pio;

    private PersonInterfaceObject() {
        this.pio = new HashMap<>();
    }

    public PersonInterfaceObject(PersonType type){
        this();
        setPersonType(type);
    }

    public PersonInterfaceObject(Person person){
        this();
        setId(person.getId());
        setName(person.getName());
        setAge(person.getAge());
        if (person instanceof Staff) {
            setPersonType(PersonType.STAFF);
            Staff staff = (Staff) person;
            setSalary(staff.getSalary());
        } else if (person instanceof Instructor) {
            setPersonType(PersonType.INSTRUCTOR);
            Instructor instructor = (Instructor) person;
            setSubject(instructor.getSubject());
        } else if (person instanceof Student) {
            setPersonType(PersonType.STUDENT);
            Student student = (Student) person;
            setSchoolName(student.getSchoolName());
        }
    }

    public PersonInterfaceObject personToPio(Person person) {
        if (person == null) return null;
        if (person.getId() <= 0) return null;
        return new PersonInterfaceObject(person);
    }

    public Person PioToPerson(){
        switch (this.getPersonType())
        {
            case "STAFF":
                Staff staff = new Staff(
                        getId(),
                        getName(),
                        getAge(),
                        getSalary()
                );
                return staff;
            case "INSTRUCTOR":
                Instructor instructor = new Instructor(
                        getId(),
                        getName(),
                        getAge(),
                        getSubject()
                );
                return instructor;
            case "STUDENT":
                Student student = new Student(
                        getId(),
                        getName(),
                        getAge(),
                        getSchoolName()
                );
                return student;
            default:
                return null;
        }
    }

    public String getPersonType(){
        return pio.get("type");
    }

    public void setPersonType(PersonType type){
        pio.put("type", type.name());
    }

    public void setId(int id) {
        pio.put("id", String.valueOf(id));
    }

    public int getId() {
        return Integer.valueOf(pio.get("id"));
    }

    public void setName(String name) {
        pio.put("name", name);
    }

    public String getName() {
        return pio.get("name");
    }

    public void setAge(int age) {
        pio.put("age", String.valueOf(age));
    }

    public int getAge() {
        return Integer.valueOf(pio.get("age"));
    }

    public void setSalary(double salary) {
        pio.put("salary", String.valueOf(salary));
    }

    public double getSalary() {
        return Double.valueOf(pio.get("salary"));
    }

    public void setSchoolName(String school) {
        pio.put("school", school);
    }

    public String getSchoolName() {
        return pio.get("school");
    }

    public void setSubject(String subject) {
        pio.put("subject", subject);
    }

    public String getSubject() {
        return pio.get("subject");
    }

    public String toString() {
        return pio.toString();
    }
    
}
