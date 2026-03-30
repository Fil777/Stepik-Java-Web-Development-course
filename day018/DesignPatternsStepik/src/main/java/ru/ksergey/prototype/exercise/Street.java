package ru.ksergey.prototype.exercise;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Street implements Serializable {
    private String name;
    private House house;

    public Street(String name, House house) {
        this.name = name;
        this.house = house;
    }
}
