package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TaskStatus;
import com.example.demo.repositories.TaskStatusRepo;

@Service
public class TaskStatusService {
    @Autowired
    TaskStatusRepo repo;

    public ArrayList<TaskStatus> getTaskStatus(){
        return (ArrayList<TaskStatus>)repo.findAll();
    }

    public TaskStatus addTaskStatus(TaskStatus taskStatus){
        return repo.save(taskStatus);
    }

    public Optional<TaskStatus> getById(Long id_taskStatus){
        return repo.findById(id_taskStatus);
    }

    public boolean deleteTaskStatus(Long id_taskStatus) {
        try{
            repo.deleteById(id_taskStatus);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
