package Ex07GenericCage;

public class Main {
    public static void main(String[] args) {
        // Создание клеток для львов и жирафов
        Cage<Lion> lionCage = new Cage<>(2);
        Cage<Giraffe> giraffeCage = new Cage<>(3);

        // Создание львов и добавление их в клетку для львов
        Lion lion1 = new Lion("Симба");
        Lion lion2 = new Lion("Муфаса");
        lionCage.addAnimal(lion1);
        lionCage.addAnimal(lion2);

        // Создание жирафов и добавление их в клетку для жирафов
        Giraffe giraffe1 = new Giraffe("Мелман");
        Giraffe giraffe2 = new Giraffe("Глория");
        Giraffe giraffe3 = new Giraffe("Марти");
        giraffeCage.addAnimal(giraffe1);
        giraffeCage.addAnimal(giraffe2);
        giraffeCage.addAnimal(giraffe3);

        // Создание еды
        Meat meat = new Meat();
        Grass grass = new Grass();

        // Кормление животных
        System.out.println("Кормление львов мясом:");
        lionCage.feedAnimalsWithFood(meat);

        System.out.println("\nКормление львов травой:");
        lionCage.feedAnimalsWithFood(grass);

        System.out.println("\nКормление жирафов травой:");
        giraffeCage.feedAnimalsWithFood(grass);

        System.out.println("\nКормление жирафов мясом:");
        giraffeCage.feedAnimalsWithFood(meat);

        // Отображение информации о животных в клетках
        System.out.println("\nЖивотные в клетке для львов:");
        lionCage.displayAnimals();

        System.out.println("\nЖивотные в клетке для жирафов:");
        giraffeCage.displayAnimals();
    }
}
