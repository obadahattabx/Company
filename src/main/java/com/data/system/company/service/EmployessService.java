package com.data.system.company.service;

import com.data.system.company.exceptions.ResourceNotFoundException;
import com.data.system.company.model.dto.EmployeesDTO;
import com.data.system.company.model.dto.EmployeesWithAddressDto;
import com.data.system.company.model.dto.EmployeesWithProjectDto;
import com.data.system.company.model.entity.Address;
import com.data.system.company.model.entity.Employees;
import com.data.system.company.model.entity.Project;
import com.data.system.company.model.mapper.Mapper;
import com.data.system.company.model.projection.EmployeesTaskProjection;
import com.data.system.company.reporistary.EmpRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployessService {

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private AddressService addressService;


    public  EmployeesDTO getEmpbyid(int id){
        Employees e= empRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not found Employess"));

        return mapper.toEmployeesDto(e);
    }

    public  Employees getEmpolyeesbyid(int id){
        Employees e= empRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not found Employess"));

        return e;
    }

    public List<EmployeesDTO> getAllEmp() {
        List<Employees>employees=empRepo.findAll();
        if(employees.isEmpty())
            throw new ResourceNotFoundException("not found employees");

        List<EmployeesDTO> employeesDTO=employees.stream()
                .map(i->mapper.toEmployeesDto(i))
                .collect(Collectors.toList());
        return employeesDTO;
    }

    public EmployeesDTO addEmployees(EmployeesDTO employeesDTO , int departmentId) {
        Employees employees=mapper.toEmployees(employeesDTO);
        employees.setDepartment(departmentService.findById(departmentId)
                .orElseThrow(()->new ResourceNotFoundException("not found Department id : " + departmentId)));


        return mapper.toEmployeesDto(empRepo.save(employees));
    }


    public EmployeesWithProjectDto assignProjectToEmployee(int emp_id, int proj_id){
        Project project=projectService.getProjectById(proj_id)
                .orElseThrow(()->new ResourceNotFoundException("not found project by id: "+proj_id));
        Employees employees=empRepo.findById(emp_id)
                .orElseThrow(()->new ResourceNotFoundException("not found employee by id: "+emp_id));

        employees.getProjectList().add(project);
        return  mapper.toEmployeesWithProjectDto(empRepo.save(employees));
    }

    public List<EmployeesWithProjectDto> findEmployeesByProjectId(int projectId){
        List<Employees> employees=empRepo.findByProjectId(projectId);
        if(employees.isEmpty())
            throw new ResourceNotFoundException("not found employees");

        List<EmployeesWithProjectDto> employeesWithProjectDtos=employees.stream()
                .map(e->mapper.toEmployeesWithProjectDto(e))
                .collect(Collectors.toList());
        return employeesWithProjectDtos;
    }

    public EmployeesWithAddressDto assignAddressToEmployees(int emp_id, Address address){
        Employees employees=empRepo.findById(emp_id)
                .orElseThrow(()->new ResourceNotFoundException("not found Employees by id: "+emp_id));

        employees.setAddress(address);
        return mapper.toemployeesWithAddressDto(empRepo.save(employees));
    }

    public List<EmployeesWithAddressDto> getEmployessAddress(){
        return empRepo.findEmployeesWithAddress();
    }

    public List<EmployeesTaskProjection> getEmployeesWithTaskByProjectId(int projectId){
        return empRepo.findTasksEmployees(projectId);
    }

}
