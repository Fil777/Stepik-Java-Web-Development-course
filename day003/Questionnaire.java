import java.util.Scanner;

public class Questionnaire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        System.out.println("Что означает слово 'кошка'? [cat, dog]");
        String cat = scanner.nextLine();
        if (cat.equalsIgnoreCase("cat")) {
            System.out.println("Всё верно! :)");
            counter += 10;
        } else {
            System.out.println("Нужно подумать ещё :(");
        }

        System.out.println("Что означает слово 'собака'? [cat, dog]");
        String dog = scanner.nextLine();
        if (dog.equalsIgnoreCase("dog")) {
            System.out.println("Всё верно! :)");
            counter += 10;
        } else {
            System.out.println("Нужно подумать ещё :(");
        }

        System.out.printf("Счёт: %d\n", counter);
        scanner.close();
    }
}
