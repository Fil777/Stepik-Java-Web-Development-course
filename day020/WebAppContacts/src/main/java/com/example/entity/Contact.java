package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String sex;
    private String telephone;
    private String email;
}

