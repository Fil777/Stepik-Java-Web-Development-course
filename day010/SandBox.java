import java.util.ArrayList;
import java.util.Scanner;

public class SandBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">");
        String input = scanner.nextLine();
        System.out.println("input = '" + input + "'");
        scanner.close();
    }
}
