package Ex04Animals;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Random random = new Random();

        int totalAnimal = random.nextInt(20, 30);
        System.out.println("Всего животных: " + totalAnimal);

        int totalDogs = random.nextInt(totalAnimal + 1);
        int totalCats = random.nextInt(totalAnimal - totalDogs + 1);
        int totalBirds = totalAnimal - totalDogs - totalCats;

        System.out.printf("Всего в команде:\nСобак: %d\nКошек: %d\nПтиц: %d\n",
                totalDogs, totalCats, totalBirds);

        ArrayList<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < totalDogs; i++) {
            dogs.add(new Dog(
                    "Собака" + (i + 1),
                    random.nextInt(10) + 1,
                    5 + random.nextDouble() * 20,
                    "Порода" + (i + 1)));
        }

        ArrayList<Cat> cats = new ArrayList<>();
        for (int i = 0; i < totalCats; i++) {
            cats.add(new Cat(
                    "Котик" + (i + 1),
                    random.nextInt(10) + 1,
                    random.nextDouble() * 6,
                    "Цвет" + (i + 1)));
        }

        ArrayList<Bird> birds = new ArrayList<>();
        for (int i = 0; i < totalCats; i++) {
            birds.add(new Bird(
                    "Птичка" + (i + 1),
                    random.nextInt(5) + 1,
                    0.1 + random.nextDouble(),
                    "Цвет" + (i + 1),
                    random.nextBoolean()));
        }

        for (Dog dog : dogs) {
            System.out.println(dog);
        }

        for (Cat cat : cats) {
            System.out.println(cat);
        }

        for (Bird bird : birds) {
            System.out.println(bird);
        }
    }

}
