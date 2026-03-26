package ru.ksergey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ContactsResponse {
    @JsonProperty
    ArrayList<Contact> contacts;
    @JsonProperty
    int totalCount;
    @JsonProperty
    int currentPage;
    @JsonProperty
    int pageSize;
}
