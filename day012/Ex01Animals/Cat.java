package Ex01Animals;

class Cat {
    private String name;
    private int age;
    private double weight;
    private String furColor;

    public Cat(String name, int age, double weight, String furColor) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.furColor = furColor;
    }

    public void eat() {
        System.out.println(name + " ест");
    }

    public void sleep() {
        System.out.println(name + " спит");
    }

    public void bark() {
        System.out.println(name + " мяукает: Мая!");
    }

    public void scratch() {
        System.out.println(name + " царапает мебель");
    }
}
