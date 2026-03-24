package Ex03Animals;

public abstract class Animal {
    protected String name;
    protected int age;
    protected double weight;

    protected Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void eat() {
        System.out.println(name + " есть");
    }

    public void sleep() {
        System.out.println(name + " спит");
    }
}
