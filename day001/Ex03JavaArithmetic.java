public class Ex03JavaArithmetic {
    public static void main(String[] args) {
        // Пример сложения: складываем значения переменных a и b
        int a = 10;
        int b = 5;
        int result = a + b;
        System.out.println(a + " + " + b + " = " + result);

        // Пример вычитания: вычитаем значение переменной y из x
        int x = 10;
        int y = 5;
        int difference = x - y;
        System.out.println(x + " - " + y + " = " + difference);

        // Пример умножения: перемножаем значения переменных m и n
        int m = 10;
        int n = 5;
        int product = m * n;
        System.out.println(m + " * " + n + " = " + product);

        // Пример деления: делим значение переменной p на q
        int p = 10;
        int q = 5;
        int quotient = p / q;
        System.out.println(p + " / " + q + " = " + quotient);

        // Пример деления с вещественным результатом: делим div1 на div2
        double div1 = 10;
        int div2 = 4;
        double divResult = div1 / div2; // Результат будет с плавающей точкой
        System.out.println(div1 + " / " + div2 + " = " + divResult);

        // Пример остатка от деления: находим остаток от деления num1 на num2
        int num1 = 10;
        int num2 = 3;
        int remainder = num1 % num2;
        System.out.println(num1 + " % " + num2 + " = " + remainder);

        // Пример префиксного инкремента: увеличиваем значение var1 на 1 перед
        // присваиванием var2
        int var1 = 5;
        int var2 = ++var1; // var1 увеличивается до 6, затем присваивается var2
        System.out.println("Префиксный инкремент: var1 = " + var1 + ", var2 = " + var2);

        // Пример постфиксного инкремента: присваиваем значение var3 в var4, затем
        // увеличиваем var3 на 1
        int var3 = 5;
        int var4 = var3++; // var4 получает значение 5, затем var3 увеличивается до 6
        System.out.println("Постфиксный инкремент: var3 = " + var3 + ", var4 = " + var4);

        // Пример использования составного оператора присваивания
        // для нахождения остатка от деления
        int value1 = 11;
        int value2 = 2;

        // Используем оператор %= для нахождения остатка от деления
        // и присваивания его value1
        value1 %= value2; // Эквивалентно value1 = value1 % value2
        System.out.println(value1); // Выводит остаток от деления, который равен 1
    }
}
