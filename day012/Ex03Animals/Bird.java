package Ex03Animals;

class Bird extends Animal implements SoundMaker {
    private String species;
    private boolean canFly;

    public Bird(String name, int age, double weight, String species, boolean canFly) {
        super(name, age, weight);
        this.species = species;
        this.canFly = canFly;
    }

    public void fly() {
        if (canFly) {
            System.out.println(name + " летает");
        } else {
            System.out.println(name + " не может летать");
        }
    }

    @Override
    public void makeSound() {
        System.out.println(name + " чирикает: Чик-чирик!");
    }
}
