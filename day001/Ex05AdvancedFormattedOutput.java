public class Ex05AdvancedFormattedOutput {
    public static void main(String[] args) {
        // 1. Форматирование числа с плавающей запятой до двух знаков после запятой
        // Используем String.format с "%.2f", чтобы округлить число до двух знаков после
        // запятой
        double number1 = 123.456789;
        String formattedNumber1 = String.format("%.2f", number1);
        System.out.println(formattedNumber1); // Вывод: 123.46

        // 2.1 Выравнивание числа по левому краю с заданной шириной поля
        // Используем "|%-10d|", чтобы выровнять число по левому краю в поле шириной 10
        // символов
        int value1 = 123;
        String formattedValue3 = String.format("|%-10d|", value1);
        System.out.println(formattedValue3); // Вывод: |123 |

        // 2.2 Выравнивание числа по правому краю с заданной шириной поля
        // Используем "|%10d|", чтобы выровнять число по правому краю в поле шириной 10
        // символов
        int value2 = 123;
        String formattedValue2 = String.format("|%10d|", value2);
        System.out.println(formattedValue2); // Вывод: | 123|

        // 4. Добавление нулей
        // Используем "|%010d|", чтобы дополнить число нулями слева до длины 10 символов
        int value3 = 123;
        String formattedValue4 = String.format("|%010d|", value3);
        System.out.println(formattedValue4); // Вывод: |0000000123|

        // 5. Использование разделителей тысяч
        // Используем "%,d" для добавления разделителей тысяч в больших числах
        int largeNumber = 10000000;
        String formattedLargeNumber = String.format("%,d", largeNumber);
        System.out.println(formattedLargeNumber); // Вывод: 10,000,000

        // 6. Форматирование числа в научной нотации
        // Используем "%e" для представления числа в научной нотации
        double scientificNumber = 12345.6789;
        String formattedScientific = String.format("%e", scientificNumber);
        System.out.println(formattedScientific); // Вывод: 1.234568e+04

        // 7. Форматирование числа с указанием знака для положительных значений
        // Используем "%+d" для добавления знака "+" перед положительными числами
        int positiveNumber = 123;
        String formattedPositive1 = String.format("%+d", positiveNumber);

        // Используем "|%+10d|" для выравнивания по правому краю с добавлением знака "+"
        // и общей шириной поля в 10 символов
        String formattedPositive2 = String.format("|%+10d|", positiveNumber);

        System.out.println(formattedPositive1); // Вывод: +123
        System.out.println(formattedPositive2); // Вывод: | +123|
    }
}
