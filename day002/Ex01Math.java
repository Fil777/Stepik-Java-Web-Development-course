public class Ex01Math {
    public static void main(String[] args) {
        // Абсолютное значение
        int negNumber = -10;
        System.out.printf("Абсолютное значение %d = %d\n", negNumber, Math.abs(negNumber));

        // Возведение в степень
        double base = 2;
        double exponent = 3;
        System.out.printf("%.2f в степени %.2f = %.2f\n", base, exponent, Math.pow(base, exponent));

        // Квадратный корень
        double square = 16;
        System.out.printf("Квадратный корень из %.2f = %f ", square, Math.sqrt(square));

        // Максимум и минимум
        int x = 3, y = 7;
        System.out.printf("Math.max(%d, %d) = %d \n", x, y, Math.max(x, y));
        System.out.printf("Math.min(%d, %d) = %d \n", x, y, Math.min(x, y));

        // Тригонометрия
        double angle = Math.PI / 2;
        System.out.printf("Синус угла Pi/2 = %f \n", Math.sin(angle));

        // Экспоненциальная функция
        System.out.printf("e в степени 1 = %f \n", Math.exp(1));

        // Логарифм
        System.out.printf("Натуральный логарифм e = %f \n", Math.log(Math.E));

        // Округление
        double numberToRound = 3.3678;
        System.out.printf("Округление %f = %d \n", numberToRound, Math.round(numberToRound));

        // Округление вверх и вниз
        double number = -3.1;
        System.out.printf("Округление %f вверх = %f \n", number, Math.ceil(number));
        System.out.printf("Округление %f вниз = %f \n", number, Math.floor(number));

        // Генерация случайного числа
        System.out.printf("Случайное число между [0.0 и 1.0) = %f \n", Math.random());
        System.out.printf("Случайное число %f \n", Math.ceil(Math.random() * 10 + 5));
    }
}
