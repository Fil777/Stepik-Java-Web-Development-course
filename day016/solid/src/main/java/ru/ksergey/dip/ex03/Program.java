package ru.ksergey.dip.ex03;

public class Program {
    public static void main(String[] args) {
        System.out.println("DictionaryStorage:");
        FindStorage dictionaryStorage = new DictionaryStorage();
        new SearchByLastName(dictionaryStorage).search();
        new SearchByFirstName(dictionaryStorage).search();
        new SearchByAge(dictionaryStorage).search();

        System.out.println("ListStorage:");
        FindStorage listStorage = new ListStorage();
        new SearchByLastName(listStorage).search();
        new SearchByFirstName(listStorage).search();
        new SearchByAge(listStorage).search();
    }
}
