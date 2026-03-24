package Ex07GenericCage;

import java.util.ArrayList;

class Cage<T extends Animal> {
    private ArrayList<T> animals;
    private int capacity;

    public Cage(int capacity) {
        this.animals = new ArrayList<>();
        this.capacity = capacity;
    }

    public void addAnimal(T animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
            System.out.println(animal.getClass().getSimpleName() + " добавлен в клетку");
        } else {
            System.out.println("Клетка заполнена. Невозможно добавить " + animal.getClass().getSimpleName());
        }
    }

    public void feedAnimals() {
        for (T animal : animals) {
            animal.eat();
        }
    }

    public <U extends Food> void feedAnimalsWithFood(U food) {
        for (T animal : animals) {
            if (animal.canEat(food)) {
                animal.eat(food);
            } else {
                System.out.println(animal.getClass().getSimpleName() + " не ест " + food.getClass().getSimpleName());
            }
        }
    }

    public void displayAnimals() {
        for (T animal : animals) {
            System.out.println(animal.getClass().getSimpleName() + ": " + animal.getName());
        }
    }
}
