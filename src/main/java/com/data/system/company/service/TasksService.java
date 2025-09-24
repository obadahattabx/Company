package com.data.system.company.service;


import com.data.system.company.exceptions.ResourceNotFoundException;
import com.data.system.company.model.dto.EmployeesDTO;
import com.data.system.company.model.dto.ProjectDTO;
import com.data.system.company.model.dto.TasksDTO;
import com.data.system.company.model.entity.Employees;
import com.data.system.company.model.entity.Project;
import com.data.system.company.model.entity.Tasks;
import com.data.system.company.model.mapper.Mapper;
import com.data.system.company.reporistary.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksService {

    @Autowired
    private TasksRepo tasksRepo;

    @Autowired
    private EmployessService employessService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private Mapper mapper;

    public TasksDTO addTask(TasksDTO tasksdto){
        Employees employees=employessService.getEmpolyeesbyid(tasksdto.getEmpolyeesId());
        Project project=projectService.getProjectById(tasksdto.getProjectId())
                .orElseThrow(()->new ResourceNotFoundException("not found project by id: "+tasksdto.getProjectId()));
        Tasks tasks=Tasks.builder()
                .title(tasksdto.getTitle())
                .priority(tasksdto.getPriority())
                .desc(tasksdto.getDesc())
                .estaimatedHours(tasksdto.getEstaimatedHours())
                .employees(employees)
                .project(project)
                .build();


        return mapper.tasksDTO(tasksRepo.save(tasks));
    }
    public List<TasksDTO> getAllTasks(){
        List<Tasks> tasks=tasksRepo.findAll();
        if(tasks.isEmpty())
            throw new ResourceNotFoundException("not founds Tasks");
        List<TasksDTO> tasksDTO=tasks.stream()
                .map(t->mapper.tasksDTO(t)).collect(Collectors.toList());


        return tasksDTO;
    }

}
