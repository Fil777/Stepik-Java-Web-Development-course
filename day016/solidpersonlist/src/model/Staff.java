package model;

public class Staff extends RootPerson implements StaffInteface{
    private double salary;

    public Staff(int id, String name, int age, double salary) {
        super(id, name, age);
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
