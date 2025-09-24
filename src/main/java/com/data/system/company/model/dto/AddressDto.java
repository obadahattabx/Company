package com.data.system.company.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddressDto {
    private int id;
    private String city;
    private String streetAddress;
    private String postalCode;


}
