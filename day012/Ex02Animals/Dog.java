package Ex02Animals;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight);
        this.breed = breed;
    }

    public void bark() {
        System.out.println(name + " лает: Гав! Гав!");
    }

    public void fetch() {
        System.out.println(name + " приносит мяч");
    }

    @Override
    public void makeSound() {

        this.bark();
    }
}
