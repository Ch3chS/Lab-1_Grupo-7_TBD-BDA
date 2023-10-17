package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.VoluntaryRequirement;

@RepositoryRestResource
public interface VoluntaryRequirementRepo extends JpaRepository<VoluntaryRequirement, Long> {
    
}
