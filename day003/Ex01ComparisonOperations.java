public class Ex01ComparisonOperations {
    public static void main(String[] args) {
        double x = 12;
        int y = 124;

        // Сравнение x > y и присвоение результата переменной flag
        boolean flag = x > y;
        System.out.println(flag);

        // Сравнение x < y и присвоение результата переменной flag
        flag = x < y;
        System.out.println(flag);

        // Сравнение x >= y и присвоение результата переменной flag
        flag = x >= y;
        System.out.println(flag);

        // Сравнение x <= y и присвоение результата переменной flag
        flag = x <= y;
        System.out.println(flag);

        // Сравнение x == y и присвоение результата переменной flag
        flag = x == y;
        System.out.println(flag);

        // Сравнение x != y и присвоение результата переменной flag
        flag = x != y;
        System.out.println(flag);

        String firstName = "Вася";
        String lastName = "Пупкин";

        String originFullName = "Вася Пупкин";
        String originFullName2 = "Вася Пупкин";
        // Конкатенация строк firstName и lastName с пробелом между ними
        String fullName = firstName + " " + lastName;

        System.out.printf("firstName = %s\n", firstName);
        System.out.printf("lastName = %s\n", lastName);
        System.out.printf("originFullName = %s\n", originFullName);
        System.out.printf("fullName = %s\n", fullName);

        // Сравнение строк originFullName и fullName по ссылкам (==)
        System.out.println(originFullName == fullName);
        // Сравнение строк originFullName и fullName по ссылкам (!=)
        System.out.println(originFullName != fullName);

        // Сравнение строк originFullName и originFullName2 по ссылкам (==)
        System.out.println(originFullName == originFullName2);
        // Сравнение строк originFullName и originFullName2 по ссылкам (!=)
        System.out.println(originFullName != originFullName2);

        // Сравнение строк originFullName и fullName по значению (equals)
        System.out.println(originFullName.equals(fullName));
        // Сравнение строк originFullName и originFullName2 по значению (equals)
        System.out.println(originFullName.equals(originFullName2));

        Integer a = 124;
        Byte b = 124;
        // Преобразование Byte в Integer
        Integer c = Integer.valueOf(b);
        // Сравнение Integer a и Integer c по значению (equals)
        System.out.println(a.equals(c));

        // Получение символа из строки fullName по индексу 1 (второй символ)
        char ch = fullName.charAt(1); // Вася Пупкин
        System.out.printf("ch = %s\n", ch);
        // Сравнение символа ch с символом 'а'
        System.out.println(ch == 'а');
        // Сравнение целочисленного значения 49 с символом '1'
        System.out.println(49 == '1');

        // Преобразование целочисленного значения 33 в символ и вывод его на экран
        System.out.println((char) 33);
    }
}
