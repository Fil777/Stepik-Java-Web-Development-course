package ru.ksergey.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostalAddress {
    private String index = "";
    private String country = "";
    private String region = "";
    private String city = "";
    private String street = "";
    private String houseNumber = "";
    private String buildingNumber = "";
    private String apartmentNumber = "";
    private String recipientFullName = "";

    public String getFullAddress() {
        return String.format("%s, %s, %s, %s, ул. %s, д. %s, корп. %s, кв. %s, получатель: %s",
                index, country, region, city, street,
                houseNumber, buildingNumber, apartmentNumber,
                recipientFullName);
    }

    @Override
    public String toString() {
        return getFullAddress();
    }
}
