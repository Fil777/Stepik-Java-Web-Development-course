package stepik.ContactsApp.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contacts")
public class Contact {
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_seq")
//    @SequenceGenerator(name = "contacts_seq", sequenceName = "contacts_seq", initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(index = 10)
    private Integer id;
    @Column(name = "first_name")
    @JsonProperty(index = 20)
    private String firstName;
    @JsonProperty(index = 30)
    @Column(name = "last_name")
    private String lastName;
    @JsonProperty(index = 40)
    private String sex;
    @JsonProperty(index = 50)
    @Column(name = "birth_date")
    private String birthDate;
    @JsonProperty(index = 60)
    private String telephone;
    @JsonProperty(index = 70)
    private String email;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference  // ← обратная сторона (не сериализуется)
    @JsonProperty(index = 999)
    private ContactOwner owner;

    @OneToOne(
            mappedBy = "contact",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonProperty(index = 1000)
    private ContactDetail contactDetail;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Contact)) return false;
        Contact that = (Contact) obj;
        if (Objects.equals(this.id, that.id)
                && (that.firstName.equalsIgnoreCase(this.firstName))
                && (that.lastName.equalsIgnoreCase(this.lastName))
                && (that.email.equalsIgnoreCase(this.email))) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName.toLowerCase(), lastName.toLowerCase(), email.toLowerCase());
    }
}

