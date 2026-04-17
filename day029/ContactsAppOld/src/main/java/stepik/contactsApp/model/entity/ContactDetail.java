package stepik.contactsApp.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "contact_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "detail_date")
    private String detailDate;
    private String company;
    private String notes;
    private String tags;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore // ключевая фишка!!! иначе идёт зацикливание внутри json
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
