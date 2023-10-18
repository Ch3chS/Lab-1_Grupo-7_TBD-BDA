package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Emergency;
import com.example.demo.repositories.EmergencyRepo;

import java.util.List;

/**
 * Lógica detras del modelo Emergency, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class EmergencyService {

    @Autowired
    private EmergencyRepo repo;

    /**
     * Creación de una emergencia
     * Corresponde al Create del CRUD
     * @param emergency entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public Emergency create(Emergency emergency) {
        return repo.save(emergency);
    }

    /**
     * Obtener todas las emergencias
     * @return todas las entidades de la tabla
     */
    public List<Emergency> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener emergencia por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public Emergency getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualizar emergencia por id
     * Corresponde al Update del CRUD
     * @param id id de la entidad
     * @return entidad actualizada (o null en caso de no encontrarse)
     */
    public Emergency update(Long id, Emergency emergencyDetails) {
        Emergency emergency = repo.findById(id).orElse(null);
        if (emergency != null) {
            emergency.setDescription(emergencyDetails.getDescription());
            emergency.setDate(emergencyDetails.getDate());
            emergency.setActive(emergencyDetails.getActive());
            emergency.setId_institution(emergencyDetails.getId_institution());
            return repo.save(emergency);
        }
        return null;
    }

    /**
     * Eliminar emergencia por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        Emergency emergency = repo.findById(id).orElse(null);
        if (emergency != null) {
            repo.delete(emergency);
        }
    }
    
}
