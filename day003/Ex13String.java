public class Ex13String {
    public static void main(String[] args) {
        // Создание строк
        String greeting = "Привет, ";
        String name = "Мир!";

        // Конкатенация строк
        String fullGreeting = greeting + name;
        System.out.println(fullGreeting); // Выведет "Привет, Мир!"

        // Длина строки
        System.out.println("Длина строки: " + fullGreeting.length()); // Выведет длину строки

        // Сравнение строк
        String anotherGreeting = "Привет, Мир!";
        if (fullGreeting.equals(anotherGreeting)) {
            System.out.println("Строки одинаковые.");
        } else {
            System.out.println("Строки разные.");
        }

        // Преобразование регистра
        String lowerCaseGreeting = fullGreeting.toLowerCase();
        System.out.println(lowerCaseGreeting); // Выведет "привет, мир!"

        // Замена символов
        String replacedGreeting = fullGreeting.replace('и', 'а');
        System.out.println(replacedGreeting); // Выведет "Правет, Мар!"

        // Сравнение строк с игнорированием регистра
        if (fullGreeting.equalsIgnoreCase("привет, мир!")) {
            System.out.println("Строки одинаковые (без учета регистра).");
        }

        // Получение подстроки
        String world = fullGreeting.substring(8); // Извлекаем "Мир!"
        System.out.println(world);
    }
}
