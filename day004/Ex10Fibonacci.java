public class Ex10Fibonacci {
    public static void main(String[] args) {
        int count = 20;

        System.out.printf("Первые %d чисел Фибоначчи: \n", count);

        double first = 0, second = 1, step = 0;

        while (step < count) {
            System.out.printf("%.0f ", first);
            double sum = first + second;
            first = second;
            second = sum;
            step++;
        }
    }
}
