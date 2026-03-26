package ru.ksergey.dip.ex03;

public class SearchByLastName {
    private FindStorage storage;

    public SearchByLastName(FindStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.findAll(e -> e.getLastName().contains("_"))) {
            System.out.println(p.getFirstName().substring(0, 4) + "...");
        }
        System.out.println();
    }
}
