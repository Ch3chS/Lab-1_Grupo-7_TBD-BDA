package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TaskStatus;
import com.example.demo.repositories.TaskStatusRepo;

@Service
public class TaskStatusService {
    @Autowired
    TaskStatusRepo repo;

    public TaskStatus create(TaskStatus taskStatus){
        return repo.save(taskStatus);
    }

    public List<TaskStatus> getAll(){
        return repo.findAll();
    }

    public TaskStatus getById(Long id){
        return repo.findById(id).orElse(null);
    }

    public TaskStatus update(Long id, TaskStatus taskStatusDetails) {
        TaskStatus taskStatus = repo.findById(id).orElse(null);
        if(taskStatus != null) {
            taskStatus.setName(taskStatusDetails.getName());
            return repo.save(taskStatus);
        }
        return null;
    }

    public void delete(Long id) {
        TaskStatus taskStatus = repo.findById(id).orElse(null);
        if(taskStatus != null){
            repo.delete(taskStatus);
        }
    }

}
