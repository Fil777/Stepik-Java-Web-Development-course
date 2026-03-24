package Ex01Animals;

class Bird {
    private String name;
    private int age;
    private double weight;
    private String species;
    private boolean canFly;

    public Bird(String name, int age, double weight, String species, boolean canFly) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.species = species;
        this.canFly = canFly;
    }

    public void eat() {
        System.out.println(name + " ест");
    }

    public void sleep() {
        System.out.println(name + " спит");
    }

    public void chirp() {
        System.out.println(name + " чирикает: Чик-чирик!");
    }

    public void fly() {
        if (canFly) {
            System.out.println(name + " летает");
        } else {
            System.out.println(name + " не может летать");
        }
    }
}
