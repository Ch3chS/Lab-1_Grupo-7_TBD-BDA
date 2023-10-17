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
 * Este modelo corresponde al del ranking de un voluntario para una tarea
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "ranking")
public class Ranking {
    
    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con la id del ranking, la cual se genera automáticamente de forma creciente.
     * Es única para cada ranking
     * No puede ser nula
     * (Realmente se hizo porque la entidad exije una etiqueta @Id)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_ranking;

    /**
     * Columna con el puntaje del voluntario para una tarea.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    int score;

    /**
     * Columna con el rut del voluntario que tiene el puntaje.
     * Es una llave foránea que hace referencia a la columna rut del modelo Voluntary.
     */
    @ManyToOne
    @JoinColumn(name = "rut_voluntary", referencedColumnName = "rut", nullable = false)
    private Voluntary voluntary;

    /**
     * Columna con la id de la tarea asociada.
     * Es una llave foránea que hace referencia a la columna id_task del modelo Task.
     */
    @ManyToOne
    @JoinColumn(name = "id_task", referencedColumnName = "id_task", nullable = false)
    private Task task;


    // ----------------------------------------- Métodos -----------------------------------------------------

    /**
     * Método que permite obtener el puntaje del usuario para la tarea
     * @return puntaje del usuario (un valor de tipo int)
     */
    public int getScore() {
        return score;
    }

    /**
     * Método que permite actualizar el puntaje del usuario para la tarea
     * @param score nueva id para la emergencia (de tipo Long)
     */
    public void setScore(int score) {
        this.score = score;
    }

}
