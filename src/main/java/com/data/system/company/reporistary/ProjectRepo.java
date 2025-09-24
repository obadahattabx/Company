package com.data.system.company.reporistary;

import com.data.system.company.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
