package com.postgresql.demo.repo;

import com.postgresql.demo.model.Estado_tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface Estado_tareaRepo extends JpaRepository<Estado_tarea, Long>{
    
}
