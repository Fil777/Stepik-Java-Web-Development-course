package exercises;

public class Exercise08 {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2)); // true
        System.out.println(isPrime(4)); // false
        System.out.println(isPrime(5)); // true
        System.out.println(isPrime(11)); // true
        System.out.println(isPrime(15)); // false
    }
}
