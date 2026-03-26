package ru.ksergey.dip.ex02;

public class SearchByFirstName {
    private DictionaryStorage storage;

    public SearchByFirstName(DictionaryStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.getPersons().values()) {
            if (p.getFirstName().contains("Name_3")) {
                System.out.println(p.getFirstName() + " " + p.getLastName());
            }
        }
        System.out.println();
    }
}
