package com.data.system.company.controller;


import com.data.system.company.model.entity.Department;
import com.data.system.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> addDepartmanet(@RequestBody Department department){
          Department dp=departmentService.add_department(department);
          return new ResponseEntity<>(dp, HttpStatus.OK);

    }

    @GetMapping("/getAllDepartment")
    public ResponseEntity<List<Department>> getAllDepartment(){

            List<Department> listDepartment=departmentService.getAllDepartment();
            return new ResponseEntity<>(listDepartment,HttpStatus.OK);

    }

    @PutMapping("/updateDepartment")
    public ResponseEntity<Department> updateDepartment(@RequestParam int id ,@RequestBody Department department){
        Department dp=departmentService.update_department(id,department);
        return new ResponseEntity<>(dp,HttpStatus.OK);
    }

    @GetMapping("/getDepartment/{id}")
    public  ResponseEntity<Department> getDepartmentById(@PathVariable int id){
        return new ResponseEntity<>(departmentService.getDepartmentByID(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteDepartment")
    public ResponseEntity<?> deleteDepartmentbyid(@RequestParam int id){
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>(new MessageResponse("Success"),HttpStatus.OK);
    }

    @GetMapping("/findDepartment/{name}")
    public ResponseEntity<List<Department>> getDepartmentByname(@PathVariable String name){
        List<Department> departments=departmentService.findbyname(name);
        return  new ResponseEntity<>(departments,HttpStatus.OK);
    }

    @GetMapping("/findDepartmentMinEmpolyees")
    public  ResponseEntity<List<Department>> getDepartmentMinEmp(@RequestParam int minEmp){
        List<Department> departments=departmentService.findDepartmentMinEmp(minEmp);
        return  new ResponseEntity<>(departments,HttpStatus.OK);
    }

    public record MessageResponse(String message) {}





}
