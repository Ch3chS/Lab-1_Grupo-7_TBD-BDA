package com.example.demo.controllers;

import com.example.demo.models.Emergency;
import com.example.demo.services.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo Emergency
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/emergencies")
public class EmergencyController {

    @Autowired
    private EmergencyService service;

    @PostMapping
    public Emergency createEmergency(@RequestBody Emergency emergency) {
        return service.create(emergency);
    }

    @GetMapping
    public List<Emergency> getAllEmergencies() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Emergency getEmergencyById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Emergency updateEmergency(@PathVariable Long id, @RequestBody Emergency emergency) {
        return service.update(id, emergency);
    }

    @DeleteMapping("/{id}")
    public void deleteEmergency(@PathVariable Long id) {
        service.delete(id);
    }
}
