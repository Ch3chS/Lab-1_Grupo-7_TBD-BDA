package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.EmergencyRequirement;

@RepositoryRestResource
public interface EmergencyRequirementRepo extends JpaRepository<EmergencyRequirement, Long> {
    
}
