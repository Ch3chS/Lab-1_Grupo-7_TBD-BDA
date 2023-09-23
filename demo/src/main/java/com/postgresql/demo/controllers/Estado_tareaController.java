package com.postgresql.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.demo.model.Estado_tarea;
import com.postgresql.demo.repo.Estado_tareaRepo;

@RestController
public class Estado_tareaController {
    @Autowired
    Estado_tareaRepo repo;

    @PostMapping("/addEstado_tarea")
    public void addEstado_tarea(@RequestBody Estado_tarea estado_tarea){
        repo.save(estado_tarea);
    }
}
