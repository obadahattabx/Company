package com.data.system.company.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeesDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private double salary;
    private DepartmentDTO departmentDTO;


}
