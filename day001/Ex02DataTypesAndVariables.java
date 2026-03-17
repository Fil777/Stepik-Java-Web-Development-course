public class Ex02DataTypesAndVariables {
    public static void main(String[] args) {

        // Объявление и инициализация переменной типа int
        int val = 123;
        System.out.println(val);

        // Использование ключевого слова var для автоматического определения типа
        // переменной
        var age = 34;
        System.out.println(age);

        // Изменение значения переменной age
        age = 45;

        // Примитивные числовые типы данных: целые и вещественные

        // Целочисленные типы данных
        byte valueByte = 1; // Диапазон: -128 .. 127
        System.out.println(valueByte);

        short valueShort = 2; // Диапазон: -32 768 .. 32 767
        System.out.println(valueShort);

        int valueInt = 3; // Диапазон: -2 147 483 648 .. 2 147 483 647
        System.out.println(valueInt);

        long valueLong = 4L; // Диапазон: -9 223 372 036 854 775 808 .. 9 223 372 036 854 775 807
        System.out.println(valueLong);

        // Вещественные типы данных (с плавающей запятой)
        float valueFloat = 123.4567890987654321f; // Одинарная точность (32 бита)
        // Выводит округленное значение из-за ограниченной точности
        System.out.println(valueFloat);

        double valueDouble = 123.4567890987654321; // Двойная точность (64 бита)
        // Более точное представление дробного числа
        System.out.println(valueDouble);

        // Символы: одиночные символы в одинарных кавычках
        char valueChar = '!';
        System.out.println(valueChar);

        // Логический тип данных: true или false
        boolean valueBool = true;
        System.out.println(valueBool);

        // Ссылочные типы данных

        // Строки: последовательности символов
        String valueString = "Какой-то текст";
        System.out.println(valueString);
    }
}
