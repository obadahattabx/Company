package com.data.system.company.service;

import com.data.system.company.exceptions.ResourceNotFoundException;
import com.data.system.company.model.entity.Department;
import com.data.system.company.reporistary.DepRepo;
import jakarta.transaction.TransactionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepRepo depRepo;

    public  List<Department> getAllDepartment() {
        List<Department> departments=   depRepo.findAll();
        if (departments.isEmpty())
            throw new ResourceNotFoundException("Empty not found any department");
        return  departments;
    }


    public Department add_department(Department department){
        return depRepo.save(department);
    }

    public  Department update_department(int id,Department department){
        Department dp= depRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found department"));
        dp.setName(department.getName());
        return depRepo.save(dp);
    }

    public Optional<Department> findById(int id){
        return depRepo.findById(id);
    }

    public Department getDepartmentByID(int id){
        Department dp=depRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Department not found id"));
        return dp;
    }

    public void deleteDepartmentById(int id){
        Department department =depRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department not found by id for delete"));
        depRepo.delete(department);

    }
    public  List<Department>findbyname(String name){
        return  depRepo.findByName(name);
    }

    public List<Department> findDepartmentMinEmp(int minEmp){
        List<Department> departments=depRepo.findDepartmentWithMinEmp(minEmp);
        if(departments.isEmpty())
            throw new ResourceNotFoundException("not Found departments");
        return departments;
    }


}
