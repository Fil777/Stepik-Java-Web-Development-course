package Ex01Animals;

public class Dog {
    private String name;
    private int age;
    private double weight;
    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    public void eat() {
        System.out.println(name + " ест");
    }

    public void sleep() {
        System.out.println(name + " спит");
    }

    public void bark() {
        System.out.println(name + " лает: Гав! Гав!");
    }

    public void fetch() {
        System.out.println(name + " приносит мяч");
    }
}
