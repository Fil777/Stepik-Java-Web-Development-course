package model;

public class Staff extends Person {
    private int salary;

    public Staff(String name, int age, int salary) {
        super(name, age);
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
}
