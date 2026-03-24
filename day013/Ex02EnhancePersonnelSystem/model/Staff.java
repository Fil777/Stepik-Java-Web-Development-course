package model;

public class Staff extends Person {
    private int salary;

    public Staff(int id, String name, int age, int salary) {
        super(id, name, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s, оплата труда: %d",
                super.toString(), salary);
    }

    @Override
    public Person clone() {
        return new Staff(id, name, age, salary);
    }
}
