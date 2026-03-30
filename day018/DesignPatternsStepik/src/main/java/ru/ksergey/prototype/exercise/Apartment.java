package ru.ksergey.prototype.exercise;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Apartment implements Serializable {
    private String number;

    public Apartment(String number) {
        this.number = number;
    }
}
