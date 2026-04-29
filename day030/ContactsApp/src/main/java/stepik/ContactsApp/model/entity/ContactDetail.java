package stepik.ContactsApp.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    @Column(name = "detail_date")
    @JsonProperty(index = 10)
    private String detailDate;
    @JsonProperty(index = 20)
    private String company;
    @JsonProperty(index = 30)
    private String notes;
    @JsonProperty(index = 40)
    private String tags;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public void updateWith(ContactDetail corrections){
        if (this.id != corrections.id) return;

        if (corrections.detailDate != null && !corrections.detailDate.isEmpty()){
            this.detailDate = corrections.detailDate;
        }
        if (corrections.company != null && !corrections.company.isEmpty()){
            this.company = corrections.company;
        }
        if (corrections.notes != null && !corrections.notes.isEmpty()){
            this.notes = corrections.notes;
        }
        if (corrections.tags != null && !corrections.tags.isEmpty()){
            this.tags = corrections.tags;
        }
    }
}
