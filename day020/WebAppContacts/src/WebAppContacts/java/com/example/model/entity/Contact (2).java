package com.example.model.entity;

import com.example.model.dto.CreateContactDTO;
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
    private Integer id;
    private String firstName;
    private String lastName;
    private String sex;
    private String birthDate;
    private String telephone;
    private String email;

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

    public void updateWith(Contact corrections){
        if (this.id != corrections.id) return;

        if (corrections.firstName != null && !corrections.firstName.isEmpty()){
            this.firstName = corrections.firstName;
        }
        if (corrections.lastName != null && !corrections.lastName.isEmpty()){
            this.lastName = corrections.lastName;
        }
        if (corrections.sex != null && !corrections.sex.isEmpty()){
            this.sex = corrections.sex;
        }
        if (corrections.birthDate != null && !corrections.birthDate.isEmpty()){
            this.birthDate = corrections.birthDate;
        }
        if (corrections.telephone != null && !corrections.telephone.isEmpty()){
            this.telephone = corrections.telephone;
        }
        if (corrections.email != null && !corrections.email.isEmpty()){
            this.email = corrections.email;
        }
    }
}

