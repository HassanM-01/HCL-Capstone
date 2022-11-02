package com.hassan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private long id;
    private String city;
    private String country;
    private String state;
    private String street;
    private String zipCode;
}
