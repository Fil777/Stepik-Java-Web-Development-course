package ru.ksergey.dip.ex01;

public class Program {
    public static void main(String[] args) {
        ListStorage storage = new ListStorage();
        new SearchByLastName(storage).search();
        new SearchByFirstName(storage).search();
        new SearchByAge(storage).search();
    }
}
