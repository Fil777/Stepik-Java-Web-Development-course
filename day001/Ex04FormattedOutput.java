public class Ex04FormattedOutput {
    public static void main(String[] args) {
        // System.out.printf(String format, Object... args);
        // - %s – строка
        // - %d – целое число
        // - %f – число с плавающей запятой
        // - %t – дата/время
        // - %x – шестнадцатеричное число

        // Привет, Имя!
        String name = "Сергей";
        // System.out.println("Привет, " + name + "!");
        System.out.printf("Привет, %s!\n", name);
        int x = 10;
        int y = 5;
        int result = x + y;
        String title = "Результат";
        System.out.println(title + ": " + x + " + " + y + " = " + result);
        System.out.printf("%s: %d + %d = %d\n", title, x, y, result);
        System.out.printf("%x\n", 0xff);

        String output = String.format(">> %s: %d + %d = %d\n", title, x, y, result);
        System.out.println(output);

    }
}
