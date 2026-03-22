package core;

public class Terminal {

    public static void write(String s) {
        System.out.print(s);
    }

    public static void writeLine(String s) {
        write(s + "\n");
    }

    public static void writeLine() {
        write("\n");
    }

    public static void writeNewLine(String s) {
        write("\n" + s + "\n");
    }

}
