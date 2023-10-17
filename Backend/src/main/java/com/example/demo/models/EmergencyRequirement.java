package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde a la tabla intermedia entre los modelos Emergency y Requirement
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "emergencyRequirement")
public class EmergencyRequirement {
    
    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con la id de la tabla intermedia, la cual se genera automáticamente de forma creciente.
     * Es única para cada una
     * No puede ser nula
     * (Realmente se hizo porque la entidad exije una etiqueta @Id)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_emergencyRequirement;

    /**
     * Columna con id de la emergencia asociada.
     * Es una llave foránea que hace referencia a la columna id_emergency del modelo Emergency.
     */
    @ManyToOne
    @JoinColumn(name = "id_emergency", referencedColumnName = "id_emergency", nullable = false)
    private Emergency emergency;

    /**
     * Columna con la id del requisito asociado.
     * Es una llave foránea que hace referencia a la columna id_requirement del modelo Requirement.
     */
    @ManyToOne
    @JoinColumn(name = "id_requirement", referencedColumnName = "id_requirement", nullable = false)
    private Requirement requirement;


    // ----------------------------------------- Métodos -----------------------------------------------------



}
