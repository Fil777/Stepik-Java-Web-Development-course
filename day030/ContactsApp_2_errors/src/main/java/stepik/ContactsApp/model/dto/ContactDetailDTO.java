package stepik.ContactsApp.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetailDTO {
    @JsonProperty(index = 10)
    private String detailDate;
    @JsonProperty(index = 20)
    private String company;
    @JsonProperty(index = 30)
    private String notes;
    @JsonProperty(index = 40)
    private String tags;
}
