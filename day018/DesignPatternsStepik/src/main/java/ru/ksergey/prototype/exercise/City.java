package ru.ksergey.prototype.exercise;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class City implements Serializable {
    private String name;
    private Street street;

    public City(String name, Street street) {
        this.name = name;
        this.street = street;
    }
}
