package com.data.system.company.controller;


import com.data.system.company.exceptions.ResourceNotFoundException;
import com.data.system.company.model.dto.EmployeesDTO;
import com.data.system.company.model.dto.EmployeesWithAddressDto;
import com.data.system.company.model.dto.EmployeesWithProjectDto;
import com.data.system.company.model.entity.Address;
import com.data.system.company.model.entity.Employees;
import com.data.system.company.model.projection.EmployeesTaskProjection;
import com.data.system.company.service.EmployessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeesController {

    @Autowired
    private EmployessService employessService;

    @PostMapping("/addEmployees")
    private ResponseEntity<?> addEmp(@RequestBody EmployeesDTO employeesDTO , @RequestParam int departmentId){
        return  new ResponseEntity<>(employessService.addEmployees(employeesDTO,departmentId),HttpStatus.OK);
    }

    @GetMapping("/getallemp")
    public ResponseEntity<List<EmployeesDTO>> getAllEmp(){
        List<EmployeesDTO> employees=employessService.getAllEmp();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/getemp/{id}")
    public ResponseEntity<EmployeesDTO> getemp(@PathVariable int id){
       return new ResponseEntity<>(employessService.getEmpbyid(id),HttpStatus.OK) ;
    }



    @PostMapping("/addProjectToEmployee")
    public ResponseEntity<EmployeesWithProjectDto> assignprojectEmp(@RequestParam int employeeId, @RequestParam int projectId){
        return new ResponseEntity<>(employessService.assignProjectToEmployee(employeeId,projectId),HttpStatus.OK);
    }

    @GetMapping("/employeesByProjectId")
    public ResponseEntity<List<EmployeesWithProjectDto>> findEmployeesByProjectId(@RequestParam int projectId){
        return new ResponseEntity<>(employessService.findEmployeesByProjectId(projectId),HttpStatus.OK);
    }

    @PostMapping("/addAddressToEmployees")
    public ResponseEntity<EmployeesWithAddressDto> assignAddressToEmployees(@RequestParam int employeeId, @RequestBody Address address){
        EmployeesWithAddressDto employees=employessService.assignAddressToEmployees(employeeId,address);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @GetMapping("/getEmployeesAddress")
    public  ResponseEntity<List<EmployeesWithAddressDto>> getempadd(){
        return new ResponseEntity<>(employessService.getEmployessAddress(),HttpStatus.OK);
    }

    @GetMapping("/getEmployeeTasks")
    public  ResponseEntity<List<EmployeesTaskProjection>> getEmpTask(@RequestParam int projectId){
        return new ResponseEntity<>(employessService.getEmployeesWithTaskByProjectId(projectId),HttpStatus.OK);
    }




}
