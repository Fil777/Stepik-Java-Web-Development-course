package ui;

public class Terminal {

    public static void write(String text) {
        System.out.print(text);
    }

    public static void writeLine(String text) {
        write(text + "\n");
    }

    public static void writeLine() {
        write("\n");
    }

    public static void writeNewLine(String text) {
        write("\n" + text + "\n");
    }

}