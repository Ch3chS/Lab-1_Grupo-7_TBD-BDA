package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Voluntary;
import com.example.demo.repositories.VoluntaryRepo;

/**
 * Lógica detras del modelo Voluntary, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class VoluntaryService {
    
    @Autowired
    private VoluntaryRepo repo;

    /**
     * Creación de una voluntary
     * Corresponde al Create del CRUD
     * @param voluntary entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public Voluntary create(Voluntary voluntary) {
        return repo.save(voluntary);
    }

    /**
     * Obtener todos los voluntarios
     * @return todas las entidades de la tabla
     */
    public List<Voluntary> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener voluntario por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public Voluntary getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualizar voluntario por id
     * Corresponde al Update del CRUD
     * @param id id de la entidad
     * @return entidad actualizada (o null en caso de no encontrarse)
     */
    public Voluntary update(Long id, Voluntary voluntaryDetails) {
        Voluntary voluntary = repo.findById(id).orElse(null);
        if (voluntary != null) {
            voluntary.setName(voluntaryDetails.getName());
            voluntary.setLastnames(voluntaryDetails.getLastnames());
            voluntary.setEmail(voluntaryDetails.getEmail());
            voluntary.setPhone(voluntaryDetails.getPhone());
            voluntary.setAvaible(voluntaryDetails.getAvaible());
            voluntary.setPassword(voluntaryDetails.getPassword());
            return repo.save(voluntary);
        }
        return null;
    }

    /**
     * Eliminar voluntario por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        Voluntary voluntary = repo.findById(id).orElse(null);
        if (voluntary != null) {
            repo.delete(voluntary);
        }
    }

}
