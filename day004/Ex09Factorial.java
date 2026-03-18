public class Ex09Factorial {
    public static void main(String[] args) {
        int n = 5;

        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.printf("%d! = %d\n", n, factorial);

        factorial = 1;
        int count = 1;
        while (count <= n) {
            factorial *= count;
            count++;
        }
        System.out.printf("%d! = %d\n", n, factorial);

    }
}
