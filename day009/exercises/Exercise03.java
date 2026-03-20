package exercises;

public class Exercise03 {
    public static String getTriangleType(double a, double b, double c) {
        if (a + b <= c || b + c <= a || a + c <= b) {
            return "не треугольник";
        }
        if (a == b && b == c) {
            return "равносторонний";
        }
        if (a == b || b == c || a == c) {
            return "равнобедренный";
        }
        return "разносторонний";
    }

    public static void main(String[] args) {
        System.out.println(getTriangleType(3, 4, 5)); // разносторонний
        System.out.println(getTriangleType(5, 5, 5)); // равносторонний
        System.out.println(getTriangleType(5, 5, 8)); // равнобедренный
        System.out.println(getTriangleType(1, 2, 5)); // не треугольник
    }
}
