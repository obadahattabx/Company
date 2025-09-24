package com.data.system.company.controller;

import com.data.system.company.model.dto.TasksDTO;
import com.data.system.company.model.entity.Tasks;
import com.data.system.company.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<TasksDTO>> getAllTasks(){
        return  new ResponseEntity<>(tasksService.getAllTasks(), HttpStatus.OK);
    }

    @PostMapping("/addTasks")
    public ResponseEntity<TasksDTO> addTasks(@RequestBody TasksDTO tasks){
        return new ResponseEntity<>(tasksService.addTask(tasks),HttpStatus.OK);
    }
}
