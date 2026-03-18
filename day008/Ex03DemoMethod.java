public class Ex03DemoMethod {
    public static void main(String[] args) {
        sayHello();
        sayHello("Сергей");
        String result = getHelloWorld();
        System.out.println(result);

        String sum = getSum(10, 20);
        System.out.println(sum);
    }

    static String getSum(int x, int y) {
        String text = String.format("%d + %d = %d", x, y, x + y);
        return text;
    }

    static String getHelloWorld() {
        String text = "Привет, Мир!";
        return text;
    }

    static void sayHello() {
        System.out.println("Привет, пользователь!");
    }

    static void sayHello(String name) {
        System.out.printf("Привет, %s!\n", name);
    }

    // модификаторы тип имя(параметр1, параметр2,параметр3, . . .){
    // // тело
    // // return ...
    // }
}
