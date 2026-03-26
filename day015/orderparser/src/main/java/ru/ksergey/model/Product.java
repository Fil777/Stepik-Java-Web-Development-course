package ru.ksergey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Product {
    @JsonProperty
    public int id;
    @JsonProperty
    public String name;
    @JsonProperty
    public String description;
    @JsonProperty
    public String specialTag;
    @JsonProperty
    public String category;
    @JsonProperty
    public double price;
    @JsonProperty
    public String image;
}
