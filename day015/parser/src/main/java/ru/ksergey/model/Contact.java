package ru.ksergey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Contact {
    @JsonProperty
    int id;
    @JsonProperty
    String name;
    @JsonProperty
    String email;
}
