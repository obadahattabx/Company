package com.data.system.company.reporistary;

import com.data.system.company.model.dto.EmployeesWithAddressDto;
import com.data.system.company.model.entity.Employees;
import com.data.system.company.model.projection.EmployeesTaskProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employees,Integer> {

    @Query(value = "SELECT e from Employees e join e.projectList p  where p.id= :projectId")
    List<Employees> findByProjectId(int projectId);

    @Query("SELECT new com.data.system.company.model.dto.EmployeesWithAddressDto(" +
            "e.id, e.firstname, e.lastname, e.email, e.phoneNumber ,e.salary , " +
            "new com.data.system.company.model.dto.AddressDto(a.id, a.city, a.streetAddress, a.postalCode)) " +
            "FROM Employees e JOIN e.address a")
    List<EmployeesWithAddressDto>findEmployeesWithAddress();


    @Query(value = "SELECT e FROM Employees e JOIN e.tasks t where t.project.id= :projectId")
    List<EmployeesTaskProjection>findTasksEmployees(@Param("projectId")int projectId);


}
