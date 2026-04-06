package ru.ksergey.contactApp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String telephone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id
                && Objects.equals(firstName, contact.firstName)
                && Objects.equals(lastName, contact.lastName)
                && Objects.equals(telephone, contact.telephone)
                && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, telephone, email);
    }

    private String email;
}
