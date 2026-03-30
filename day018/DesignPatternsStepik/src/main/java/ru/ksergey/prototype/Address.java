package ru.ksergey.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private String street;
    private String city;

    public Address(Address address) {
        this.street = address.street;
        this.city = address.city;
    }

    public static Address copyAddress(Address address) {
        return new Address(address.street, address.city);
    }
}
