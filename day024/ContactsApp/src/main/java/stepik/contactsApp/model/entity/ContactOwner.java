package stepik.contactsApp.model.entity;

import stepik.contactsApp.model.enums.AppRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
public class ContactOwner {
    private String id;
    private String username;
    @JsonIgnore
    private String password;
    private String description;
    private String email;
    private String fullName;
    private AppRole role;

    private List<Contact> contacts = new ArrayList<>();

    public ContactOwner() {
        this.id = UUID.randomUUID().toString();
    }

    public ContactOwner(String username, String description) {
        this();
        this.username = username;
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof ContactOwner)) return false;
        ContactOwner that = (ContactOwner) obj;
        if (Objects.equals(this.id, that.id)
                && (that.username.equalsIgnoreCase(this.username))
                && (that.email.equalsIgnoreCase(this.email))) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username.toLowerCase(), email.toLowerCase());
    }

    public void updateWith(ContactOwner corrections){
        if (!this.id.equals(corrections.id)) return;

        if (corrections.username != null && !corrections.username.isEmpty()){
            this.username = corrections.username;
        }
        if (corrections.password != null && !corrections.password.isEmpty()){
            this.password = corrections.password;
        }
        if (corrections.description != null && !corrections.description.isEmpty()){
            this.description = corrections.description;
        }
        if (corrections.fullName != null && !corrections.fullName.isEmpty()){
            this.fullName = corrections.fullName;
        }
        if (corrections.email != null && !corrections.email.isEmpty()){
            this.email = corrections.email;
        }
        if (corrections.role != null && !corrections.role.toString().isEmpty()){
            this.role = corrections.role;
        }
    }
}
