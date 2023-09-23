package com.postgresql.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estado_tarea")
public class Estado_tarea {
    @Id
    private long id;
    private String nombre;
}
