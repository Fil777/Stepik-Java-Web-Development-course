package ru.ksergey.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Root {
    @JsonProperty
    public boolean isSuccess;
    @JsonProperty
    public int statusCode;
    @JsonProperty
    public ArrayList<Object> errorMessages;
    @JsonProperty
    public Result result;
}
