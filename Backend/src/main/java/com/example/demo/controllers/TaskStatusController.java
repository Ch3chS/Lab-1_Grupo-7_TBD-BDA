package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping()
    public ArrayList<TaskStatus> geTaskStatus(){
        return service.getTaskStatus();
    }

    @PostMapping()
    public void addTaskStatus(@RequestBody TaskStatus taskStatus){
        service.addTaskStatus(taskStatus);
    }

    @GetMapping(path = "/{id_taskStatus}")
    public Optional<TaskStatus> getTaskStatusById(@PathVariable("id") Long id_taskStatus){
        return this.service.getById(id_taskStatus);
    }

    @DeleteMapping(path = "/{id_taskStatus}")
    public String deleteById(@PathVariable("id_taskStatus") Long id_taskStatus) {
        boolean op = this.service.deleteTaskStatus(id_taskStatus);
        if(op) {
            return "TaskStatus eliminado correctamente";
        }
        else {
            return "No se ha podido eliminar el TaskStatus";
        }
    }
}
