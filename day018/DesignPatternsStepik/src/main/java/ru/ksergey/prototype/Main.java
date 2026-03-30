package ru.ksergey.prototype;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("ул. Ленина", "Москва");
        User user = new User("Иван", "Иванович", "Иванов", address);

        System.out.println("Имя: " + user.getFirstName());
        System.out.println("Отчество: " + user.getMiddleName());
        System.out.println("Фамилия: " + user.getLastName());
        System.out.println("Адрес: " + user.getAddress().getStreet() + ", " + user.getAddress().getCity());

        System.out.println(user.getAddress().getCity());

        User user1 = new User(user);
        user1.setMiddleName("Петрович");
        user1.getAddress().setCity("Химки");

        System.out.println(user1.getAddress().getCity());
        System.out.println(user1.getMiddleName());

        System.out.println(user.getAddress().getCity());
        System.out.println(user.getMiddleName());

    }
}
