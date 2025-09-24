package com.data.system.company.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class EmployeesWithProjectDto {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private double salary;
    private List<ProjectDTO> projectDTOList;
}
