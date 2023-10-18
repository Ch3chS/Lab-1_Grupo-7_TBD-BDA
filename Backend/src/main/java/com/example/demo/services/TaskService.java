package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepo;

/**
 * Lógica detras del modelo Task, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepo repo;

    /**
     * Creación de una tarea
     * Corresponde al Create del CRUD
     * @param task entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public Task create(Task task) {
        return repo.save(task);
    }

    /**
     * Obtener todas las tareas
     * @return todas las entidades de la tabla
     */
    public List<Task> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener tarea por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public Task getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualizar tarea por id
     * Corresponde al Update del CRUD
     * @param id id de la entidad
     * @return entidad actualizada (o null en caso de no encontrarse)
     */
    public Task update(Long id, Task taskDetails) {
        Task task = repo.findById(id).orElse(null);
        if (task != null) {
            task.setName(taskDetails.getName());
            task.setDescription(taskDetails.getDescription());
            return repo.save(task);
        }
        return null;
    }

    /**
     * Eliminar tarea por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        Task task = repo.findById(id).orElse(null);
        if (task != null) {
            repo.delete(task);
        }
    }
    
}