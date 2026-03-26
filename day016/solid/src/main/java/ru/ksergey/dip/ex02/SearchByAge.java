package ru.ksergey.dip.ex02;

public class SearchByAge {
    private DictionaryStorage storage;

    public SearchByAge(DictionaryStorage storage) {
        this.storage = storage;
    }

    public void search() {
        for (Person p : storage.getPersons().values()) {
            if (p.getAge() > 45) {
                System.out.println(p.getFirstName() + " " + p.getAge());
            }
        }
        System.out.println();
    }
}
