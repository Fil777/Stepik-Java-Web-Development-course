package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ContactResponse {
    @JsonProperty
    ArrayList<Contact> contacts = new ArrayList<>();
    @JsonProperty
    int totalCount;
    @JsonProperty
    int currentPage;
    @JsonProperty
    int pageSize;

    @Override
    public String toString() {
        return "ContactResponse{" +
                "contacts=" + contacts +
                ", totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
