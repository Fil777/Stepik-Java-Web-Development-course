package core;

public class EmptyPerson extends Person{
    public EmptyPerson(String name, int age) {
        super(name, age);
    }
    public EmptyPerson(){
        super("",0);
    }
}
