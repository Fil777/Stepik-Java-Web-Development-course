package Ex02Animals;

public class Program {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик", 2, 9.7, "Овчарка");
        dog.bark();
        dog.eat();
        dog.sleep();
        dog.fetch();

        Cat cat = new Cat("Барсик", 2, 3.7, "Серебристая");
        cat.bark();
        cat.eat();
        cat.sleep();
        cat.scratch();

        Bird bird = new Bird("Гоша", 2, 3.7, "Серебристая", !true);
        bird.chirp();
        bird.eat();
        bird.sleep();
        bird.fly();

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();

    }
}
