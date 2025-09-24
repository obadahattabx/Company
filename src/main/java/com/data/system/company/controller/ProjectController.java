package com.data.system.company.controller;

import com.data.system.company.exceptions.ResourceNotFoundException;
import com.data.system.company.model.dto.ProjectDTO;
import com.data.system.company.model.entity.Project;
import com.data.system.company.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    @PostMapping("/addProject")
    public ResponseEntity<Project>  addProjct(@RequestBody Project project){
        Project project1=projectService.addProject(project);
        return  new ResponseEntity<>(project1, HttpStatus.OK);
    }

    @GetMapping("/getProjectById")
    public ResponseEntity<Project> getprojectbyid(@RequestParam int projectId){

        Project project=projectService.getProjectById(projectId)
                .orElseThrow(()->new ResourceNotFoundException("not found project by id: "+projectId));
        return new ResponseEntity<>(project,HttpStatus.OK);
    }

    @DeleteMapping("/deleteProject")
    public ResponseEntity<?> deleteprojectbyid(@RequestParam int projectId){
        projectService.deleteProjectById(projectId);
        return new ResponseEntity<>(new DepartmentController.MessageResponse("success delete"),HttpStatus.OK);
    }

    @GetMapping("/getAllProject")
    public ResponseEntity<List<ProjectDTO>> getAllProject(){
        return new ResponseEntity<>(projectService.getAllProject(),HttpStatus.OK);
    }

}
