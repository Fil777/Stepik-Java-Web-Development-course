package ru.ksergey.dip.ex02;

public class Program {
    public static void main(String[] args) {
        DictionaryStorage storage = new DictionaryStorage();
        new SearchByLastName(storage).search();
        new SearchByFirstName(storage).search();
        new SearchByAge(storage).search();
    }
}
