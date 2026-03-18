import java.util.Scanner;

public class Task20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) == ' ' || input.charAt(i) == '.' || input.charAt(i) == ',')) {
                counter++;
            }
        }
        System.out.println("Количество символов в строке: " + counter);

    }
}
