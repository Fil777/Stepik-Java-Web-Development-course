package stepik.course;

import stepik.course.address.*;

public class Exercise {
    public static void main(String[] args) {
        Apartment room = new Apartment("10");
        House house = new House(25, room);
        Street street = new Street("Пушкина", house);
        City city = new City("Москва", street);
        Address address = new Address(city);

        // Можно получить детали адреса
        System.out.print("Город: ");
        System.out.println(address.getCity().getName());
        System.out.print("Улица: ");
        System.out.println(address.getCity().getStreet().getName());
        System.out.print("Дом: ");
        System.out.println(address.getCity().getStreet().getHouse().getNumber());
        System.out.print("Квартира: ");
        System.out.println(address.getCity().getStreet().getHouse().getApartment().getNumber());

        Address newAddress = new Address(address);

        newAddress.getCity()
                .getStreet()
                .getHouse()
                .setApartment(new Apartment("227B"));

        System.out.println("\nВсе данные скопировались SerializationUtils.roundtrip, а квартиру мы поменяли:\n");

        System.out.print("Город: ");
        System.out.println(newAddress.getCity().getName());
        System.out.print("Улица: ");
        System.out.println(newAddress.getCity().getStreet().getName());
        System.out.print("Дом: ");
        System.out.println(newAddress.getCity().getStreet().getHouse().getNumber());
        System.out.print("Квартира: ");
        System.out.println(newAddress.getCity().getStreet().getHouse().getApartment().getNumber());

    }
}
