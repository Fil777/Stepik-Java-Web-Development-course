import java.util.Random;

public class Ex04ExercisesPart1 {
    public static void main(String[] args) {

    }

    /**
     * Определяет диапазон числа на основе его значения.
     *
     * @param value целое число для оценки
     * @return строка, описывающая диапазон числа:
     *         "Число меньше нуля" для отрицательных чисел,
     *         "Маленькое" для чисел от 0 до 10,
     *         "Среднее" для чисел от 11 до 100,
     *         "Большое" для чисел больше 100
     */
    private static String getNumberRange(int value) {
        if (value < 0) {
            return "Число меньше нуля";
        } else if (value <= 10) {
            return "Маленькое";
        } else if (value <= 100) {
            return "Среднее";
        } else {
            return "Большое";
        }
    }

    /**
     * Возвращает случайную оптимальную температуру для заданного уровня активности.
     *
     * @param activity строка, описывающая уровень активности ("тяжелая", "средняя",
     *                 "лёгкая")
     * @return случайное целое число, представляющее оптимальную температуру в
     *         градусах Цельсия
     */
    private static int getOptimalTemperatureV2(String activity) {
        Random random = new Random();
        if ("тяжелая".equalsIgnoreCase(activity)) {
            return random.nextInt(16, 19);
        } else if ("средняя".equalsIgnoreCase(activity)) {
            return random.nextInt(18, 21);
        } else if ("лёгкая".equalsIgnoreCase(activity)) {
            return random.nextInt(20, 23);
        } else {
            return 24;
        }
    }

    /**
     * Возвращает диапазон оптимальной температуры для заданного уровня активности.
     *
     * @param activity строка, описывающая уровень активности ("тяжелая", "средняя",
     *                 "лёгкая")
     * @return строка, представляющая диапазон оптимальной температуры в градусах
     *         Цельсия
     */
    private static String getOptimalTemperatureV1(String activity) {
        if ("тяжелая".equalsIgnoreCase(activity)) {
            return "16-18°C";
        } else if ("средняя".equalsIgnoreCase(activity)) {
            return "18-20°C";
        } else if ("лёгкая".equalsIgnoreCase(activity)) {
            return "20-22°C";
        } else {
            return "Уупс. Что-то пошло не так.";
        }
    }

    /**
     * Определяет сезон по номеру месяца.
     *
     * @param month целое число, представляющее номер месяца (1-12)
     * @return строка с названием сезона ("Зима", "Весна", "Лето", "Осень") или
     *         "Неверные данные" при некорректном вводе
     */
    private static String getSeason(int month) {

        if (month == 12 || month == 1 || month == 2) {
            return "Зима";
        } else if (month == 3 || month == 4 || month == 5) {
            return "Весна";
        } else if (month == 6 || month == 7 || month == 8) {
            return "Лето";
        } else if (month == 9 || month == 10 || month == 11) {
            return "Осень";
        } else {
            return "Неверные данные";
        }
    }

    /**
     * Рассчитывает стоимость проезда на основе расстояния.
     * 
     * @param distance Пройденное расстояние в километрах.
     * @return Стоимость проезда в условных единицах.
     */
    private static double calculateFare(double distance) {
        double tariffA = 2; // Тариф А 2 у.е. оплата за 1 км
        double tariffB = 2.5; // Тариф Б 2.5 у.е. оплата за 1 км
        double dist = 50;
        double result;

        if (distance <= 100) {
            result = distance * tariffA;
        } else {
            result = dist * tariffA + (distance - dist) * tariffB;
        }
        return result;
    }

    /**
     * Проверяет, является ли число четным.
     *
     * @param x целое число для проверки
     * @return true, если число четное, иначе false
     */
    private static boolean isEven(int x) {
        return x % 2 == 0;
    }

    /**
     * Вычисляет пройденное расстояние при равноускоренном движении.
     * 
     * @param v0 Начальная скорость (в м/с).
     * @param a  Ускорение (в м/с^2).
     * @param t  Время движения (в секундах).
     * @return Пройденное расстояние (в метрах).
     */
    private static double distanceTravel(double v0, double a, double t) {
        return v0 * t + (1.0 / 2) * a * Math.pow(t, 2);
    }

    /**
     * Вычисляет значение квадратного выражения вида ax^2 + bx + c.
     * 
     * @param a Коэффициент при x^2.
     * @param b Коэффициент при x.
     * @param c Свободный член.
     * @param x Значение переменной x.
     * @return Результат вычисления квадратного выражения.
     */
    private static double quadraticExpression(int a, int b, int c, double x) {
        return a * Math.pow(x, 2) + b * x + c;
    }

    /**
     * Вычисляет скалярное произведение двух трехмерных векторов.
     *
     * @param a первый вектор, представленный массивом из трех элементов
     * @param b второй вектор, представленный массивом из трех элементов
     * @return скалярное произведение векторов a и b, или Double.NaN, если длина
     *         любого из векторов не равна 3
     */
    private static double dotProduct(double[] a, double[] b) {
        if (a.length != 3 || b.length != 3) {
            return Double.NaN;
        }
        return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
    }

    /**
     * Преобразует температуру из градусов Фаренгейта в градусы Цельсия.
     *
     * @param fahrenheit температура в градусах Фаренгейта
     * @return эквивалентная температура в градусах Цельсия
     */
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (5 / 9.0) * (fahrenheit - 32);
    }

    /**
     * Вычисляет длину окружности по заданному радиусу.
     *
     * @param r радиус окружности
     * @return длина окружности
     */
    private static double lengthCircumference(double r) {
        return 2 * Math.PI * r;
    }

    /**
     * Проверяет, могут ли три заданные стороны образовать треугольник.
     * 
     * @param a длина первой стороны
     * @param b длина второй стороны
     * @param c длина третьей стороны
     * @return {@code true}, если стороны могут образовать треугольник,
     *         {@code false} в противном случае
     */
    private static boolean checkTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    /**
     * Вычисляет площадь треугольника по формуле Герона.
     * 
     * @param a длина первой стороны треугольника
     * @param b длина второй стороны треугольника
     * @param c длина третьей стороны треугольника
     * @return площадь треугольника
     */
    private static double heronTriangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
     * Вычисляет объем куба по длине его ребра.
     *
     * @param edge длина ребра куба
     * @return объем куба
     * @throws IllegalArgumentException если длина ребра отрицательная или равна
     *                                  нулю
     */
    private static double getCubeVolume(double edge) {
        return Math.pow(edge, 3);
    }

    /**
     * Преобразует количество минут в часы.
     * 
     * Этот метод выполняет целочисленное деление количества минут на 60,
     * чтобы получить количество полных часов.
     *
     * @param minutes количество минут для преобразования, должно быть
     *                неотрицательным
     * @return количество полных часов, соответствующее заданному количеству минут
     * @throws ArithmeticException если параметр minutes отрицательный
     */
    private static int hoursInMinutes(int minutes) {
        return minutes / 60;
    }

    /**
     * Вычисляет количество минут в указанном количестве дней.
     *
     * @param day количество дней
     * @return количество минут в указанном количестве дней
     */
    private static int minutesInDay(int day) {
        return day * 24 * 60;
    }

    /**
     * Результат умножения трёх чисел
     * 
     * @param a Первое число
     * @param b Второе число
     * @param c Третье число
     * @return Результат перемножения
     */
    static int multiplyThreeNumbers(int a, int b, int c) {
        return a * b * c;
    }
}
