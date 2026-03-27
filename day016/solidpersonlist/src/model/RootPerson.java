package model;

public class RootPerson extends Person{
    protected RootPerson(){
        super(0,"",0);
    }
    protected RootPerson(int id, String name, int age){
        super(id, name, age);
    }
}
