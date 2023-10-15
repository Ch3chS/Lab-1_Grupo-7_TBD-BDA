package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Emergency;

@RepositoryRestResource
public interface EmergencyRepo extends JpaRepository<Emergency, Long> {
    
}
