package ru.ksergey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderDetailItem {
    @JsonProperty
    public int orderDetailId;
    @JsonProperty
    public int orderHeaderId;
    @JsonProperty
    public int productId;
    @JsonProperty
    public Product product;
    @JsonProperty
    public int quantity;
    @JsonProperty
    public String itemName;
    @JsonProperty
    public int price;
}
