package Ex05Animals;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        Random random = new Random();

        int totalAnimal = random.nextInt(20, 30);
        System.out.println("Всего животных: " + totalAnimal);

        ArrayList<Animal> animals = new ArrayList<>();
        for (int i = 0; i < totalAnimal; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    animals.add(new Dog(
                            "Собака" + (i + 1),
                            random.nextInt(10) + 1,
                            5 + random.nextDouble() * 20,
                            "Порода" + (i + 1)));
                    break;
                case 1:
                    animals.add(new Cat(
                            "Котик" + (i + 1),
                            random.nextInt(10) + 1,
                            random.nextDouble() * 6,
                            "Цвет" + (i + 1)));
                    break;
                case 2:
                    animals.add(new Bird(
                            "Птичка" + (i + 1),
                            random.nextInt(5) + 1,
                            0.1 + random.nextDouble(),
                            "Цвет" + (i + 1),
                            random.nextBoolean()));
                    break;
            }
            System.out.println(animals.get(i));
        }
    }

}
