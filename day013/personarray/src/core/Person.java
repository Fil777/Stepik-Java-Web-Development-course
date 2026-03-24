package core;

public abstract class Person  {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age) {
        this(DataInitializer.generateID(), name, age);
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "ID: " + id + ", Имя: " + name + ", Возраст: " + age;
    }
}