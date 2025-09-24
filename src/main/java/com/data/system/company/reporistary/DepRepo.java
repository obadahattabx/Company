package com.data.system.company.reporistary;

import com.data.system.company.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface DepRepo extends JpaRepository<Department,Integer> {

    @Query(value = "SELECT * FROM department where name= :name", nativeQuery = true)
    List<Department> findByName(@Param("name") String name);

    @Query("SELECT d FROM Department d WHERE SIZE(d.employeesList) > :minEmployees")
    List<Department> findDepartmentWithMinEmp(@Param("minEmployees")int minEmployees);

}
