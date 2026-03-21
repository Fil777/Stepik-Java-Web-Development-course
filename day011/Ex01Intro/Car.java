package Ex01Intro;

public class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public void startEngine() {
        System.out.println("У " + brand + " " + model + " двигатель запущен");
    }

    public void stopEngine() {
        System.out.println("Двигатель " + brand + " " + model + " заглушен");
    }
}
