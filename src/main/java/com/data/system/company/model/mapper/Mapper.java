package com.data.system.company.model.mapper;

import com.data.system.company.model.dto.*;
import com.data.system.company.model.entity.*;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {

    public DepartmentDTO toDepartmentDto(Department department){
        DepartmentDTO dto=DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .build();

        return dto;
    }
    public Department toDepartment(DepartmentDTO departmentDTO){
        Department department=Department.builder()
                .id(departmentDTO.getId())
                .name(departmentDTO.getName())
                .build();
        return department;
    }

    public ProjectDTO toProjectDto(Project project){
        ProjectDTO dto=ProjectDTO.builder()
                .id(project.getId())
                .title(project.getTitle())
                .budget(project.getBudget())
                .build();
        return dto;
    }

    public Project toProject(ProjectDTO projectDTO){
        Project project=Project.builder()
                .id(projectDTO.getId())
                .title(projectDTO.getTitle())
                .budget(projectDTO.getBudget())
                .build();
        return  project;

    }


    public EmployeesDTO toEmployeesDto(Employees employees){
        EmployeesDTO dto=EmployeesDTO.builder()
                .id(employees.getId())
                .firstname(employees.getFirstname())
                .lastname(employees.getLastname())
                .salary(employees.getSalary())
                .email(employees.getEmail())
                .phoneNumber(employees.getPhoneNumber())
                .departmentDTO(toDepartmentDto(employees.getDepartment()))
                .build();
        return dto;
    }

    public Employees toEmployees(EmployeesDTO employeesDTO){
        Employees employees=Employees.builder()
                .id(employeesDTO.getId())
                .firstname(employeesDTO.getFirstname())
                .lastname(employeesDTO.getLastname())
                .salary(employeesDTO.getSalary())
                .email(employeesDTO.getEmail())
                .phoneNumber(employeesDTO.getPhoneNumber())
                .build();
        return employees;
    }

    public EmployeesWithProjectDto toEmployeesWithProjectDto(Employees employees){
        EmployeesWithProjectDto dto=EmployeesWithProjectDto.builder()
                .id(employees.getId())
                .firstname(employees.getFirstname())
                .lastname(employees.getLastname())
                .email(employees.getEmail())
                .salary(employees.getSalary())
                .phoneNumber(employees.getPhoneNumber())
                .projectDTOList(employees.getProjectList().stream()
                        .map(p->toProjectDto(p)).collect(Collectors.toList()))
                .build();
        return  dto;
    }

    public AddressDto toAddressDto(Address address){
        return AddressDto.builder()
                .id(address.getId())
                .city(address.getCity())
                .streetAddress(address.getStreetAddress())
                .postalCode(address.getPostalCode())
                .build();
    }

    public EmployeesWithAddressDto toemployeesWithAddressDto(Employees employees){
        return EmployeesWithAddressDto.builder()
                .id(employees.getId())
                .firstname(employees.getFirstname())
                .lastname(employees.getLastname())
                .salary(employees.getSalary())
                .email(employees.getEmail())
                .phoneNumber(employees.getPhoneNumber())
                .addressDto(toAddressDto(employees.getAddress()))
                .build();
    }

    public TasksDTO tasksDTO(Tasks tasks){
        return TasksDTO.builder()
                .id(tasks.getId())
                .title(tasks.getTitle())
                .desc(tasks.getDesc())
                .priority(tasks.getPriority())
                .estaimatedHours(tasks.getEstaimatedHours())
                .employeesDto(toEmployeesDto(tasks.getEmployees()))
                .projectDTO(toProjectDto(tasks.getProject()))
                .build();
    }
}
