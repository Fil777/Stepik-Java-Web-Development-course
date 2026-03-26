package ru.ksergey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Result {
    @JsonProperty
    public int orderHeaderId;
    @JsonProperty
    public String customerName;
    @JsonProperty
    public String customerEmail;
    @JsonProperty
    public String appUserId;
    @JsonProperty
    public int orderTotalAmount;
    @JsonProperty
    public Date orderDateTime;
    @JsonProperty
    public String status;
    @JsonProperty
    public int totalCount;
    @JsonProperty
    public ArrayList<OrderDetailItem> orderDetailItems;
}
