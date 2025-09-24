package com.data.system.company.reporistary;

import com.data.system.company.model.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TasksRepo extends JpaRepository<Tasks,Integer> {
}
