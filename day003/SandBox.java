public class SandBox {
    public static void main(String[] args) {

        System.out.println("FOO".compareTo("BAR"));
        System.out.println((true || false) && !true);
        System.out.println('a' >= 'A');
        System.out.println(2 >= 2.0);

        StringBuilder sb = new StringBuilder("Hello");
        sb.delete(1, 3);
        System.out.println(sb);

        String y = Character.toString(128_512);
        System.out.println(y);

        System.out.println("" + "\uD83D\uDE00");

        System.out.println("Всё верно! \uD83D\uDE0E");
    }
}