package Ex02Animals;

class Cat extends Animal {
    private String furColor;

    public Cat(String name, int age, double weight, String furColor) {
        super(name, age, weight);
        this.furColor = furColor;
    }

    public void bark() {
        System.out.println(name + " мяукает: Мая!");
    }

    public void scratch() {
        System.out.println(name + " царапает мебель");
    }

    @Override
    public void makeSound() {
        this.bark();
    }
}
