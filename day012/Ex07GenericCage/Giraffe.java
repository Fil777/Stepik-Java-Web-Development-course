package Ex07GenericCage;

class Giraffe extends Animal {
    public Giraffe(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Жираф " + name + " ест");
    }

    @Override
    public <F extends Food> void eat(F food) {
        if (food instanceof Grass) {
            System.out.println("Жираф " + name + " ест " + food.getName());
        } else {
            System.out.println("Жираф " + name + " не ест " + food.getName());
        }
    }

    @Override
    public <F extends Food> boolean canEat(F food) {
        return food instanceof Grass;
    }
}
