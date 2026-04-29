package stepik.ContactsApp.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import stepik.ContactsApp.common.utils.authentification.UserAuthentification;
import stepik.ContactsApp.model.enums.AppRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "contact_owners")
@Getter
@Setter
public class ContactOwner implements UserDetails // интерфейс UserDetails используется для аутентификации
{
    @Id
    @JsonProperty(index = 10)
    private String id;
    @JsonProperty(index = 20)
    private String username;
    @JsonIgnore
    private String password;
    @JsonProperty(index = 30)
    private String description;
    @JsonProperty(index = 40)
    private String email;
    @Column(name = "name")
    @JsonProperty(index = 50)
    private String fullName;
    @Enumerated(EnumType.STRING)
    @JsonProperty(index = 60)
    private AppRole role;

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JsonManagedReference  // ← основная сторона (сериализуется)
    @JsonProperty(index = 999)
    private List<Contact> contacts = new ArrayList<>();

    public ContactOwner() {
        this.id = UserAuthentification.getNewUserId();
        this.role = UserAuthentification.getNewUserRole();
        this.contacts = new ArrayList<>();
    }

    public ContactOwner(String username, String description) {
        this();
        this.username = username;
        this.description = description;
        this.role = UserAuthentification.getNewUserRole(username);
    }

    public ContactOwner(
            String id,
            String username,
            String password,
            String description,
            String email,
            String fullName,
            AppRole role
    ) {
        this();
        if (id != null && !id.isEmpty()) {
            this.id = id;
        }
        this.username = username;
        this.password = password;
        this.description = description;
        this.email = email;
        this.fullName = fullName;
        if (role != null && !role.name().isEmpty()) {
            this.role = role;
        }
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

    // всё далее - для реализации интерфейса аутентификации

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
