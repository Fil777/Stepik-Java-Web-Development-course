package ru.ksergey.builder;

public class Main {
    public static void main(String[] args) {
        PostalAddress address = PostalAddress
                .builder()
                .index("123456")
                .country("Россия")
                .region("Московская область")
                .city("Химки")
                .street("Ленина")
                .houseNumber("10")
                .buildingNumber("2")
                .apartmentNumber("45")
                .recipientFullName("Иванов Иван Иванович")
                .build();

        System.out.println(address);
    }
}
