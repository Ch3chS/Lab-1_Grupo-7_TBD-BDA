package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "taskStatus")
public class TaskStatus {

    // ----------------------------------------- Atributos --------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_taskStatus;

    @Column(unique = true, nullable = false)
    private String name;


    // ----------------------------------------- Métodos -----------------------------------------------------

    public Long getId_taskStatus() {
        return id_taskStatus;
    }

    public void setId_user(Long id_taskStatus) {
        this.id_taskStatus = id_taskStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
