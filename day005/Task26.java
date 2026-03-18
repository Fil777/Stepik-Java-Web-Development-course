import java.util.Scanner;

public class Task26 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = scanner.nextLine();
        scanner.close();

        boolean repeatBlank = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                if (!repeatBlank) {
                    sb.append('_');
                    repeatBlank = true;
                }
            } else {
                sb.append(input.charAt(i));
                repeatBlank = false;
            }
        }
        System.out.println("Строка без пробелов: " + sb.toString());
    }
}
