package Ex04Animals;

class Cat extends Animal implements SoundMaker {
    private String furColor;

    public Cat(String name, int age, double weight, String furColor) {
        super(name, age, weight);
        this.furColor = furColor;
    }

    public void scratch() {
        System.out.println(name + " царапает мебель");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " мяукает: Мая!");
    }
}
