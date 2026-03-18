import java.util.Scanner;

public class Task21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = scanner.nextLine();
        System.out.println("Введите символ для поиска: ");
        char searchChar = scanner.nextLine().charAt(0);
        scanner.close();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == searchChar) {
                System.out.println("Символ '" + searchChar + "' найден в строке на позиции: " + i);
            }
        }
    }
}
