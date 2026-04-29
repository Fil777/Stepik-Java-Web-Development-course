package stepik.ContactsApp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stepik.ContactsApp.model.enums.AppRole;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactOwnerDTO {
    @Id
    @JsonProperty(index = 10)
    private String id;
    @JsonProperty(index = 20)
    private String username;
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
}
