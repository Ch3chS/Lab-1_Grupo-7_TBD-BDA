package com.example.demo.controllers;

import com.example.demo.models.Voluntary;
import com.example.demo.services.VoluntaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo Voluntary
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/voluntaries")
public class VoluntaryController {

    @Autowired
    private VoluntaryService service;

    /**
     * Crea un nuevo voluntario.
     * @param voluntary El voluntario a crear.
     * @return El voluntario creado.
     */
    @PostMapping
    public Voluntary createVoluntary(@RequestBody Voluntary voluntary) {
        return service.create(voluntary);
    }

    /**
     * Obtiene todos los voluntarios.
     * @return Una lista de todos los voluntarios.
     */
    @GetMapping
    public List<Voluntary> getAllVoluntaries() {
        return service.getAll();
    }

    /**
     * Obtiene un voluntario por su ID.
     * @param id El ID del voluntario a obtener.
     * @return El voluntario con el ID especificado.
     */
    @GetMapping("/{id}")
    public Voluntary getVoluntaryById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Actualiza un voluntario existente.
     * @param id El ID del voluntario a actualizar.
     * @param voluntary El voluntario actualizado.
     * @return El voluntario actualizado.
     */
    @PutMapping("/{id}")
    public Voluntary updateVoluntary(@PathVariable Long id, @RequestBody Voluntary voluntary) {
        return service.update(id, voluntary);
    }

    /**
     * Elimina un voluntario por su ID.
     * @param id El ID del voluntario a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteVoluntary(@PathVariable Long id) {
        service.delete(id);
    }
}
