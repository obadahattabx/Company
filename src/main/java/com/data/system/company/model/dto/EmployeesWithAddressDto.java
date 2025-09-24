package com.data.system.company.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmployeesWithAddressDto {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private double salary;
    private AddressDto addressDto;
}
