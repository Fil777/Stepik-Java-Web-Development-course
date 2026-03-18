public class Ex02ForLoop {
    public static void main(String[] args) {

        // Цикл для вывода чисел от 1 до 10
        for (int count = 1; count <= 10; count++) {
            System.out.print(count + " ");
        }

        System.out.println(); // Переход на новую строку

        // Цикл с шагом 0.5 от 0 до 2 включительно
        for (double i = 0; i <= 2; i += 0.5) {
            System.out.println(i);
        }

        System.out.println(); // Еще один переход на новую строку
    }
}
