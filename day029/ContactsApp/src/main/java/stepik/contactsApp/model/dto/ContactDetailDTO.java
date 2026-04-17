package stepik.contactsApp.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetailDTO {
    private String detailDate;
    private String company;
    private String notes;
    private String tags;
}
