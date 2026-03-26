package ru.ksergey.dip.ex02;

public class SearchByLastName {
    private DictionaryStorage storage;

    public SearchByLastName(DictionaryStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.getPersons().values()) {
            if (p.getLastName().contains("_")) {
                System.out.println(p.getFirstName().substring(0, 4) + "...");
            }
        }
        System.out.println();
    }
}
