package Ex02Animals;

public class Animal {
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

    public void makeSound() {
        System.out.println(name + " издаёт звук");
    }
}
