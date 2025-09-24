package com.data.system.company.service;


import com.data.system.company.exceptions.ResourceNotFoundException;
import com.data.system.company.model.dto.ProjectDTO;
import com.data.system.company.model.entity.Project;
import com.data.system.company.model.mapper.Mapper;
import com.data.system.company.reporistary.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private Mapper mapper;


    public Project addProject(Project project){
        return projectRepo.save(project);
    }

    public Optional<Project> getProjectById(int id){
        return projectRepo.findById(id);
    }
    public void deleteProjectById(int id){
        Project project=projectRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("project not found by id :"+id));
        projectRepo.delete(project);
    }
    public List<ProjectDTO> getAllProject(){
        List<Project> projects=projectRepo.findAll();
        if(projects.isEmpty())
            throw new ResourceNotFoundException("not found projects");
        List<ProjectDTO> projectDTO=projects.stream()
                .map(p->mapper.toProjectDto(p))
                .collect(Collectors.toList());

        return projectDTO;
    }

}
