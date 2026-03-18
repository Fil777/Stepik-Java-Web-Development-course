import java.util.Scanner;

public class Ex14TextQuiz {
    public static void main(String[] args) {
        // Инициализация переменной для хранения счета
        int score = 0;

        // Создание объекта Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Первый вопрос
        String question1 = "Что означает слово 'кошка'? [cat, dog]";
        System.out.println(question1);

        // Получение ответа пользователя и приведение его к нижнему регистру
        String answer1 = scanner.nextLine().toLowerCase();

        // Проверка ответа на первый вопрос
        if (answer1.equals("cat")) {
            score += 10; // Увеличение счета на 10 баллов
            System.out.println("Всё верно! 😎");
        } else {
            System.out.println("Нужно подумать ещё 🫣");
        }

        // Второй вопрос
        String question2 = "Что означает слово 'собака'? [cat, dog]";
        System.out.println(question2);

        // Получение ответа пользователя и приведение его к нижнему регистру
        String answer2 = scanner.nextLine().toLowerCase();

        // Проверка ответа на второй вопрос
        if (answer2.equals("dog")) {
            score += 10; // Увеличение счета на 10 баллов
            System.out.println("Всё верно! 😎");
        } else {
            System.out.println("Нужно подумать ещё 🫣");
        }

        // Вывод итогового счета
        System.out.println("Счёт: " + score);

        // Закрытие Scanner
        scanner.close();
    }
}
