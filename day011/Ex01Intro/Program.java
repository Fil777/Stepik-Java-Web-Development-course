package Ex01Intro;

public class Program {
    public static void main(String[] args) {
        Car car1 = new Car("audi", "RS6", 2026);
        car1.startEngine();
        System.out.println(car1.getModel());

        Car car2 = new Car("audi", "A5", 2026);
        car2.startEngine();
        System.out.println(car2.getModel());
    }
}
