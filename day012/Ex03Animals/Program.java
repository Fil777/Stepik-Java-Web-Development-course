package Ex03Animals;

public class Program {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик", 2, 9.7, "Овчарка");
        dog.eat();
        dog.sleep();
        dog.fetch();
        dog.makeSound();

        Cat cat = new Cat("Барсик", 2, 3.7, "Серебристая");
        cat.eat();
        cat.sleep();
        cat.scratch();
        cat.makeSound();

        Bird bird = new Bird("Гоша", 2, 3.7, "Серебристая", !true);
        bird.eat();
        bird.sleep();
        bird.fly();
        bird.makeSound();

    }
}
