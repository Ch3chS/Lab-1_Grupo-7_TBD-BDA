package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.TaskStatus;
import com.example.demo.services.TaskStatusService;

@RestController
@RequestMapping("/taskStatus")
public class TaskStatusController {

    @Autowired
    TaskStatusService service;

    @PostMapping()
    public void createTaskStatus(@RequestBody TaskStatus taskStatus){
        service.create(taskStatus);
    }

    @GetMapping()
    public List<TaskStatus> geTaskStatus(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public TaskStatus getTaskStatusById(@PathVariable("id") Long id_taskStatus){
        return this.service.getById(id_taskStatus);
    }

    @PutMapping("/{id}")
    public TaskStatus updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatus taskStatus) {
        return service.update(id, taskStatus);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTaskStatus(@PathVariable("id_taskStatus") Long id_taskStatus) {
        service.delete(id_taskStatus);
        
    }
}
