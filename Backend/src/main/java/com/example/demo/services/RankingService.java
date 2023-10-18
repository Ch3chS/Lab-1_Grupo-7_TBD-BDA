package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Ranking;
import com.example.demo.repositories.RankingRepo;

/**
 * Lógica detras del modelo Ranking, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class RankingService {
  
    @Autowired
    private RankingRepo repo;

    /**
     * Creación de un ranking
     * Corresponde al Create del CRUD
     * @param ranking entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public Ranking create(Ranking ranking) {
        return repo.save(ranking);
    }

    /**
     * Obtener todas los rankings
     * @return todas las entidades de la tabla
     */
    public List<Ranking> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener Ranking por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public Ranking getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualizar Ranking por id
     * Corresponde al Update del CRUD
     * @param id id de la entidad
     * @return entidad actualizada (o null en caso de no encontrarse)
     */
    public Ranking update(Long id, Ranking rankingDetails) {
        Ranking ranking = repo.findById(id).orElse(null);
        if (ranking != null) {
            ranking.setScore(rankingDetails.getScore());
            return repo.save(ranking);
        }
        return null;
    }

    /**
     * Eliminar Ranking por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        Ranking ranking = repo.findById(id).orElse(null);
        if (ranking != null) {
            repo.delete(ranking);
        }
    }

}