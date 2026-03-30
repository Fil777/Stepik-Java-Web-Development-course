package ru.ksergey.prototype;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
public class User {
    private ArrayList<String> names;

    @Getter
    @Setter
    private Address address;

    public User(String firstName, String middleName,
            String lastName, Address address) {
        this.names = new ArrayList<>();
        this.names.add(firstName);
        this.names.add(middleName);
        this.names.add(lastName);
        this.address = address;
    }

    public User(User user) {
        // this.address = new Address(user.address);
        this.address = Address.copyAddress(user.address);
        this.names = new ArrayList<>();
        names.addAll(user.names);
    }

    public String getFirstName() {
        return names.getFirst();
    }

    public void setMiddleName(String middleName) {
        names.set(1, middleName);
    }

    public String getMiddleName() {
        if (names.size() < 3) {
            return "";
        }
        return names.get(1);
    }

    public String getLastName() {
        return names.get(2);
    }
}
