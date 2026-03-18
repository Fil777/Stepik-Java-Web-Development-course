public class Ex13StringBuilder {
    public static void main(String[] args) {
        // Создание исходных строк
        String greeting = "Привет, ";
        String name = "Мир!";

        // Создание объекта StringBuilder
        StringBuilder sb = new StringBuilder();

        // Добавление строк к StringBuilder
        sb.append(greeting);
        sb.append(name);

        // Преобразование StringBuilder в String
        String sbGreeting = sb.toString();
        System.out.println("Исходная строка: " + sbGreeting.toString()); // Выведет "Привет, Мир!"

        // Вставка текста в определенную позицию
        sb.insert(7, "дорогой "); // Вставляем "дорогой " после "Привет, "
        System.out.println("После вставки: " + sb.toString());

        // Замена части строки
        sb.replace(0, 7, "Здравствуй, "); // Заменяем "Привет, " на "Здравствуй, "
        System.out.println("После замены: " + sb.toString());

        // Удаление части строки
        sb.delete(sb.length() - 1, sb.length()); // Удаляем последний символ (восклицательный знак)
        System.out.println("После удаления: " + sb.toString());

        // Разворот строки
        sb.reverse();
        System.out.println("После разворота: " + sb.toString());

        // Получение длины StringBuilder
        System.out.println("Длина StringBuilder: " + sb.length());

        // Установка длины StringBuilder (обрезка или дополнение пробелами)
        sb.setLength(10);
        System.out.println("После установки длины: '" + sb.toString() + "'");

        // Получение символа по индексу
        char charAtIndex = sb.charAt(5);
        System.out.println("Символ на позиции 5: " + charAtIndex);

        // Замена символа по индексу
        sb.setCharAt(0, 'М');
        System.out.println("После замены первого символа: " + sb.toString());
    }
}
