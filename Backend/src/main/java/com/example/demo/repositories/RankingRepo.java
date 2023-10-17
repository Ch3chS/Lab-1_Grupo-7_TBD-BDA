package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Ranking;

@RepositoryRestResource
public interface RankingRepo extends JpaRepository<Ranking, Long> {
    
}
