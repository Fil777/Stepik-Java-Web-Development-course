package ru.ksergey.dip.ex03;

public class SearchByAge {
    private FindStorage storage;

    public SearchByAge(FindStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.findAll(e -> e.getAge() > 45)) {
            System.out.println(p.getFirstName() + " " + p.getAge());
        }
        System.out.println();
    }
}
