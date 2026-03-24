package Ex04Animals;

public class Dog extends Animal implements SoundMaker {
    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight);
        this.breed = breed;
    }

    public void fetch() {
        System.out.println(name + " приносит мяч");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " лает: Гав! Гав!");
    }
}
