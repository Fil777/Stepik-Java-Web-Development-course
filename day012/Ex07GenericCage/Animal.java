package Ex07GenericCage;

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void eat();

    public abstract <F extends Food> void eat(F food);

    public abstract <F extends Food> boolean canEat(F food);
}
