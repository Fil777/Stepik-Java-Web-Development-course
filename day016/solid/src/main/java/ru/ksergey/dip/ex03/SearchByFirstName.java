package ru.ksergey.dip.ex03;

public class SearchByFirstName {
    private FindStorage storage;

    public SearchByFirstName(FindStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.findAll(e -> e.getFirstName().contains("Name_3"))) {
            System.out.println(p.getFirstName() + " " + p.getAge());
        }
        System.out.println();
    }
}
