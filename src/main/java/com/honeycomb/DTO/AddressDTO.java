package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.honeycomb.Entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;

    private UserDTO user;

    private String houseNo;
    private String street;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private Integer postalCode;
    private boolean isActive;

    // Getters, setters, and other essential methods
}
