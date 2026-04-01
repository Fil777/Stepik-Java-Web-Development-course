package stepik.course.address;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class House implements Serializable {
    private int number;
    private Apartment apartment;

    public House(int number, Apartment apartment) {
        this.number = number;
        this.apartment = apartment;
    }
}
