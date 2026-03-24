package model;

public class Staff extends EmptyPerson {
    private double salary;

    public Staff(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Сотрудник, Зарплата: " + salary;
    }

}
