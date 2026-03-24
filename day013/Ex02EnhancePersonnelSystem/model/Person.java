package model;

public abstract class Person {
    protected String name;
    protected int age;
    protected int id;

    public Person(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, имя: %s, возраст: %d", id, name, age);
    }

    public abstract Person clone();
}
