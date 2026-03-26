package contactapp.business.model;

import java.util.Objects;

public class Contact {
    private int id;
    private String name;
    private String email;

    public Contact(int id) {
        this.id = id;
    }

    public Contact(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Contact contact = (Contact) obj;
        return contact.id == this.id
                && Objects.equals(contact.name, this.name)
                && Objects.equals(contact.email, this.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}
