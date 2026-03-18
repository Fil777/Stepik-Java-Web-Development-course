import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.printf("Я так ждала Вас, %s!", name);

        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // System.out.print("Введите имя: ");
        // String name = reader.readLine();
        // System.out.println("Привет, " + name + "!");
        // reader.close();

        // Console console = System.console();
        // String name = console.readLine("Введите имя: ");
        // System.out.println("Привет, " + name + "!");

        // char[] password = console.readPassword("Введите пароль: ");
        // System.out.println("Ваш пароль: " + new String(password));

        // for (char ch : password) {
        // System.out.print(ch);
        // }

    }
}