public class SandBox {
    public static void main(String[] args) {
        int days = 6;
        System.out.println(minutesInDay(days));
        double a = 4, b = 4, c = 3;
        System.out.println(heronTriangleArea(a, b, c));
        System.out.println(lengthCircumference(2.0));

        double[] va = { -8.0, 3.5, 3.5 };
        double[] vb = { -2.5, 9.0, 3.5 };
        System.out.println(dotProduct(va, vb));
        System.out.println(calculateFare(191.25));
        System.out.println(getSeason(1));
        System.out.println(getSeason(7));
        System.out.println(getSeason(13));
        System.out.println(getOptimalTemperature("среДняя1"));
        System.out.println(getNumberRange(-222));
    }

    static int minutesInDay(int days) {
        return days * 24 * 60;
    }

    static double heronTriangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    static double lengthCircumference(double radius) {
        return Math.PI * 2.0 * radius;
    }

    static double dotProduct(double[] a, double[] b) {
        if (a.length == 3 && b.length == 3) {
            return (a[0] * b[0]) + (a[1] * b[1]) + (a[2] * b[2]);
        } else {
            return Double.NaN;
        }
    }

    static double calculateFare(double distance) {
        if (distance > 100.0) {
            return 200.0 + (distance - 100.0) * 2.5;
        } else {
            return distance * 2.0;
        }
    }

    static String getSeason(int month) {
        String[] season = { "Неверные данные",
                "Зима", "Зима",
                "Весна", "Весна", "Весна",
                "Лето", "Лето", "Лето",
                "Осень", "Осень", "Осень",
                "Зима" };
        if (month >= 1 && month <= 12) {
            return season[month];
        } else {
            return season[0];
        }
    }

    static String getOptimalTemperature(String activity) {
        switch (activity.toLowerCase()) {
            case "лёгкая":
                return "20-22°C";
            case "средняя":
                return "18-20°C";
            case "тяжелая":
                return "16-18°C";
            default:
                return "Уупс. Что-то пошло не так";
        }
    }

    static String getNumberRange(int value) {
        if (value < 0)
            return "Число меньше нуля";
        else if (value >= 0 && value <= 10)
            return "Маленькое";
        else if (value >= 11 && value <= 100)
            return "Среднее";
        else
            return "Большое";
    }
}
