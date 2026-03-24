package Ex07GenericCage;

class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Лев " + name + " ест");
    }

    @Override
    public <F extends Food> void eat(F food) {
        if (food instanceof Meat) {
            System.out.println("Лев " + name + " ест " + food.getName());
        } else {
            System.out.println("Лев " + name + " не ест " + food.getName());
        }
    }

    @Override
    public <F extends Food> boolean canEat(F food) {
        return food instanceof Meat;
    }
}
