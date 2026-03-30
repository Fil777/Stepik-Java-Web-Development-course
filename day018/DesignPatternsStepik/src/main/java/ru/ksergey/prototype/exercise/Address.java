package ru.ksergey.prototype.exercise;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

@Getter
@Setter
public class Address implements Serializable {
    private City city;

    public Address(City city) {
        this.city = city;
    }

    public Address(Address original) {
        this.city = SerializationUtils.roundtrip(original).city;
    }
}
