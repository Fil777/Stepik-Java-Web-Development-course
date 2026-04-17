package stepik.contactsApp.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String detailDate;
    private String company;
    private String notes;
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
