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

    @Autowired
    private RankingService rankingService;

    @Autowired
    private VoluntaryRequirementService voluntaryRequirementService;

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
     * Obtener voluntario por rut
     * Corresponde al Read del CRUD
     * @param rut rut del voluntario
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public Voluntary getById(String rut) {
        return repo.findById(rut).orElse(null);
    }

    /**
     * Actualizar voluntario por rut
     * Corresponde al Update del CRUD
     * @param rut rut del voluntario
     * @return entidad actualizada (o null en caso de no encontrarse)
     */
    public Voluntary update(String rut, Voluntary voluntaryDetails) {
        Voluntary voluntary = repo.findById(rut).orElse(null);
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
     * Eliminar voluntario por rut
     * Corresponde al Delete del CRUD
     * @param rut rut del voluntario
     */
    public void delete(String rut) {
        Voluntary voluntary = repo.findById(rut).orElse(null);
        if (voluntary != null) {
            // Eliminar todas las entidades relacionadas en la clase Ranking
            rankingService.deleteByRutVoluntary(rut);

            // Eliminar todas las entidades relacionadas en la clase VoluntaryRequirement
            voluntaryRequirementService.deleteByRutVoluntary(rut);

            // Finalmente, eliminar el voluntario
            repo.delete(voluntary);
        }
    }

}
