package com.project_coche.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private String cardId;
    private String firstName;
    private String email;
    private double numberPhone;
    private Integer active;
    private String password;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "active=" + active +
                ", cardId='" + cardId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", numberPhone=" + numberPhone +
                ", password='" + password + '\'' +
                '}';
    }
}
