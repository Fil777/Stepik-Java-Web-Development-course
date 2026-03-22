package library;

public class TerminalView {
    public static void print(String str) {
        System.out.println("info: " + str);
    }

    public static void print(int value) {
        System.out.println("info: " + value);
    }

    public static void printMathPi() {
        System.out.println(MathUtils.PI);
    }
}
